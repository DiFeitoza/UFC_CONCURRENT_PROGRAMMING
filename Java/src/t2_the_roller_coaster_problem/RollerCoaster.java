package t2_the_roller_coaster_problem;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class RollerCoaster extends Thread {
	
	int idCar, maxPass, qtdCar;
	String nameCar;
	Semaphore semCar, boardQueue, unboardQueue, allAboard, allAshore;
	
	static ArrayList<Semaphore> loadingArea = new ArrayList<Semaphore>();
	static ArrayList<Semaphore> unloadingArea = new ArrayList<Semaphore>();
	
	public RollerCoaster(String nameCar, int idCar, int qtdCar, int maxPass, Semaphore semCar, Semaphore boardQueue, Semaphore unboardQueue, Semaphore allAboard, Semaphore allAshore) {
		this.nameCar = nameCar;
		this.qtdCar = qtdCar;
		this.maxPass = maxPass;
		this.semCar = semCar;
		this.boardQueue = boardQueue;
		this.unboardQueue = unboardQueue;
		this.allAboard = allAboard;
		this.allAshore = allAshore;
	}
		
	public int next(int idCar) {
		return (idCar + 1) % qtdCar;
	}
	
	public void load() {
		try {
			loadingArea.get(idCar).acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	

		System.out.println(nameCar + " - disponível");
		
		boardQueue.release(maxPass);
		
		try {
			allAboard.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		loadingArea.get(next(idCar)).release();
	}
	
	public void play() {
		System.out.println(nameCar + " - partindo");
	}
	
	public void unload() {
		try {
			unloadingArea.get(idCar).acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		System.out.println(nameCar + " - retornando");
		
		unboardQueue.release(maxPass);
		
		try {
			allAshore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(nameCar + " - livre");
		
		unloadingArea.get(next(idCar)).release();
	}
	
	public void run() {
		loadingArea.add(semCar);
		unloadingArea.add(semCar);
		
		while(true) {
			load();
			play();
			unload();
		}
	}
}