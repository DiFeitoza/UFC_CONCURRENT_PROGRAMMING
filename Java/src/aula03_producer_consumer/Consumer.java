package aula03_producer_consumer;

import java.util.concurrent.Semaphore;

public class Consumer extends Thread {
	
	int[] vetc;
	String name;
	Semaphore sc, sp;

	public Consumer(String name, Semaphore sc, Semaphore sp) {
		this.name = name;
		this.sc = sc;
		this.sp = sp;
	}
	
	public void consumir() {
		long tempo = (long)(1500);
		try {
			System.out.println("Consumidor "+ name +" consumindo" );
			Thread.sleep(tempo);
			System.out.println("Consumidor "+ name +" consumiu" );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		
		while(true) {
			try {
				System.out.println(name + " try");
				this.sc.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			consumir();
			this.sp.release();
		}
		
	}
	
}