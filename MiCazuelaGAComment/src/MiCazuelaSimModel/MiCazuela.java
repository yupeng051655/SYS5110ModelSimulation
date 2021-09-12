
package MiCazuelaSimModel;

import simulationModelling.*;

public class MiCazuela extends AOSimulationModel {
	
	
	//Entities
	Tables [] rgTables = new Tables[2];
	
	public AbsQueue<Party>[] qPartyLines = new AbsQueue[5];
	
	Waiters rWaiter = new Waiters();
	Cooks rCook = new Cooks();
	
	// Output object
	Output output = new Output();
	

	// References to RVP and DVP objects
	protected RVPs rvp; // Reference to rvp object
	
	
	boolean traceFlag = false;
	
	protected double closingTime;
	
	// Constructor
	public MiCazuela(Seeds sd, int numWaiter, int numCook, int numTableFour, boolean handHeldDevices, boolean traceFlag) {
		
		this.traceFlag = traceFlag;
		
		// Create RVP object with given seed
		rvp = new RVPs(sd);
		
		// Initialize classes
		initialiseClasses(sd);
		
		//initialize all partyLines
		for(int i = 0; i < 5; i++) {
			qPartyLines[i] = new AbsQueue<Party>();
		}
		
		//initialize Tables
		rgTables[Constants.FOR2] = new Tables();
		rgTables[Constants.FOR4] = new Tables();
				
		
		// Initialize the simulation model
		initAOSimulModel(0, Constants.CLOSING_TIME);
		closingTime = Constants.CLOSING_TIME;
		
		// Schedule the first arrivals and number of waiters and cooks
		Initialise init = new Initialise(numWaiter, numCook, numTableFour, handHeldDevices);
		scheduleAction(init);
		
		PartyArrival arrival = new PartyArrival();
		scheduleAction(arrival);
		
		
	}
	
	public int getNumBalk() {
		return output.ssovNumBalk;
	}
	
	public int getNumServed() {
		return output.ssovNumServed;
	}
	
	public double getPorfitPerDay() {
		
		double rentDevice = 0;
		if(rWaiter.handHeldDevices == true) {
			rentDevice = 12 * rWaiter.numWaiter; // if handheld devices are used, the rent for each device is $2 each hours.               
		}
		
		int rentWaiter = rWaiter.numWaiter * 60;
		int rentCook = rCook.numCook * 100;
		int overhead = 300;
		
		// subtract the overhead cost
		output.ssovProfitPerDay = output.ssovProfitPerDay - rentDevice - rentWaiter - rentCook - overhead;
		return output.ssovProfitPerDay;
		
	}

	//@Override
	/************ Implementation of Data Modules ***********/
	/*
	 * Testing preconditions
	 */
	protected void testPreconditions(Behaviour behObj) {
		
		reschedule(behObj);
		while (scanPreconditions() == true) /* repeat */;
		
	}
	
	public void eventOccured() {
		
		if(traceFlag) {
			
			System.out.println("Clock: "+getClock()+
                    ", Q.PartyLines[FOR2].n: "+qPartyLines[Constants.FOR2].getN()+
                    ", Q.PartyLines[FOR4].n: "+qPartyLines[Constants.FOR4].getN()+
                    ", RG.Tables[FOR2].n: "+rgTables[Constants.FOR2].getN()+
                    ", RG.Tables[FOR4].n: "+rgTables[Constants.FOR4].getN()+
                    ", R.Waiters.numBusy: "+rWaiter.numBusy+
                    ", R.Cooks.numBusy: "+rCook.numBusy);
			showSBL();
		}
		
	}
	
	protected void printDebug() {
		
	}

	
	// Initialize static components of model classes
	void initialiseClasses(Seeds sd) {
		
		Initialise.model = this;
		Output.model = this;
		RVPs.model = this;
		
		// Add reference to activity/action classes
		PartyArrival.model = this;
		SeatAndOrder.model = this;
		CookPrepareAndBringOutFood.model = this;
		WaiterDeliverFood.model = this;
		PartyEat.model = this;
		CollectPaymentAndTip.model = this;
		
	}
	
	public boolean implicitStopCondition() {
		boolean retVal = false;
		
		if (getClock() >= closingTime) {
			retVal = true;
		}

		return retVal;
	}
	
	private boolean scanPreconditions() {
		boolean statusChanged = false;
		
		if(SeatAndOrder.precondition() == true) {
			SeatAndOrder act = new SeatAndOrder();
			act.startingEvent();
			scheduleActivity(act);
			statusChanged = true;
		}
		
		if(CookPrepareAndBringOutFood.precondition() == true) {
			CookPrepareAndBringOutFood act = new CookPrepareAndBringOutFood();
			act.startingEvent();
			scheduleActivity(act);
			statusChanged = true;	
		}
		
		if(WaiterDeliverFood.precondition() == true) {
			WaiterDeliverFood act = new WaiterDeliverFood();
			act.startingEvent();
			scheduleActivity(act);
			statusChanged = true;
		}
		
		if(CollectPaymentAndTip.precondition() == true) {
			CollectPaymentAndTip act = new CollectPaymentAndTip();
			act.startingEvent();
			scheduleActivity(act);
			statusChanged = true;
		}
		 
		return statusChanged;
	}
	
	protected void spStart(SequelActivity seqAct) {
		seqAct.startingEvent();
		scheduleActivity(seqAct); 
		
	}


}













