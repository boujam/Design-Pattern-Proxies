package com.test.pattern.proxies;

import com.test.pattern.interfaces.Operation;
import com.test.pattern.models.Calculator;

public class CalculatorProxyInterfaceStyle implements Operation {

	private Calculator target;
	private boolean loading;
	
	/**
	 * 
	 * @param target the target
	 * @param loading TRUE = public method in Proxy can contact public method in the target
	 * 				  FALSE = the Proxy block the Message
	 */
	public CalculatorProxyInterfaceStyle(Calculator target, boolean loading){
		System.out.println("[CalculatorProxies]" + this.toString());
		this.loading = loading;
		this.target = target;
	}
	
	public boolean isLoading() {
		return loading;
	}

	public void setLoading(boolean loading) {
		this.loading = loading;
	}
	
	/**
	 *  wrapper method who intercept the displayResponse() Message
	 */
	public Integer displayResponse() {
		if (this.loading) { 
			target.displayResponse();
			return 1;
		}
		else{
			System.out.println("affichage de la réponse différée");
			return 0;
		}
	}
	
	/**
	 *  wrapper method who intercept the fullMemory() Message
	 */
	
	public void fullMemory() {
		if (this.loading) { 
			target.fullMemory();
		}
		else{
			System.out.println("mémoire préservée");
		}
	}

}
