package com.nagarro.javatraining.assignment1.entities;

public class CarDetails {
	private String carModel;
	private String carType;
	private String carCost;
	private String insuranceType;
	private double totalCost;

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
