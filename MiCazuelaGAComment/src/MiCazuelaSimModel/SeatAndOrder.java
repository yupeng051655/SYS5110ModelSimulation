package MiCazuelaSimModel;

import simulationModelling.*;

import java.util.Random;
import cern.jet.random.Exponential;
import cern.jet.random.Normal;
import cern.jet.random.Uniform;
import cern.jet.random.engine.MersenneTwister;

public class SeatAndOrder extends ConditionalActivity {
	
	private Party icParty;
	static MiCazuela model;
	int id;
	
	public static boolean precondition() {
		
		boolean retVal = false;
		if(PartyReadyForServing() != Constants.NONE) {
			retVal = true;
		}
		return retVal;
	}

	@Override
	protected double duration() {
		
		if(model.rWaiter.handHeldDevices == true) {
			return model.rvp.uSeatCusAndWriteOrderUsingDeviceTm();
		}
		else {
			return model.rvp.uSeatCusAndWriteOrderTm();
		}
		
	}

	@Override
	public void startingEvent() {
		
		id = PartyReadyForServing(); //identify the table with right size
		
		model.rWaiter.numBusy++; //one waiter become busy
		icParty = AbsSP.removeQue(model.qPartyLines[id]); //remove party from waitLines
		AbsSP.insertGrp(model.rgTables[id], icParty); //insert party into table with right size
		
		
	}

	@Override
	protected void terminatingEvent() {

		model.rWaiter.numBusy--; //one waiter become idle
		AbsSP.insertQue(model.qPartyLines[Constants.ORDER], icParty); //insert party into orderLine
		
	}
	
	
	// UDP
	
	private static int PartyReadyForServing() {
		
		int tableId = Constants.NONE;
		
		//check all wait line:	
		for(int id = Constants.FOR2; id <= Constants.FOR4 && tableId == Constants.NONE; id++) {
			
			if(model.rgTables[id].getN() < model.rgTables[id].numTables && model.qPartyLines[id].getN() != 0 &&
					model.rWaiter.numWaiter > model.rWaiter.numBusy) {
				tableId = id;
			}
		
		}
		
		return tableId;
		
		
	}
	

}

















