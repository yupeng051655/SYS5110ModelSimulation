package MiCazuelaSimModel;

import simulationModelling.*;

public class PartyArrival extends ScheduledAction {

	
	static MiCazuela model;  // reference to model object
	
	@Override
	protected double timeSequence() {
		
		return model.rvp.DuPartyArr();
	}

	@Override
	protected void actionEvent() {
		
		
		Party icParty = new Party();
		icParty.uNum = model.rvp.uPartyNum();
		if(icParty.uNum <= 2) {
			if(model.qPartyLines[Constants.FOR2].size() < Constants.MAXLINE) {
				
				AbsSP.insertQue(model.qPartyLines[Constants.FOR2], icParty);
			}
			else {
				model.output.ssovNumBalk++;
			}
		}
		else {
			if(model.qPartyLines[Constants.FOR4].size() < Constants.MAXLINE) {
				
				AbsSP.insertQue(model.qPartyLines[Constants.FOR4], icParty);
			}
			else {
				model.output.ssovNumBalk++;
			}
		}			
	}
	
	

}







