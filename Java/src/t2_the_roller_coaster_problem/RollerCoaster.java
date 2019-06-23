package t2_the_roller_coaster_problem;

import java.util.concurrent.Semaphore;

public class RollerCoaster extends Thread {
	
	int maxPass;
	Semaphore boardQueue, unboardQueue, allAboard, allAshore;
	
	public RollerCoaster(int maxPass, Semaphore boardQueue, Semaphore unboardQueue, Semaphore allAboard, Semaphore allAshore) {
		this.maxPass = maxPass;
		this.boardQueue = boardQueue;
		this.unboardQueue = unboardQueue;
		this.allAboard = allAboard;
		this.allAshore = allAshore;
	}

	public void run() {
		
		while(true) {
			//load();
			System.out.println("carro disponível");
			
			boardQueue.release(maxPass);
			
			try {
				allAboard.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			//run();
			System.out.println("carro partindo");
			//unload();
			System.out.println("carro retornando");
			
			unboardQueue.release(maxPass);
			
			try {
				allAshore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("carro descarregado");
		}
	}
}