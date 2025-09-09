package com.bank;

public class LoanBean {
	
	private String customerName;
	private double loanAmount;
	private int tenure;
	private double emi;
	

	
	//values are injected through getter and setter

	
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	public double getLoanAmount() {
		return loanAmount;
	}
	
	
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	
	
	public int getTenure() {
		return tenure;
	}
	
	
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	
	
	public double getEmi() {
		return emi;
	}
	
	
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	
	

}
