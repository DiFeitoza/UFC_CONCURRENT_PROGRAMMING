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
			System.out.println("Thread "+id+" concluída" );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void regiaoNaoCritica() {
		System.out.println("Thread "+id+" entrou na região nao crítica");
		this.processar();
		System.out.println("Thread "+id+" saiu da região nao crítica");
	}
	
	private void regiaoCritica() {
		System.out.println("Thread "+id+" entrou na região crítica");
		this.processar();
		System.out.println("Thread "+id+" saiu da região crítica");
	}	
	
	/* devemos extender a classe Thread, sobrescrever o método run e usar
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