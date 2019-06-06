package t1_cigarette_smokers_problem;

import java.util.concurrent.Semaphore;

public class Agent extends Thread {
	
	String mat1, mat2;
	Semaphore sA, s1, s2;
	
	public Agent (String mat1, String mat2, Semaphore sA, Semaphore s1, Semaphore s2) {
		this.mat1 = mat1;
		this.mat2 = mat2;
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
			this.s1.release();
			System.out.println("AGENTE forneceu " + mat1);
			this.s2.release();
			System.out.println("AGENTE forneceu " + mat2);
		}
		
	}
	
}
