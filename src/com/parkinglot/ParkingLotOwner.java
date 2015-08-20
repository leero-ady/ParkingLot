package com.parkinglot;

public class ParkingLotOwner {

	private  String ownerName;	
	
	public ParkingLotOwner(String ownerName){
		this.ownerName = ownerName;
	}
	
	private  boolean isParkingLotFull = false;
	
	public  boolean isNotifiedFull() {
		
		isParkingLotFull=true;
		
		return isParkingLotFull;
	}
	
	public void isNotifiedFreeAgain(){
		
	}

}
