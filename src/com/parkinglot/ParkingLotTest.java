package com.parkinglot;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import junit.framework.TestCase;

@RunWith(MockitoJUnitRunner.class)
public class ParkingLotTest extends TestCase {

	ParkingLot parkingLot = new ParkingLot(5);
	
	@Mock
	ParkingLotOwner ownerAditya;		
	
	ParkingLot parkingLotWithZeroCapacity = new ParkingLot(0);
	
	Car carOne = new Car(1);		
	
	Car carTwo = new Car(2);
		
	@Test
	public void testIfParkingIsSuccessfulIfParkingLotIsNotFullandCarAlreadyDoesNotExist(){
		
		assertEquals(true, parkingLot.parkCar(carOne));			
		assertEquals(false, parkingLot.parkCar(carOne));
		
	}
	
	
	
	@Test
	public void testIfParkingIsUnSuccessfulandOwnerIsNotifiedIfParkingLotIsFull(){
		
		
		ParkingLot parkingLot = new ParkingLot(1,ownerAditya);
		parkingLot.parkCar(carOne);
		
		Mockito.verify(ownerAditya).isNotifiedFull();
		
		assertEquals(false, parkingLotWithZeroCapacity.parkCar(carTwo));			
		
		
	}
	
	
	@Test
	public void ownerIsNotifiedWheneverTheParkingLotIsFreeAgain() throws Exception{
		
		ParkingLot parkingLot = new ParkingLot(1,ownerAditya);
		parkingLot.parkCar(carOne);
		parkingLot.unParkCar(parkingLot.getTicket(carOne));				
		Mockito.verify(ownerAditya).isNotifiedFreeAgain();
		

		
	}
	
	@Test
	public void testUnparking() throws Exception{
		
		parkingLot.parkCar(carOne);
		Ticket carTicket = parkingLot.getTicket(carOne);
		assertEquals(true,carOne.equals(parkingLot.unParkCar(carTicket)));
	}
	
	
	
	
}
