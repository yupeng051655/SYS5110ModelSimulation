
import MiCazuelaSimModel.MiCazuela;
import MiCazuelaSimModel.Seeds;
import cern.jet.random.engine.*;
import outputAnalysis.ConfidenceInterval;

public class Experiment3 {
	
	static final int NUMRUNS = 10000;
	static final double CONF_LEVEL = 0.9;
    static final int [] NUM_RUNS_ARRAY = {20, 30, 40, 60, 80, 100, 1000, 10000};
    
    public static void main(String[] args) {
    	
    	int i; 
    	Seeds[] sds = new Seeds[NUMRUNS];
    	MiCazuela micazuela; 
    	
    	double [] output1 = new double[NUMRUNS];
	    double [] output2 = new double[NUMRUNS];
	    double [] output3 = new double[NUMRUNS];
	    
	    RandomSeedGenerator rsg = new RandomSeedGenerator();
	    for(i=0 ; i<NUMRUNS ; i++) sds[i] = new Seeds(rsg);
	    
	    int numWaiter = 2;
	    int numCook = 2;
	    int numTableFour = 5;
	    boolean handHeldDevices = false;
	    
	    for(int k=numTableFour ; k >= 1 ; k--) {
	    	
	    	for(i=0 ; i < NUMRUNS ; i++) {
		    	micazuela = new MiCazuela(sds[i], numWaiter, numCook, k, handHeldDevices, false);
		    	micazuela.runSimulation();
		    	output1[i] = micazuela.getNumBalk();
		    	output2[i] = micazuela.getNumServed();
		    	output3[i] = micazuela.getPorfitPerDay();
		    	
		    }
		    
		    displayTable(output3, numWaiter, numCook, k, handHeldDevices);
	    	
	    }
	        
	    
    }
    
    private static void displayTable(double [] allValues, int numWaiter, int numCook, int numTableFour, boolean handHeldDevices) {
    	
    	System.out.printf("------------------------------------------------------------------\n");
	    System.out.printf("Case: numWaiter: "+numWaiter+" numCook: "+numCook+" numTableFour: "+numTableFour+" handHeldDevices: "+handHeldDevices+"\n");
	       System.out.printf("------------------------------------------------------------------\n");
	       System.out.printf("n        y(n)     s(n)     zeta(n)  CI Min   CI Max   zeta(n)/y(n)\n");
	       System.out.printf("------------------------------------------------------------------\n");
	       for(int ix1 = 0; ix1 < NUM_RUNS_ARRAY.length; ix1++)
	       {
	    	   int numruns = NUM_RUNS_ARRAY[ix1];
	    	   double [] values = new double[numruns];
	    	   for(int ix2 = 0 ; ix2 < numruns; ix2++) values[ix2] = allValues[ix2];
	    	   ConfidenceInterval ci = new ConfidenceInterval(values, CONF_LEVEL);
	    	   System.out.printf("%5d %8.2f %8.2f %8.2f %8.2f %8.2f %8.3f\n",
	    			               numruns, ci.getPointEstimate(), ci.getStdDev(), ci.getZeta(),
	    			               ci.getCfMin(), ci.getCfMax(), ci.getZeta()/ci.getPointEstimate());
	       }
	       System.out.printf("------------------------------------------------------------------\n");
    	
    }
	
	

}





















