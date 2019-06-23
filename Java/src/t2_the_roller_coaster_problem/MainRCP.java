package t2_the_roller_coaster_problem;

import java.util.concurrent.Semaphore;

public class MainRCP {
	
	public MainRCP() {};
	
	public static void main(String[] args) {
		int maxPass = 2;
		int qtdCar = 2;
		int idCar = 0;
		
		Semaphore mutex = new Semaphore(1);
		Semaphore mutex2 = new Semaphore(1);
		Semaphore semCar = new Semaphore(1);
		
		Semaphore boardQueue = new Semaphore(0);
		Semaphore unboardQueue = new Semaphore(0);
		
		Semaphore allAboard = new Semaphore(0);
		Semaphore allAshore = new Semaphore(0);
		
		RollerCoaster carRC1 = new RollerCoaster(
				"carRC1", idCar, qtdCar, maxPass, semCar, boardQueue,
				unboardQueue, allAboard, allAshore
		);
		RollerCoaster carRC2 = new RollerCoaster(
				"carRC2", idCar++, qtdCar, maxPass, semCar, boardQueue,
				unboardQueue, allAboard, allAshore
		);
		Passenger pass1 = new Passenger(
				"Abel", maxPass, mutex, mutex2, boardQueue, unboardQueue,
				allAboard, allAshore
		);
		Passenger pass2 = new Passenger(
				"Bezebu", maxPass, mutex, mutex2, boardQueue, unboardQueue,
				allAboard, allAshore
		);
		Passenger pass3 = new Passenger(
				"Cain", maxPass, mutex, mutex2, boardQueue, unboardQueue,
				allAboard, allAshore
		);
		Passenger pass4 = new Passenger(
				"Dante", maxPass, mutex, mutex2, boardQueue, unboardQueue,
				allAboard, allAshore
		);
		Passenger pass5 = new Passenger(
				"Exodia", maxPass, mutex, mutex2, boardQueue, unboardQueue,
				allAboard, allAshore
		);
		
		pass1.start();
		pass2.start();
		pass3.start();
		pass4.start();
		pass5.start();
		
		carRC1.start();
		carRC2.start();
	}
}