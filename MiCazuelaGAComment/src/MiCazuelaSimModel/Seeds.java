package MiCazuelaSimModel;

import cern.jet.random.engine.RandomEngine;
import cern.jet.random.engine.RandomSeedGenerator;

public class Seeds {
	
	int partyTotal; // total party arriving per day
	int arr;   // customer arrivals
	int uSize;  // customer size (For2, For4)
	int seatTm;  //seating customers time
	int writeOrderTm; //writing down order time
	int deliverOrderTm; //delivering order time
	int writeOrderUsingDeviceTm; //writing down order using device time
	int deliverOrderUsingDeviceTm; //delivering order using device time
	int prepareFoodTm; // cook prepare the food
	int bringOutFoodTm; //cook bring out the food
	int deliverTime; // waiter deliver the food to customer
	int partyEatTime; // customer enjoy the food
	int collectAndCleanTime; // customers pay the bill and leave the restaurant && waiter collect the payments and tips
	int uBill; // the bill each customer pay
	int uNum;
	
	
	public Seeds(RandomSeedGenerator rsg) {
		
		partyTotal = rsg.nextSeed();
		arr=rsg.nextSeed();
		uSize=rsg.nextSeed();
		writeOrderTm = rsg.nextSeed();
		deliverOrderTm = rsg.nextSeed();
		writeOrderUsingDeviceTm = rsg.nextSeed();
		deliverOrderUsingDeviceTm = rsg.nextSeed();
		prepareFoodTm = rsg.nextSeed();
		bringOutFoodTm = rsg.nextSeed();	
		deliverTime = rsg.nextSeed();
		partyEatTime = rsg.nextSeed();
		collectAndCleanTime = rsg.nextSeed();
		uBill = rsg.nextSeed();
		uNum = rsg.nextSeed();
		
	}
	

}
