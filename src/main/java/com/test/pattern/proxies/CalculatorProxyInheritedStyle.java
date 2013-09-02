package com.test.pattern.proxies;


import com.test.pattern.models.Calculator;

public class CalculatorProxyInheritedStyle extends Calculator {

	private boolean loading;
	private Calculator target;
	
	/**
	 * 
	 * @param loading TRUE = public method in Proxy can contact public method in the target
	 * 				  FALSE = the Proxy block the Message 
	 */
	public CalculatorProxyInheritedStyle(Calculator calculator, boolean loading){
		System.out.println("[CalculatorProxies]" + this.toString());
		if (this.loading = loading) { 
			this.target = calculator;
		}
	}

	public boolean isLoading() {
		return loading;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
	}
	
	@Override
	public int getNumber1() {
		return this.target.getNumber1();
	}

	@Override
	public void setNumber1(int number1) {
		this.target.setNumber1(number1);
	}

	@Override
	public int getNumber2() {
		return this.target.getNumber1();
	}

	@Override
	public void setNumber2(int number2) {
		this.target.setNumber2(number2);
	}
	
	@Override
	public Integer displayResponse() {
		if (this.loading) { 
			return this.target.displayResponse();
			
		}
		else{
			System.out.println("affichage de la réponse différée");
			return 0;
		}
	}

	@Override
	public void fullMemory() {
		if (this.loading) { 
			this.target.fullMemory();
		}
		else{
			System.out.println("remplissage de la mémoire différé");
		}
	}

	@Override
	public int hashCode() {
		if (this.target != null ) return this.target.hashCode();
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this.target != null) return this.target.equals(obj);
		return false;
	}

	@Override
	public String toString() {
		if (this.target != null) return this.target.toString();
		return super.toString();
	}
	
	
	
	
}
