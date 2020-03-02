package main.java;


/**
 * This problem was asked by Stripe.

	Given an array of integers, find the first missing positive integer in linear time and constant space. 
	In other words, find the lowest positive integer that does not exist in the array. 
	The array can contain duplicates and negative numbers as well.
	
	For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
	
	You can modify the input array in-place.

 * @author 503054866
 *
 */

public class FirstMissingPositiveInteger {
	
	
	public int lowestInteger(int[] A) {
		int lowestInteger = 1;
		
		for (int i =0; i< A.length; i++) {
			while (A[i]>=0 && A[i] != i && A[i] < A.length) {
				int temp = A[A[i]];
				 A[A[i]] = A[i];
				 A[i] = temp;
				 if(A[i] == A[A[i]]) {
					 break;
				 }
			}
		}
		
		for(int i = 0; i< A.length; i++) {
			if(A[i] == 0) {
				continue;
			}
			if(A[i] > 0 && A[i] == lowestInteger) {
				lowestInteger++;
			}
		}
		System.out.println(lowestInteger);
		return lowestInteger;
		
	}
	
	public static void main(String[] args) {
		FirstMissingPositiveInteger integer = new FirstMissingPositiveInteger();
		int[] A = {1,1,5,2,3,4,7,0,6,8};
		System.out.println(integer.lowestInteger(A));
	}

}
