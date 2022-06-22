package com.nagarro.javatraining.assignment1.entities;
import com.nagarro.javatraining.assignment1.constants.Constants;

public class Sedan extends CarDetails implements CarAndInsuranceType {

	public Sedan(String carModel, String carType, String carCost, String insuranceType) 
	{
		super(carModel, carType, carCost, insuranceType);
	}

	double cost=Double.parseDouble(getCarCost());
	double insurance=0.0d;

	@Override
	public double calculateInsurance()
	{
		String insuranceType=getInsuranceType().toLowerCase();
		double updatedCost=0.0d;
		try {
			if(insuranceType.equals("basic") || insuranceType.equals("premium")) 
			{
				insurance=(cost*Constants.SEDAN_RATE)/100;
			}
			if(insuranceType.equals("premium"))
			{
				updatedCost=insurance+(insurance*Constants.PREMIUM_RATE)/100;
				return updatedCost;
			}
		}catch(ArithmeticException e){
			System.err.print("\n Cannot Be Divided By Zero "+e);
		}
		return insurance;
	}

}
