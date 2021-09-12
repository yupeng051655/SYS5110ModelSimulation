package MiCazuelaSimModel;

import simulationModelling.ScheduledAction;

class Initialise extends ScheduledAction {
	
	static MiCazuela model;
	
	double [] ts = { 0.0, -1.0 }; // -1.0 ends scheduling
	int tsix = 0;  // set index to first entry.
	int numCook;
	int numWaiter;
	int numTableFour;
	boolean handHeldDevices;
	
	public Initialise(int numWaiter, int numCook, int numTableFour, boolean handheldDevices) {
		this.numWaiter = numWaiter;
		this.numCook = numCook;
		this.numTableFour = numTableFour;
		this.handHeldDevices = handheldDevices;
	}
	
	protected double timeSequence() {
		
		return ts[tsix++]; 
	}

	
	protected void actionEvent() {
		
		// Initialize the output variables
		model.output.ssovProfitPerDay = 0;
		model.output.ssovNumBalk = 0;
		model.output.ssovNumServed = 0;
		
		//initialize the parameters
		int numTableTwo = 1 + 2 * (5 - numTableFour);
		model.rgTables[Constants.FOR2].numTables = numTableTwo;
		model.rgTables[Constants.FOR4].numTables = numTableFour;
		
		model.rWaiter.numWaiter = numWaiter;
		model.rWaiter.handHeldDevices = handHeldDevices;
		model.rCook.numCook = numCook;
		
		
		
	}

}
