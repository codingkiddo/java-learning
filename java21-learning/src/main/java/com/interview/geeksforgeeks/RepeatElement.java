package com.interview.geeksforgeeks;

public class RepeatElement {

	private void printRepeatingElements(int[] a, int length) {
		for ( int i=0; i<length-1; i++) {
			for ( int j=i+1; j<length; j++) {
				if ( a[i] == a[j]) {
					System.out.print(a[j] + " ");
					break;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		RepeatElement repeat = new RepeatElement();
        int arr[] = { 4, 2, 4, 5, 2, 3, 1 };
        int arr_size = arr.length;
        repeat.printRepeatingElements(arr, arr_size);
	}

}

