package t2_the_roller_coaster_problem;

import java.util.concurrent.Semaphore;

public class Passenger extends Thread {
	
	int maxPass;
	String namePass;
	static int boarders, unboarders;
	Semaphore mutex, mutex2, boardQueue, unboardQueue, allAboard, allAshore;	
	
	public Passenger(String namePass, int qtdPass, Semaphore mutex,
			Semaphore mutex2, Semaphore boardQueue, Semaphore unboardQueue,
			Semaphore allAboard, Semaphore allAshore) {
		this.namePass = namePass;
		this.maxPass = qtdPass;
		this.mutex = mutex;
		this.mutex2 = mutex2;
		this.boardQueue = boardQueue;
		this.unboardQueue = unboardQueue;
		this.allAboard = allAboard;
		this.allAshore = allAshore;
	}
	
	public void board() {
		try {	
			boardQueue.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("  " + namePass + " - embarcando");
		
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		boarders += 1;
		
		if(boarders == this.maxPass) {
			allAboard.release();
			boarders = 0;
		}
		
		mutex.release();
	}
	
	public void unboard() {
		try {
			unboardQueue.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("  " + namePass + " - desembarcando");
		
		try {
			mutex2.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		unboarders += 1;
		if(unboarders == maxPass) { 
			allAshore.release();
			unboarders = 0;
		}

		mutex2.release();
	}
	
	public void run() {
		while(true) {
			board();
			unboard();
		}
	}
}