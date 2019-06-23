package t2_the_roller_coaster_problem;

import java.util.concurrent.Semaphore;

public class MainRCP {
	
	public MainRCP() {};
	
	public static void main(String[] args) {
		int maxPass = 3;
		
		Semaphore mutex = new Semaphore(1);
		Semaphore mutex2 = new Semaphore(1);
		
		Semaphore boardQueue = new Semaphore(0);
		Semaphore unboardQueue = new Semaphore(0);
		
		Semaphore allAboard = new Semaphore(0);
		Semaphore allAshore = new Semaphore(0);
		
		RollerCoaster carRC = new RollerCoaster(maxPass, boardQueue, unboardQueue, allAboard, allAshore);
		Passenger pass1 = new Passenger("1. Abel", maxPass, mutex, mutex2, boardQueue, unboardQueue, allAboard, allAshore);
		Passenger pass2 = new Passenger("2. Bezebu", maxPass, mutex, mutex2, boardQueue, unboardQueue, allAboard, allAshore);
		Passenger pass3 = new Passenger("3. Cain", maxPass, mutex, mutex2, boardQueue, unboardQueue, allAboard, allAshore);
		Passenger pass4 = new Passenger("4. Dante", maxPass, mutex, mutex2, boardQueue, unboardQueue, allAboard, allAshore);
		Passenger pass5 = new Passenger("5. Exodia", maxPass, mutex, mutex2, boardQueue, unboardQueue, allAboard, allAshore);
		
		pass1.start();
		pass2.start();
		pass3.start();
		pass4.start();
		pass5.start();
		
		carRC.start();
	}
}

/* car wait semFillp1
 * car wait semFillp2
 * car signal semInputp1
 * car signal semInputp2
 * car run
 * 
 * p1 wait semInputp1
 * p1 signal semFillp1
 * p1 run
 * 
 * p2 wait semInputp2
 * p2 signal semFillp2
 * p2 run
 */