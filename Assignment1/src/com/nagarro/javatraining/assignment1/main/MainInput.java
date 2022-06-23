package com.nagarro.javatraining.assignment1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.nagarro.javatraining.assignment1.cartype.Sedan;
import com.nagarro.javatraining.assignment1.entities.*;
import com.nagarro.javatraining.assignment1.cartype.*;
import com.nagarro.javatraining.assignment1.validation.*;

public class MainInput {

	public static void main(String args[]) {
		String carModel;
		String carType;
		String carCost;
		String insuranceType;
		Double total = 0.0;
		List<CarDetails> allCars = new ArrayList<>();
		int counter = 1;
		Scanner sc = new Scanner(System.in);
		String Cars[] = { "", "Sedan", "Suv", "Hatchback" };
		boolean valid;
		char choice;
		do {

			System.out.println("Enter the Car Details ");

			System.out.print("(a) Car Model\n");
			do {
				carModel = sc.nextLine();
				valid = InputValidator.checkCarModel(carModel);
			} while (!valid);

			System.out.print("(b) Car Type\n " + "     Please Enter Your Car Choice from below available Car Type :\n"
					+ "        1.Sedan\n" + "        2.Suv\n" + "        3.Hatchback\n");

			do {
				carType = sc.nextLine();
				valid = InputValidator.checkCarType(carType);
			} while (!valid);

			System.out.print("(c) Car Cost\n");
			do {
				carCost = sc.nextLine();
				valid = InputValidator.checkDouble(carCost);
			} while (!valid);
			System.out.print("(d) Insurance Type\n");
			do {
				insuranceType = sc.nextLine();
				valid = InputValidator.checkInsuranceType(insuranceType);
			} while (!valid);

			CarDetails car = new CarDetails();
			car.setCarModel(carModel);
			car.setCarType(carType);
			car.setCarCost(carCost);
			car.setInsuranceType(insuranceType);
			int carTypeCheck = Integer.parseInt(carType);

			InsuranceCalculator calculation;

			if (carTypeCheck == 1)
				calculation = new Sedan();
			else if (carTypeCheck == 2)
				calculation = new Suv();
			else
				calculation = new Hatchback();

			double insuranceBasicCost = calculation.calculateInsurance(car);
			total = total + insuranceBasicCost;
			car.setTotalCost(insuranceBasicCost);

			allCars.add(car);

			System.out.print("\nCar Model is " + car.getCarModel() + "_" + counter++);
			System.out.print("\nCar Price is Rs." + carCost);
			System.out.println("\nTotal Insurance is Rs." + insuranceBasicCost);
			System.out.print("\nDo you want to enter new Car details (y/n)\n");
			do {
				choice = sc.nextLine().toLowerCase().charAt(0);
				valid = InputValidator.checkChoice(choice);
			} while (!valid);
			if (choice == 'n') {
				counter = 1;
				for (CarDetails cars : allCars) {

					System.out.println("\nDetails Of All Cars.. ");
					System.out.println("\n\nCar Model is " + cars.getCarModel() + "_" + counter++);
					System.out.println("Type of the Car is " + Cars[Integer.parseInt(cars.getCarType())]);
					System.out.println("Price of the Car is Rs." + cars.getCarCost());
					System.out.println("Type of insurance chosen of the Car is " + cars.getInsuranceType());
					System.out.println("Insurance cost of the Car is Rs." + cars.getTotalCost());

				}
				System.out.println("\n\nTotal insurance cost of all the Cars is Rs" + total);
			}
		} while (choice == 'y');
		sc.close();
	}
}
