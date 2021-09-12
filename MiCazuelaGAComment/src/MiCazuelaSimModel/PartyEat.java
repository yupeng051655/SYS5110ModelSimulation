package MiCazuelaSimModel;

import simulationModelling.*;

public class PartyEat extends SequelActivity {
	
	private Party icParty;
	static MiCazuela model;
	
	//instructor
	public PartyEat(Party party) {
		icParty = party;
	}

	@Override
	protected double duration() {
		return model.rvp.uPartyEatTm();
	}

	@Override
	public void startingEvent() {
		/* Empty event */
		
	}

	@Override
	protected void terminatingEvent() {
		AbsSP.insertQue(model.qPartyLines[Constants.PAY], icParty);
		
	}

}
