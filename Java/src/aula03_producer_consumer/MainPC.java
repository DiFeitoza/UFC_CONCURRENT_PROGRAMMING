package aula03_producer_consumer;

import java.util.concurrent.Semaphore;

public class MainPC {
	
	public MainPC(){}
	
	public static void main(String[] args) {
		
		Semaphore sp = new Semaphore(1);
		Semaphore sc = new Semaphore(0);
		
		Producer p1 = new Producer("Jeff", sp, sc);
		Consumer c1 = new Consumer("Diego", sc, sp);
		Consumer c2 = new Consumer("James", sc, sp);
		Consumer c3 = new Consumer("Iesley", sc, sp);
		
		p1.start();
		c1.start();
		c2.start();
		c3.start();
		
	}
	
}
