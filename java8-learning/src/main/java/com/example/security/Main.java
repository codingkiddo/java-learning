package com.example.security;

import java.security.Provider;
import java.security.Security;

import sun.security.util.Debug;

public class Main {

	/* Are we debugging? -- for developers */
    private static final Debug sdebug =
                        Debug.getInstance("properties");
    
//	private static final sun.security.util.Debug debug =
//	        sun.security.util.Debug.getInstance
//	        ("provider", "Provider");
	
	public static void main(String[] args) {

//		System.out.println(sdebug.hashCode());
		
		for(Provider provider : Security.getProviders()) {
			for ( Provider.Service service : provider.getServices() ) {
				System.out.println( service.getClassName() + ":" + service.getAlgorithm() );
			}
		}
		
	}
}
