package t1_cigarette_smokers_problem;

import java.util.concurrent.Semaphore;

public class Smoker extends Thread {
	
	String name;
	Semaphore sA, s1, s2;
	
	public Smoker (String name, Semaphore sA, Semaphore s1, Semaphore s2) {
		this.name = name;
		this.sA = sA;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public void Fumar () {
		System.out.println(name + " conseguiu fumar!");
		this.sA.release();
	}
	
	public void run () {
		
		while(true) {
			try {
				this.s1.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("hello i'm a Smoker: " + name);
			
			try {
				this.s2.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.sA.release();
		}
		
	}
	
}
