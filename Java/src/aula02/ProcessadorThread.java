package aula02;

import java.util.concurrent.Semaphore;

public class ProcessadorThread extends Thread{

	int id;
	Semaphore semaforo;
	
	public ProcessadorThread(int id, Semaphore semaforo) {
		this.id = id;
		this.semaforo = semaforo;
	}
	
	private void processar() {
		long tempo = (long)(Math.random()*5000);
		try {
			System.out.println("Thread "+id+" processando" );
			Thread.sleep(tempo);
			System.out.println("Thread "+id+" conclu�da" );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void regiaoNaoCritica() {
		System.out.println("Thread "+id+" entrou na regi�o nao cr�tica");
		this.processar();
		System.out.println("Thread "+id+" saiu da regi�o nao cr�tica");
	}
	
	private void regiaoCritica() {
		System.out.println("Thread "+id+" entrou na regi�o cr�tica");
		this.processar();
		System.out.println("Thread "+id+" saiu da regi�o cr�tica");
	}	
	
	/* devemos extender a classe Thread, sobrescrever o m�todo run e usar
	 * start para dar run na thread */
	public void run() {
		this.regiaoNaoCritica();
		//wait
		try {
			System.out.println("Thread "+id+" permits: " + this.semaforo.availablePermits());
			this.semaforo.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.regiaoCritica();
		//signal
		this.semaforo.release();
	}
	
}