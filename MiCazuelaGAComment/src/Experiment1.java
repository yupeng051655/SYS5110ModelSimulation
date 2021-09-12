
import MiCazuelaSimModel.MiCazuela;
import MiCazuelaSimModel.Seeds;
import cern.jet.random.engine.*;
import outputAnalysis.ConfidenceInterval;

public class Experiment1 {

	public static void main(String[] args) {
		
		int i, NUMRUNS = 1; 
		
		Seeds[] sds = new Seeds[NUMRUNS];
		MiCazuela micazuela; 
		
		RandomSeedGenerator rsg = new RandomSeedGenerator();
		for (i = 0; i < NUMRUNS; i++) sds[i] = new Seeds(rsg);
		
		
		int numWaiter = 2;
		int numCook = 2;
		int numTablesFour = 4;
		boolean handHeldDevices = false;
		
		for(int k=0 ; k < NUMRUNS ; k++) {
			
			System.out.println("Base case:");
			System.out.println("numWaiter: "+numWaiter+" numCook: "+numCook+" umTablesFour: "+
				numTablesFour+" handHeldDevices: "+handHeldDevices);
			micazuela = new MiCazuela(sds[k], numWaiter, numCook, numTablesFour, handHeldDevices, true);
			micazuela.runSimulation();
			System.out.println("nubmer of customer balk: " + micazuela.getNumBalk());
			System.out.println("nubmer of customer served: " + micazuela.getNumServed());
			System.out.println("profit per day: " + micazuela.getPorfitPerDay());
			System.out.println("");

			
		}
		 
		
	}

}






