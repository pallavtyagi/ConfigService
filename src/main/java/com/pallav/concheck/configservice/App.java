package com.pallav.concheck.configservice;

import java.io.IOException;

import com.pallav.concheck.configservice.constantsgen.ConstantsGen;
import com.pallav.concheck.configservice.init.AppLoader;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        AppLoader init = AppLoader.getInstance();
        if(init.loadProperties()){
        	System.out.println("App properties loaded and now creating Constants Files... ");
        	ConstantsGen cGen = new ConstantsGen();
        	try {
				cGen.generateConstants(init.getConfigs());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        else 
        	System.out.println("App properties not loaded properly...");
        
    }
}
