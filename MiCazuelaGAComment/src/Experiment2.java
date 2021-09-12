
import MiCazuelaSimModel.MiCazuela;
import MiCazuelaSimModel.Seeds;
import cern.jet.random.engine.*;
import outputAnalysis.ConfidenceInterval;

public class Experiment2 {
	
	public static void main(String[] args) {
		
		
		// Constants
		final int NUMRUNS = 30;
		final double CONF_LEVEL = 0.9;  // Confidence levels
		
	     int i; 
	       
	     Seeds[] sds = new Seeds[NUMRUNS];
	     MiCazuela micazuela; 
	     
	     RandomSeedGenerator rsg = new RandomSeedGenerator();
	     for(i=0 ; i<NUMRUNS ; i++) sds[i] = new Seeds(rsg);
	     
	     int numWaiter;
	     int numCook;
	     boolean handHeldDevices;
	     
	     for(int k=0; k<=1; k++) {
	    	 
	    	 if(k==0) {
	    		 handHeldDevices = false; 
	    	 }
	    	 else {
	    		 handHeldDevices = true;
	    	 }
	     
	     
		     for(int j=5; j>=2; j--) {
		    	 
		    	 numWaiter = j;
		    	 numCook = j;
		    	 
		     
		    	 ConfidenceInterval cfIntCase1;
			     ConfidenceInterval cfIntCase2;
			     ConfidenceInterval cfIntCase3;
			     ConfidenceInterval cfIntCase4;
			     ConfidenceInterval cfIntCase5;
			     ConfidenceInterval cfIntCase6;
			     ConfidenceInterval cfIntCase7;
			     ConfidenceInterval cfIntCase8;
			     ConfidenceInterval cfIntCase9;
			     ConfidenceInterval cfIntCase10;
			     ConfidenceInterval cfIntCase11;
			     ConfidenceInterval cfIntCase12;
			     ConfidenceInterval cfIntCase13;
			     ConfidenceInterval cfIntCase14;
			     ConfidenceInterval cfIntCase15;
	
			     
			     double [] valuesCase1 = new double[NUMRUNS];
			     double [] valuesCase2 = new double[NUMRUNS];
			     double [] valuesCase3 = new double[NUMRUNS];
			     double [] valuesCase4 = new double[NUMRUNS];
			     double [] valuesCase5 = new double[NUMRUNS];
			     double [] valuesCase6 = new double[NUMRUNS];
			     double [] valuesCase7 = new double[NUMRUNS];
			     double [] valuesCase8 = new double[NUMRUNS];
			     double [] valuesCase9 = new double[NUMRUNS];
			     double [] valuesCase10 = new double[NUMRUNS];
			     double [] valuesCase11 = new double[NUMRUNS];
			     double [] valuesCase12 = new double[NUMRUNS];
			     double [] valuesCase13 = new double[NUMRUNS];
			     double [] valuesCase14 = new double[NUMRUNS];
			     double [] valuesCase15 = new double[NUMRUNS];
	
		    	 for(i=0 ; i < NUMRUNS ; i++) {
			    	 micazuela = new MiCazuela(sds[i], numWaiter, numCook, 5, handHeldDevices, false);
					 micazuela.runSimulation();
					 valuesCase1[i] = micazuela.getNumBalk();
					 valuesCase2[i] = micazuela.getNumServed();
					 valuesCase3[i] = micazuela.getPorfitPerDay();
					 
			    	 
			     }
		    	 
		    	 for(i=0 ; i < NUMRUNS ; i++) {
			    	 micazuela = new MiCazuela(sds[i], numWaiter, numCook, 4, handHeldDevices, false);
					 micazuela.runSimulation();
					 valuesCase4[i] = micazuela.getNumBalk();
					 valuesCase5[i] = micazuela.getNumServed();
					 valuesCase6[i] = micazuela.getPorfitPerDay();
					 
			    	 
			     }
		    	 
		    	 for(i=0 ; i < NUMRUNS ; i++) {
			    	 micazuela = new MiCazuela(sds[i], numWaiter, numCook, 3, handHeldDevices, false);
					 micazuela.runSimulation();
					 valuesCase7[i] = micazuela.getNumBalk();
					 valuesCase8[i] = micazuela.getNumServed();
					 valuesCase9[i] = micazuela.getPorfitPerDay();
					 
			    	 
			     }
		    	 
		    	 for(i=0 ; i < NUMRUNS ; i++) {
			    	 micazuela = new MiCazuela(sds[i], numWaiter, numCook, 2, handHeldDevices, false);
					 micazuela.runSimulation();
					 valuesCase10[i] = micazuela.getNumBalk();
					 valuesCase11[i] = micazuela.getNumServed();
					 valuesCase12[i] = micazuela.getPorfitPerDay();
					 
			    	 
			     }
		    	 
		    	 for(i=0 ; i < NUMRUNS ; i++) {
			    	 micazuela = new MiCazuela(sds[i], numWaiter, numCook, 1, handHeldDevices, false);
					 micazuela.runSimulation();
					 valuesCase13[i] = micazuela.getNumBalk();
					 valuesCase14[i] = micazuela.getNumServed();
					 valuesCase15[i] = micazuela.getPorfitPerDay();
					 
			    	 
			     }
			       
			     
			     cfIntCase1 = new ConfidenceInterval(valuesCase1, CONF_LEVEL);
			     cfIntCase2 = new ConfidenceInterval(valuesCase2, CONF_LEVEL);
			     cfIntCase3 = new ConfidenceInterval(valuesCase3, CONF_LEVEL);
			     cfIntCase4 = new ConfidenceInterval(valuesCase4, CONF_LEVEL);
			     cfIntCase5 = new ConfidenceInterval(valuesCase5, CONF_LEVEL);
			     cfIntCase6 = new ConfidenceInterval(valuesCase6, CONF_LEVEL);
			     cfIntCase7 = new ConfidenceInterval(valuesCase7, CONF_LEVEL);
			     cfIntCase8 = new ConfidenceInterval(valuesCase8, CONF_LEVEL);
			     cfIntCase9 = new ConfidenceInterval(valuesCase9, CONF_LEVEL);
			     cfIntCase10 = new ConfidenceInterval(valuesCase10, CONF_LEVEL);
			     cfIntCase11 = new ConfidenceInterval(valuesCase11, CONF_LEVEL);
			     cfIntCase12 = new ConfidenceInterval(valuesCase12, CONF_LEVEL);
			     cfIntCase13 = new ConfidenceInterval(valuesCase13, CONF_LEVEL);
			     cfIntCase14 = new ConfidenceInterval(valuesCase14, CONF_LEVEL);
			     cfIntCase15 = new ConfidenceInterval(valuesCase15, CONF_LEVEL);
			     
			     
			     System.out.printf("Case:");
			     System.out.printf("numWaiter: "+numWaiter+" numCook: "+numCook+" numTablesFour: 5, 4, 3, 2, 1  handHeldDevices: "+handHeldDevices+"\n");
			     System.out.printf("Run     numBalk  numServed  porfit | numBalk  numServed  porfit | numBalk  numServed  porfit | numBalk  "
			    		 				+"numServed  porfit | numBalk  numServed  porfit\n");
			     System.out.printf("-----------------------------------|----------------------------|----------------------------|"
			    		 				+"----------------------------|----------------------------\n");
			       // Simulation values
			       for(i = 0; i < valuesCase1.length; i++)
			           System.out.printf("%6d %8.0f %8.0f %10.3f %8.0f %8.0f %10.3f %8.0f %8.0f %10.3f %8.0f %8.0f %10.3f %8.0f %8.0f %10.3f\n",i+1, valuesCase1[i], valuesCase2[i], valuesCase3[i],
			        		   valuesCase4[i], valuesCase5[i], valuesCase6[i], valuesCase7[i], valuesCase8[i], valuesCase9[i], 
			        		   valuesCase10[i], valuesCase11[i], valuesCase12[i], valuesCase13[i], valuesCase14[i], valuesCase15[i]);
			       
			    // Confidence intervals
			       System.out.printf("-----------------------------------|----------------------------|----------------------------|"
			 				+"----------------------------|----------------------------\n");
			       System.out.printf("    PE  %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f\n", cfIntCase1.getPointEstimate(), cfIntCase2.getPointEstimate(), cfIntCase3.getPointEstimate(),
			    		   cfIntCase4.getPointEstimate(), cfIntCase5.getPointEstimate(), cfIntCase6.getPointEstimate(),
			    		   cfIntCase7.getPointEstimate(), cfIntCase8.getPointEstimate(), cfIntCase9.getPointEstimate(),
			    		   cfIntCase10.getPointEstimate(), cfIntCase11.getPointEstimate(), cfIntCase12.getPointEstimate(),
			    		   cfIntCase13.getPointEstimate(), cfIntCase14.getPointEstimate(), cfIntCase15.getPointEstimate());
			       System.out.printf("  S(n)  %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f\n", cfIntCase1.getStdDev(), cfIntCase2.getStdDev(), cfIntCase3.getStdDev(),
			    		   cfIntCase4.getStdDev(), cfIntCase5.getStdDev(), cfIntCase6.getStdDev(),
			    		   cfIntCase7.getStdDev(), cfIntCase8.getStdDev(), cfIntCase9.getStdDev(),
			    		   cfIntCase10.getStdDev(), cfIntCase11.getStdDev(), cfIntCase12.getStdDev(),
			    		   cfIntCase13.getStdDev(), cfIntCase14.getStdDev(), cfIntCase15.getStdDev());
			       System.out.printf("  zeta  %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f\n", 
			    		   cfIntCase1.getZeta(), cfIntCase2.getZeta(), cfIntCase3.getZeta(),
			    		   cfIntCase4.getZeta(), cfIntCase5.getZeta(), cfIntCase6.getZeta(),
			    		   cfIntCase7.getZeta(), cfIntCase8.getZeta(), cfIntCase9.getZeta(),
			    		   cfIntCase10.getZeta(), cfIntCase11.getZeta(), cfIntCase12.getZeta(),
			    		   cfIntCase13.getZeta(), cfIntCase14.getZeta(), cfIntCase15.getZeta());
			       System.out.printf("CI Min  %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f\n", 
			    		   cfIntCase1.getCfMin(), cfIntCase2.getCfMin(), cfIntCase3.getCfMin(),
			    		   cfIntCase4.getCfMin(), cfIntCase5.getCfMin(), cfIntCase6.getCfMin(),
			    		   cfIntCase7.getCfMin(), cfIntCase8.getCfMin(), cfIntCase9.getCfMin(),
			    		   cfIntCase10.getCfMin(), cfIntCase11.getCfMin(), cfIntCase12.getCfMin(),
			    		   cfIntCase13.getCfMin(), cfIntCase14.getCfMin(), cfIntCase15.getCfMin());
			       System.out.printf("CI Max  %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f\n", 
			    		   cfIntCase1.getCfMax(), cfIntCase2.getCfMax(), cfIntCase3.getCfMax(),
			    		   cfIntCase4.getCfMax(), cfIntCase5.getCfMax(), cfIntCase6.getCfMax(),
			    		   cfIntCase7.getCfMax(), cfIntCase8.getCfMax(), cfIntCase9.getCfMax(),
			    		   cfIntCase10.getCfMax(), cfIntCase11.getCfMax(), cfIntCase12.getCfMax(),
			    		   cfIntCase13.getCfMax(), cfIntCase14.getCfMax(), cfIntCase15.getCfMax());
			       System.out.printf("zeta/PE %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f   %8.3f %8.3f %8.3f\n",  cfIntCase1.getZeta()/cfIntCase1.getPointEstimate(),
			    		                                       cfIntCase2.getZeta()/cfIntCase2.getPointEstimate(),
			    		                                       cfIntCase3.getZeta()/cfIntCase3.getPointEstimate(),
			    		                                       cfIntCase4.getZeta()/cfIntCase4.getPointEstimate(),
			    		                                       cfIntCase5.getZeta()/cfIntCase5.getPointEstimate(),
			    		                                       cfIntCase6.getZeta()/cfIntCase6.getPointEstimate(),
			    		                                       cfIntCase7.getZeta()/cfIntCase7.getPointEstimate(),
			    		                                       cfIntCase8.getZeta()/cfIntCase8.getPointEstimate(),
			    		                                       cfIntCase9.getZeta()/cfIntCase9.getPointEstimate(),
			    		                                       cfIntCase10.getZeta()/cfIntCase10.getPointEstimate(),
			    		                                       cfIntCase11.getZeta()/cfIntCase11.getPointEstimate(),
			    		                                       cfIntCase12.getZeta()/cfIntCase12.getPointEstimate(),
			    		                                       cfIntCase13.getZeta()/cfIntCase13.getPointEstimate(),
			    		                                       cfIntCase14.getZeta()/cfIntCase14.getPointEstimate(),
			    		                                       cfIntCase15.getZeta()/cfIntCase15.getPointEstimate()); 
			       System.out.printf("-----------------------------------|----------------------------|----------------------------|"
			 				+"----------------------------|----------------------------\n");
			       System.out.println(" ");
			       System.out.println(" ");
			       System.out.println(" ");
		    	 
		     	}
		     
		     }
	}



}
