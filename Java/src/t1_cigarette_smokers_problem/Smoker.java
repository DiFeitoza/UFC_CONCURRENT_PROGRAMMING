package t1_cigarette_smokers_problem;

import java.util.concurrent.Semaphore;

public class Smoker extends Thread {
	
	String name;
	Semaphore sA, sS;
	
	public Smoker (String name, Semaphore sA, Semaphore sS) {
		this.name = name;
		this.sA = sA;
		this.sS = sS;
	}
	
	public void Fumar () {
		try {
			Thread.sleep((long)(3000));
			System.out.println(name + " enrolou o cigarro!");
			Thread.sleep((long)(2000));
			System.out.println(name + " acendeu o cigarro!");
			Thread.sleep((long)(5000));
			System.out.println(name + " fumou o cigarro!");
			Thread.sleep((long)(2000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run () {
		
		while(true) {
			try {
				this.sS.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.Fumar();
			this.sA.release();
		}
		
	}
	
}
