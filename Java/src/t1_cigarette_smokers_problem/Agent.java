package t1_cigarette_smokers_problem;

import java.util.concurrent.Semaphore;

public class Agent extends Thread {
	
	String name;
	Semaphore sA, s1, s2;
	
	public Agent (String name, Semaphore sA, Semaphore s1, Semaphore s2) {
		this.name = name;
		this.sA = sA;
		this.s1 = s1;
		this.s2 = s2;
	}
	
	public void run () {
		
		while(true) {
			try {
				this.sA.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello i'm an Agent " + name);
			this.s1.release();
			this.s2.release();
		}
		
	}
	
	
}
