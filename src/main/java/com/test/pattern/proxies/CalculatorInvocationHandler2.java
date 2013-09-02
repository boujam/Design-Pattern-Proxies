package com.test.pattern.proxies;

import java.lang.reflect.Method;

import com.test.pattern.models.Calculator;

import net.sf.cglib.proxy.InvocationHandler;

public class CalculatorInvocationHandler2 implements InvocationHandler {

	private Calculator target;
	
	 public CalculatorInvocationHandler2(Object proxied) {
	        this.target = (Calculator) proxied;
	    }
// to use with MethodInterceptor Interface	 
//	public Object intercept(Object obj, Method method, Object[] args,
//			MethodProxy proxy) throws Throwable {
//		System.out.println(target + " : calling " + method);
//		
//		if (method.getName().equals("displayResponse")) {
//				System.out.println("to do stuff in displayResponse");
//		}
//		if (method.getName().equals("toString")) {
//			System.out.println("to do stuff in toString");
//		}
//			return method.invoke(target, args);
//	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("cglib proxy");
		return method.invoke(target, args);
	}
}
