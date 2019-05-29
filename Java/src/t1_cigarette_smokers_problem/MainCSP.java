package t1_cigarette_smokers_problem;

import java.util.concurrent.Semaphore;

public class MainCSP {

	public MainCSP() {}
	
	public static void main(String[] args) {	
		
		Semaphore semAgent = new Semaphore(1);
		Semaphore semTobacco = new Semaphore(0);
		Semaphore semPaper = new Semaphore(0);
		Semaphore semMatch = new Semaphore(0);
		
		Agent tpAgent = new Agent("AgenteTP", semAgent, semTobacco, semPaper);
		Agent pmAgent = new Agent("AgentePM", semAgent, semPaper, semMatch);
		Agent mtAgent = new Agent("AgenteMT", semAgent, semMatch, semTobacco);
		
		Smoker tSmoker = new Smoker("SmokerTob", semAgent, semPaper, semMatch);
		Smoker pSmoker = new Smoker("SmokerPap", semAgent, semTobacco, semMatch);
		Smoker mSmoker = new Smoker("SmokerMat", semAgent, semPaper, semTobacco);

		tpAgent.start();
		pmAgent.start();
		mtAgent.start();
		tSmoker.start();
		pSmoker.start();
		mSmoker.start();
	
	}
	
}
