package MiCazuelaSimModel;

import simulationModelling.*;

public class CookPrepareAndBringOutFood extends ConditionalActivity{
	
	private Party icParty;
	static MiCazuela model;
	
	public static boolean precondition() {
		
		boolean retVal = false;
		
		if(model.qPartyLines[Constants.ORDER].getN() > 0 && model.rCook.numCook > model.rCook.numBusy) {
			retVal = true;	
		}
		return retVal;
	}

	@Override
	protected double duration() {
		return model.rvp.uCookAndBringOutFoodTm();
	}

	@Override
	public void startingEvent() {
		
		model.rCook.numBusy++; // one cook become busy
		icParty = AbsSP.removeQue(model.qPartyLines[Constants.ORDER]); // remove one party from order line
		
	}

	@Override
	protected void terminatingEvent() {

		model.rCook.numBusy--; // one cook become idle;
		AbsSP.insertQue(model.qPartyLines[Constants.FOOD], icParty); // insert one party to food line 
		
		
	}

}





