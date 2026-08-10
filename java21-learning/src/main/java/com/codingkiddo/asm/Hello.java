package com.codingkiddo.asm;

import java.io.File;

public class Hello {
	
    static int count = 5;
    
    static {
        System.out.println("Kitchen open!");
    }
    
    public static void main(String[] args) {
    	System.out.println(count);
    	ClassLoader cl = Hello.class.getClassLoader();
    	System.out.println("ClassLoader: " + cl);
    	System.out.println("Classpath entries:");

        String classpath = System.getProperty("java.class.path");
        String[] entries = classpath.split(File.pathSeparator);

        for (String entry : entries) {
            System.out.println(entry);
        }

        System.out.println("Location : " + Hello.class.getProtectionDomain().getCodeSource().getLocation());
    }
    
}
