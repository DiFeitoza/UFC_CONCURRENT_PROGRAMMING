package t1_cigarette_smokers_problem;
import java.util.concurrent.Semaphore;

public class Pusher extends Thread {

	Semaphore sM, sS1, sS2, sS3, sMutex;
	static boolean isTobacco = false, isPaper = false, isMatch = false;
	String mat;
	
	public Pusher (Semaphore sM, Semaphore sS1, Semaphore sS2, Semaphore sS3,
			Semaphore sMutex, String mat) {
		this.sM = sM;
		this.sS1 = sS1;
		this.sS2 = sS2;
		this.sS3 = sS3;
		this.sMutex = sMutex;
		this.mat = mat;
	}
	
	public void run () {
		
		while ( true ) {

			try {
				sM.acquire();
			}
			catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			try {
				sMutex.acquire();			
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if( mat == "tobacco" ) {
				if( isPaper ) {
					isPaper = false;
					sS3.release();
				}
				else if( isMatch ) {
					isMatch = false;
					sS2.release();
				}
				else {
					isTobacco = true;
				}
			}
			else if( mat == "paper" ) {
				if( isMatch ) {
					isMatch = false;
					sS1.release();
				}
				else if( isTobacco ) {
					isTobacco = false;
					sS3.release();
				}
				else {
					isPaper = true;
				}				
			}
			else {
				if( isTobacco ) {
					isTobacco = false;
					sS2.release();
				}
				else if( isPaper ) {
					isPaper = false;
					sS1.release();
				}
				else {
					isMatch = true;
				}
			}
		
			sMutex.release();
			
		}

	}
	
}
