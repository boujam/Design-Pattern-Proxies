package com.test.pattern.designpatterns;

import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import com.test.pattern.interfaces.Operation;
import com.test.pattern.models.Calculator;
import com.test.pattern.proxies.CalculatorInvocationHandler;
import com.test.pattern.proxies.CalculatorInvocationHandler2;

public class App2 {

	public static void main(String[] args) {

		Calculator calculator = new Calculator();
		calculator.setNumber1(5);
		calculator.setNumber2(10);

		//Dynamic Proxy (using JDK)
        Class[] calcInterface = new Class[] {Operation.class};
        CalculatorInvocationHandler handler = new CalculatorInvocationHandler(calculator);
        
        //create the dynamic proxy
        Operation calcProxy = (Operation) Proxy.newProxyInstance(
        			Thread.currentThread().getContextClassLoader(), 
        			calcInterface,
        			handler);
        
        calcProxy.displayResponse();
        calcProxy.toString();
//        calcProxy.fullMemory();
        
        
        calculator.setNumber1(20);
		calculator.setNumber2(10);
        
        //Dynamic Proxy (using CGLIB)
        Calculator proxy = (Calculator) Enhancer.create(
            Calculator.class,
            new CalculatorInvocationHandler2(calculator));
         
        proxy.displayResponse();


	}

}
