package com.parkinglot;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class ParkingLot {

	private final int capacity;
	
	private int numberOfCarsParked;
		
	private Map<Ticket,Car> parkedCarMap = new HashMap<Ticket,Car>();	
	
	private Map<Car,Ticket> ticketMap = new HashMap<Car,Ticket>();	

	
	private ParkingLotOwner owner;
	
	public ParkingLot(int capacity) {
		
		this.capacity = capacity;
		
		
	}
	
	public ParkingLot(int capacity,ParkingLotOwner owner) {
		
		this.capacity = capacity;
		this.owner=owner;
		
	}

	public boolean hasParkingSpace(){
		
		return numberOfCarsParked!=this.capacity;
		
	}	

	public boolean parkCar(Car car){
		
		if(hasParkingSpace() && !parkedCarMap.containsValue(car) ){
			
			Ticket newTicket = new Ticket(car.getCarNumber());
			this.parkedCarMap.put(newTicket,car);
			this.ticketMap.put(car,newTicket);
			
			numberOfCarsParked++;
			if(!hasParkingSpace()){				
				owner.isNotifiedFull();
			}
			return true;
			
		}
		
			
			
		return false;
	}
	
	public Ticket getTicket(Car car){
		
		
		return ticketMap.get(car);
	}
	
	
	
	public Car unParkCar(Ticket ticket) throws Exception{
								
		if(this.parkedCarMap.containsKey(ticket)){
							
			Car unparkedCar = parkedCarMap.get(ticket);
			this.parkedCarMap.remove(ticket);
			this.ticketMap.remove(unparkedCar);
			if(!hasParkingSpace()){
				owner.isNotifiedFreeAgain();
			}
			numberOfCarsParked--;			
			return unparkedCar;
		}
		else
			throw new Exception();
		
		
		
	}
	
}
