package com.example.reflection;

import java.lang.annotation.Annotation;

import org.springframework.jms.annotation.EnableJms;

public class MainReflection {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		Class<?> cls = JmsConfig.class;
//		System.out.println(cls);
		Annotation[] annotations = cls.getAnnotations();
		
//		Class<?> enableJmsAnnotationClass = EnableJms.class;
//		System.out.println(enableJmsAnnotationClass);
		
		for(Annotation a : annotations) {
//			System.out.println(a.annotationType().getCanonicalName());
			Class<?> enableJmsAnn = Class.forName(a.annotationType().getCanonicalName());
//			System.out.println(enableJmsAnn);
			System.out.println(a.annotationType().equals(enableJmsAnn));
		}
	}
}
