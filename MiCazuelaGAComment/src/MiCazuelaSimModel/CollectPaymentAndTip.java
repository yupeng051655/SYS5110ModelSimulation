package MiCazuelaSimModel;

import simulationModelling.*;

public class CollectPaymentAndTip extends ConditionalActivity {
	
	private Party icParty;
	static MiCazuela model;
	
	public static boolean precondition() {
		
		boolean retVal = false;
		
		if(model.qPartyLines[Constants.PAY].getN() > 0 && model.rWaiter.numWaiter > model.rWaiter.numBusy) {
			retVal = true;
		}
		return retVal;
		
	}

	@Override
	protected double duration() {
		
		return model.rvp.uCollectAndCleanTm();
	}

	@Override
	public void startingEvent() {
		
		model.rWaiter.numBusy++;
		icParty = AbsSP.removeQue(model.qPartyLines[Constants.PAY]);
		model.output.ssovNumServed += 1;
		
		
		double profit = PartyProfit(icParty.uNum);
		model.output.ssovProfitPerDay += profit;
		
		
	}

	@Override
	protected void terminatingEvent() {
		
		model.rWaiter.numBusy--;
		if(icParty.uNum <= 2) {
			AbsSP.removeGrp(model.rgTables[Constants.FOR2], icParty);
		}
		else {
			AbsSP.removeGrp(model.rgTables[Constants.FOR4], icParty);
		}	
		
	}
	
	// UDP
	
	private double PartyProfit(int num) {
		
		double profit = 0;
		for(int i=0; i<num; i++) {
			profit += model.rvp.uBillPayment();
		}
		
		profit -= icParty.uNum;
	
 
		return profit;
		
	}

}






