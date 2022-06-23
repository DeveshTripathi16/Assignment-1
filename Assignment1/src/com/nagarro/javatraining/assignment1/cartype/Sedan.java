package com.nagarro.javatraining.assignment1.cartype;

import com.nagarro.javatraining.assignment1.constants.Constants;
import com.nagarro.javatraining.assignment1.entities.*;

public class Sedan implements InsuranceCalculator {
	@Override
	public double calculateInsurance(CarDetails carDetail) {
		double cost = Double.parseDouble(carDetail.getCarCost());
		double insurance = 0.0d;
		String insuranceType = carDetail.getInsuranceType();
		double updatedCost = 0.0d;
		try {
			insurance = (cost * Constants.SEDAN_RATE) / 100;
			if (insuranceType.equalsIgnoreCase(Constants.PREMIUM)) {
				updatedCost = insurance + (insurance * Constants.PREMIUM_RATE) / 100;
				return updatedCost;
			}
		} catch (ArithmeticException e) {
			System.err.print("\n Cannot Be Divided By Zero " + e);
		}
		return insurance;
	}

}
