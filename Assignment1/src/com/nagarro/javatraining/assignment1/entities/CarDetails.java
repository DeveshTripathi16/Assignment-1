package com.nagarro.javatraining.assignment1.entities;

public abstract class CarDetails implements CarAndInsuranceType
{
	public String carModel;
	public String carType;
	public String carCost;
	public String insuranceType;
	public double totalCost;

	public CarDetails(String carModel,String carType, String carCost, String insuranceType)
	{
		super();
		this.carModel = carModel;
		this.carType = carType;
		this.carCost = carCost;
		this.insuranceType = insuranceType;
	}
	public double getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {

		this.carModel = carModel;

	}
	public String getCarType() {
		return carType;
	}
	public void setCarType(String carType) {
		this.carType = carType;
	}
	public String getCarCost() {
		return carCost;
	}
	public void setCarCost(String carCost) {
		this.carCost = carCost;
	}
	public String getInsuranceType() {
		return insuranceType;
	}
	public void setInsuranceType(String insuranceType) {
		this.insuranceType = insuranceType;
	}

}
