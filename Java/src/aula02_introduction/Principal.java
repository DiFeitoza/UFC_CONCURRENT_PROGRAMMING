package aula02_introduction;

import java.util.concurrent.Semaphore;

public class Principal {
	
	public Principal(){}
	
	public static void main(String[] args) {
		
		Semaphore s1 = new Semaphore(2);
		
		ProcessadorThread pt1 = new ProcessadorThread(1, s1);
		ProcessadorThread pt2 = new ProcessadorThread(2, s1);
		ProcessadorThread pt3 = new ProcessadorThread(3, s1);
		
		pt1.start();
		pt2.start();
		pt3.start();
		
	}
	
}
