package com.example.androidgui;


public class Lab1 {

	public static double PMT(double years, double amount, double interest){ 

		double base = 1 + (interest/12);
		double exp = Math.pow(base, 12*years);
		return amount*exp;
	}


}