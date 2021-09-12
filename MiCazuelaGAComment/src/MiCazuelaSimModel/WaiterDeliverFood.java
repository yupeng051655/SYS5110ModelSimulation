package MiCazuelaSimModel;

import simulationModelling.*;

public class WaiterDeliverFood extends ConditionalActivity {
	
	private Party icParty;
	static MiCazuela model;
	
	public static boolean precondition() {
		
		boolean retVal = false;
		
		if(model.qPartyLines[Constants.FOOD].getN() > 0 && model.rWaiter.numWaiter > model.rWaiter.numBusy) {
			retVal = true;	
		}
		return retVal;
		
	}

	@Override
	protected double duration() {
		
		return model.rvp.uWaitDeliverTm();
	}

	@Override
	public void startingEvent() {
		
		model.rWaiter.numBusy++;
		icParty = AbsSP.removeQue(model.qPartyLines[Constants.FOOD]); // remove one party from food line
		
	}

	@Override
	protected void terminatingEvent() {
		
		model.rWaiter.numBusy--;
		PartyEat partyEating = new PartyEat(icParty);
		model.spStart(partyEating);
		
	}

}
