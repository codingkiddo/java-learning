package com.codingkiddo.generics;


class Box {
    private Object value;
    public void set(Object v) { this.value = v; }
    public Object get()       { return this.value; }
}


public class BenericsBasics1 {

	public static void main(String[] args) {

		Box box = new Box();
		box.set("Hello");
		String s = (String) box.get();  // you must cast manually
		System.out.println(s);
		
		box.set("Hello");
//		box.set(42);        // also compiles! No error.
		Integer n = (Integer) box.get();  // ClassCastException at runtime 💥
//		Exception in thread "main" java.lang.ClassCastException: class java.lang.String 
//		cannot be cast to class java.lang.Integer (java.lang.String and java.lang.Integer 
//		are in module java.base of loader 'bootstrap')
//			at com.codingkiddo.generics.BenericsBasics1.main(BenericsBasics1.java:22)

		System.out.println(n);
	}

}
