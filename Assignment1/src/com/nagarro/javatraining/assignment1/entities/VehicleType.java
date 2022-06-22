package com.nagarro.javatraining.assignment1.entities;

public class VehicleType
{
	public CarDetails createVehicleType(String carModel,String carType,String carCost,String insuranceType)
	{
		switch(Integer.parseInt(carType))
		{
		case 1:
			return new Sedan(carModel,carType,carCost,insuranceType);

		case 2:
			return new Suv(carModel,carType,carCost,insuranceType);

		case 3:
			return new Hatchback(carModel,carType,carCost,insuranceType);

		default:
			throw new IllegalArgumentException("Invalid Car Type "+carType);
		}
	}
}
