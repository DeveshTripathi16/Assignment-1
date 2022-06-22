package com.nagarro.javatraining.assignment1.main;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import com.nagarro.javatraining.assignment1.entities.*;
import com.nagarro.javatraining.assignment1.validation.*;

public class MainInput
{
	static String carModel;
	static String carType;
	static String carCost;
	static String insuranceType;
	static double total=0.0;
	static LinkedList<CarDetails> allCars=new LinkedList<>();

	public static void main(String args[]) throws IOException
	{
		int counter =1;
		Scanner sc = new Scanner(System.in);
		String Cars[]= {"","Sedan","Suv","Hatchback"};
		boolean valid;
		char choice;
		do 
		{

			System.out.println("Enter the Car Details ");

			System.out.print("(a) Car Model\n");
			carModel=sc.nextLine();
			System.out.print("(b) Car Type\n "
					+ "     Please Enter Your Car Choice from below available Car Type :\n"
					+ "        1.Sedan\n"
					+ "        2.Suv\n"
					+ "        3.Hatchback\n");
			do {
				carType=sc.nextLine();
				valid=InputValidator.checkCarType(carType);
			}while(!valid);

			System.out.print("(c) Car Cost\n");
			do {
				carCost=sc.nextLine();
				valid =InputValidator.checkDouble(carCost);
			}while(!valid);
			System.out.print("(d) Insurance Type\n");
			do {

				insuranceType=sc.nextLine();
				valid=InputValidator.checkInsuranceType(insuranceType);
			}while(!valid);



			VehicleType object=new VehicleType();
			CarDetails carObject=object.createVehicleType(carModel, carType, carCost, insuranceType);
			double insuranceBasicCost=carObject.calculateInsurance();
			total=total+insuranceBasicCost;
			carObject.setTotalCost(insuranceBasicCost);

			allCars.add(carObject);


			System.out.print("\nCar Model is "+ carObject.getCarModel()+"_"+counter++);
			System.out.print("\nCar Price is Rs."+ carCost);
			System.out.println("\nTotal Insurance is Rs."+ insuranceBasicCost);
			System.out.print("\nDo you want to enter new Car details (y/n)\n");
			do {
				choice =sc.nextLine().toLowerCase().charAt(0);
				valid=InputValidator.checkChoice(choice);
			}while(!valid);
			if(choice=='n')
			{
				counter=1;
				for(CarDetails cars :allCars)
				{

					System.out.println("\n\nCar Model is " +cars.getCarModel()+"_"+counter++);
					System.out.println("Type of the Car is " +Cars[Integer.parseInt(cars.getCarType())]);
					System.out.println("Price of the Car is Rs." +cars.getCarCost());
					System.out.println("Type of insurance chosen of the Car is " +cars.getInsuranceType());
					System.out.println("Insurance cost of the Car is Rs." +cars.getTotalCost());

				}
				System.out.println("\n\nTotal insurance cost of all the Cars is Rs." +total);

				System.exit(0);
			}

		}
		while(choice=='y');
		sc.close();

	}
}
