package com.test.pattern.models;

import java.util.ArrayList;
import java.util.List;

import com.test.pattern.interfaces.Operation;


public class Calculator implements Operation {

	private int number1;
	private int number2;
	private int response;
		
	
	public Calculator(){
		System.out.println("[Calculator]" + this.toString());
	}

	public int getNumber1() {
		return number1;
	}

	public void setNumber1(int number1) {
		this.number1 = number1;
//		System.out.println("setting properties using : [setNumber1(int number1)]");
	}

	public int getNumber2() {
		return number2;
	}

	public void setNumber2(int number2) {
		this.number2 = number2;
//		System.out.println("setting properties using : [setNumber2(int number2)]");
	}
	
	public Integer displayResponse() {
		this.calculateResponse();
		System.out.println("réponse = " + response);
		return response;
	}

	/**
	 * Used to calculate the sum
	 * @return
	 */
	private Integer calculateResponse() {
		response = number1 + number2;
		return response;
	}

	/**
	 *  Used to create a lot of objects in the HEAP
	 */
	public void fullMemory() {
		List<String> l = new ArrayList<String>();
		for (long i=0;i<100;i++){
			l.add(new String("Il faut remplir la mémoire au maximum avec i="+i));
			System.out.println(l.get((int) i));
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number1;
		result = prime * result + number2;
		result = prime * result + response;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Calculator other = (Calculator) obj;
		if (number1 != other.number1)
			return false;
		if (number2 != other.number2)
			return false;
		if (response != other.response)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Calculator [number1=" + number1 + ", number2=" + number2
				+ ", response=" + response + "]";
	}
	

	
}
