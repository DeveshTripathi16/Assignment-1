package com.nagarro.javatraining.assignment1.validation;

import com.nagarro.javatraining.assignment1.constants.Constants;

public class InputValidator {
	public static boolean checkCarModel(String carModel) {
		if (carModel.length() == 0) {
			System.err.println("Car Model Cannot Be Empty.Kindly Enter Again : ");
			return false;
		}
		return true;
	}

	public static boolean checkCarType(String carType) {
		if (!Character.isDigit(carType.charAt(0))) {
			System.err.print("Enter the Car Type choice again in Integer Format : ");
			return false;
		} else if (Integer.parseInt(carType) <= 3 && Integer.parseInt(carType) >= 1 && !carType.isEmpty())
			return true;
		else {
			System.err.print("Enter the Car Type choice again in between 1 to 3 : ");
			return false;
		}
	}

	public static boolean checkDouble(String carCost) {
		try {
			Double.parseDouble(carCost);
		} catch (NumberFormatException e) {
			System.err.print("Enter the Car Cost in Double Format :");
			return false;
		}
		if (Integer.parseInt(carCost) >= 1 && !carCost.isEmpty())
			return true;
		else {
			System.err.print("Car Cost must greater than 1 .Enter Again : ");
			return false;
		}
	}

	public static boolean checkInsuranceType(String insuranceType) {
		if (insuranceType.equalsIgnoreCase(Constants.BASIC) || insuranceType.equalsIgnoreCase(Constants.PREMIUM)) {
			return true;
		}
		System.err.print("You Entered The Wrong Insurance Type format. Kindly enter again : ");
		return false;
	}

	public static boolean checkChoice(char choice) {
		if (choice == 'y' || choice == 'n')
			return true;
		System.err.print("You Entered Wrong Choice. Please Enter Again : ");
		return false;

	}

}
