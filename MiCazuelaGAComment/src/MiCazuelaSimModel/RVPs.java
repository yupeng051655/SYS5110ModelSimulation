package MiCazuelaSimModel;

import java.util.Random;
import cern.jet.random.Exponential;
import cern.jet.random.Normal;
import cern.jet.random.Uniform;
import cern.jet.random.engine.MersenneTwister;

public class RVPs {
	
	//static MiCazuela model;
	static MiCazuela model;
	
	protected final static int MIN_PARTY = 30;
	protected final static int MAX_PARTY = 50;
	
	private Uniform dmPartyTotal;
		
	protected int uPartyTotal;
	
	// parties arrival times
	protected double mean1;
	protected double mean2;
	protected double mean3;
	protected double mean4;
	protected double mean5;
	
	protected Exponential interArrDist; 
	private Uniform dmNum;
	private Normal dmSeatTime;
	private Normal dmOrderTime;
	private Normal dmDeliverOrderTime;
	private Normal dmOrderUsingDeviceTime;
	private Normal dmDeliverOrderUsingDeviceTime;
	private Normal dmPrepareFoodTime;
	private Normal dmBringOutFoodTime;
	private Normal dmWaitDeliverTime;
	private Normal dmPartyEatTime;
	private Normal dmCollectAndCleanTime;
	
	
	private Uniform dmBillPayment;
		
	public RVPs(Seeds sd) {
				
		dmPartyTotal = new Uniform(30, 50, sd.partyTotal);
		uPartyTotal = uPartyTotal();
		mean1 = 60 / (uPartyTotal * 0.1);  
		mean2 = 60 / (uPartyTotal * 0.2);
		mean3 = 120 / (uPartyTotal * 0.55);
		mean4 = 60 / (uPartyTotal * 0.1);
		mean5 = 60 / (uPartyTotal * 0.05);
		dmNum = new Uniform(1, 4, sd.uNum);
		interArrDist = new Exponential(1.0/mean1, new MersenneTwister(sd.arr));
		dmSeatTime = new Normal(2, 0.5, new MersenneTwister(sd.seatTm));
		dmOrderTime = new Normal(3, 0.7, new MersenneTwister(sd.writeOrderTm));
		dmDeliverOrderTime = new Normal(2, 0.5, new MersenneTwister(sd.deliverOrderTm));
		dmOrderUsingDeviceTime = new Normal(1.5, 0.2, new MersenneTwister(sd.writeOrderUsingDeviceTm));
		dmDeliverOrderUsingDeviceTime = new Normal(1.5, 0.2, new MersenneTwister(sd.deliverOrderUsingDeviceTm));
		dmPrepareFoodTime = new Normal(5, 1, new MersenneTwister(sd.prepareFoodTm));
		dmBringOutFoodTime = new Normal(2, 0.5, new MersenneTwister(sd.bringOutFoodTm));	
		dmWaitDeliverTime = new Normal(2, 0.5, new MersenneTwister(sd.deliverTime));
		dmPartyEatTime = new Normal(10, 2, new MersenneTwister(sd.partyEatTime));
		dmCollectAndCleanTime = new Normal(3, 0.8, new MersenneTwister(sd.collectAndCleanTime));
		dmBillPayment = new Uniform(10, 16, sd.uBill);
			
			
	}
		
	private int uPartyTotal() {
		
		return dmPartyTotal.nextInt();
		
	}
		
	
	protected double DuPartyArr() {
			 
		double nxtArrival;
		double mean;
		if(model.getClock() < 60) mean = mean1;
		else if (model.getClock() < 120) mean = mean2;
		else if (model.getClock() < 240) mean = mean3;
		else if (model.getClock() < 300) mean = mean4;
		else mean = mean5;
			
		nxtArrival = model.getClock()+interArrDist.nextDouble(1.0/mean);
		if(nxtArrival > model.closingTime) {
			nxtArrival = -1.0;  // Ends time sequence
		} 	  
			
		return nxtArrival;
			
	}
	
	public int uPartyNum() {
		
		return dmNum.nextInt();
		
	}
	
	public double uSeatCusAndWriteOrderTm() {
		
		return dmSeatTime.nextDouble() + dmOrderTime.nextDouble() + dmDeliverOrderTime.nextDouble();
	}
	
	public double uSeatCusAndWriteOrderUsingDeviceTm() {
		
		return dmSeatTime.nextDouble() + dmOrderUsingDeviceTime.nextDouble() + dmDeliverOrderUsingDeviceTime.nextDouble();
	}
	
	public double uCookAndBringOutFoodTm() {
		
		return dmPrepareFoodTime.nextDouble() + dmBringOutFoodTime.nextDouble();
	}
	
	public double uWaitDeliverTm() {
		
		return dmWaitDeliverTime.nextDouble();
		
	}
	
	public double uPartyEatTm() {
		
		return dmPartyEatTime.nextDouble();
	}
	
	public double uCollectAndCleanTm() {
		
		return dmCollectAndCleanTime.nextDouble();
	}
	
	public double uBillPayment() { 
		
		return dmBillPayment.nextDouble(); 
	}
	

}

































