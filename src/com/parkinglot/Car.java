package com.parkinglot;

public class Car {

	private int carNumber;

	public int getCarNumber() {
		return carNumber;
	}

	public Car(int carNumber) {
		super();
		this.carNumber = carNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (carNumber != other.carNumber)
			return false;
		return true;
	}
	
	
	
}
