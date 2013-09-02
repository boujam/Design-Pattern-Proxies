package com.test.pattern.designpatterns;

import com.test.pattern.interfaces.Operation;
import com.test.pattern.models.Calculator;
import com.test.pattern.proxies.CalculatorProxyInterfaceStyle;
import com.test.pattern.proxies.CalculatorProxyInheritedStyle;

public class App 
{
    public static void main( String[] args )
    {
    	   	
    	System.out.println( "Proxies examples" );
    	
//    	create the target
    	Calculator calculator = new Calculator();
        calculator.setNumber1(5);
        calculator.setNumber2(8);
    	
        
        //Proxy (using interface : implements)
        //create de Proxy and wrap the target
        Operation calcProxy = new CalculatorProxyInterfaceStyle(calculator,true);
        calcProxy.displayResponse();
        
        	
        //Proxy (using inheritance : extends)
        //create the Proxy and wrap the target
        Calculator calcProxy2 = new CalculatorProxyInheritedStyle(calculator, true);
        calcProxy2.displayResponse();

    }
}
