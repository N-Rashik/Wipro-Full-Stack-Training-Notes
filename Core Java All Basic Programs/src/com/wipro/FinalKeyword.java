package com.wipro;

final class ConstantVariables {
    public static final double gst = 0.18;
    public static final double pi = 3.14;
    public static final double bonus = 1000;
}

class Salary {
    public final double salary(double basicPay) {
        return basicPay * ConstantVariables.gst;
    }
}

public class FinalKeyword {

    public static void main(String[] args) {
        Salary s = new Salary();
        double result = s.salary(40000); 
        System.out.println("GST amount on salary: " + result);
    }
}
