package com.test.pattern.proxies;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.test.pattern.models.Calculator;

public class CalculatorInvocationHandler implements InvocationHandler {

	private Calculator target;
	
	 public CalculatorInvocationHandler(Object proxied) {
	        this.target = (Calculator) proxied;
	    }
	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println(target + " : calling " + method);
		
		if (method.getName().equals("displayResponse")) {
				System.out.println("to do stuff in displayResponse");
		}
		if (method.getName().equals("toString")) {
			System.out.println("to do stuff in toString");
		}
			return method.invoke(target, args);
	}

}
