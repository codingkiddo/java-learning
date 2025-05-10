package com.example.java8.oca;

interface HasTail { int getTailLength(); }

abstract class Puma implements HasTail {
//	Cannot reduce the visibility of the inherited method from HasTail
 protected int getTailLength() {return 4;}
}

public class Cougar {

}
