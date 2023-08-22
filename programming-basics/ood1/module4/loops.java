package com.fdmgroup.loop_module;

import java.util.ArrayList;
import java.util.Arrays;

public class Module_4 {
    public static void main(String[] args) {
        String[] strings = { "string1", "string2", "string3" };
        
        for (String string : strings) {
            System.out.println(string);
        }
        
        String[] courses = { "UNIX", "SQL", "java", "Python", "Web Apps" };

        for (String course : courses) {
            System.out.println("I love learning " + course);
        }

        ArrayList<String> courseList = new ArrayList<String>();

        for (String course : courses) {
            courseList.add(course);
        }
    
        for (String course : courseList){
	            System.out.println(course);
        }
        
        ArrayList<Double> prices = new ArrayList<Double>();
		
        prices.add(4.50);
        prices.add(1.99);
        prices.add(9.75);
        prices.add(3.15);
        prices.add(10.25);
				
        double total = 0.0;
				
        for (double price : prices){
	            total += price;
        }
				
        System.out.println(total);
        
        double[] priceArray = new double[5];
		
        int index = 0;
				
        for (double price : prices){
	            priceArray[index] = price;
	            index ++;
        }
        
        String string = "10,7,25,3,8";
		
        String[] numbers = string.split(",");
				
        int total = 0;
				
        for (String number : numbers){
	            total += Integer.parseInt(number);
        }
        System.out.println(total);

        String string = "desrever neeb sah txet siht";
		
        char[] letters = string.toCharArray();
		
        String reversed = "";
		
        for (char letter : letters){
	            reversed = letter + reversed;
        }
        System.out.println(reversed);
      }
}


