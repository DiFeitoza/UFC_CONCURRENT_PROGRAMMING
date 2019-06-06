package t1_cigarette_smokers_problem;

import java.util.concurrent.Semaphore;

public class MainCSP {

	public MainCSP() {}
	
	public static void main(String[] args) {	
		
		Semaphore semAgent = new Semaphore(1);
		Semaphore semMutex = new Semaphore(1);
		
		Semaphore semTobacco = new Semaphore(0);
		Semaphore semPaper = new Semaphore(0);
		Semaphore semMatch = new Semaphore(0);	
		
		Semaphore tobacco = new Semaphore(0);
		Semaphore paper = new Semaphore(0);
		Semaphore match = new Semaphore(0);
		
		Agent tpAgent = new Agent("TOBACCO", "PAPER", semAgent, tobacco, paper);
		Agent pmAgent = new Agent("PAPER", "MATCH", semAgent, paper, match);
		Agent mtAgent = new Agent("MATCH", "TOBACCO", semAgent, match, tobacco);
		
		Smoker tSmoker = new Smoker("Smk TOBACCO", semAgent, semTobacco);
		Smoker pSmoker = new Smoker("Smk PAPER", semAgent, semPaper);
		Smoker mSmoker = new Smoker("Smk MATCH", semAgent, semMatch);
		
		Pusher tPusher = new Pusher(tobacco, semTobacco, semPaper, semMatch, semMutex, "tobacco");
		Pusher pPusher = new Pusher(paper, semTobacco, semPaper, semMatch, semMutex, "paper");
		Pusher mPusher = new Pusher(match, semTobacco, semPaper, semMatch, semMutex, "match");

		tpAgent.start();
		pmAgent.start();
		mtAgent.start();
		
		tSmoker.start();
		pSmoker.start();
		mSmoker.start();
		
		tPusher.start();
		pPusher.start();
		mPusher.start();
		
	}
	
}
