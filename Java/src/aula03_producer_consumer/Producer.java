package aula03_producer_consumer;

import java.util.concurrent.Semaphore;

public class Producer extends Thread{

	int[] vetp;
	String name;
	Semaphore sp, sc;
	
	public Producer(String name, Semaphore sp, Semaphore sc) {
		this.name = name;
		this.sp = sp;
		this.sc = sc;
	}
	
	public void produzir() {
		long tempo = (long)(500);
		try {
			System.out.println("Produtor "+ name +" produzindo" );
			Thread.sleep(tempo);
			System.out.println("Produtor "+ name +" produziu" );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		while(true) {
			try {
				System.out.println("P try");
				this.sp.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			produzir();
			this.sc.release();
		}
		
	}
	
}