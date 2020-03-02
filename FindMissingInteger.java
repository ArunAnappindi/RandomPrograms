package main.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
 * 
 * 
 * 
 * 
 * @author 503054866
 *
 */


public class FindMissingInteger {

	public static void main(String[] args) {

		/*int[] a = {1,2,3};
		int test = smallestPostiveInteger(a);
		System.out.println(test);*/
		
		
		//Wait for response
		boolean wait = false;
			while (!wait) {
				System.out.println(" 9879 " + wait);
				wait = true;
				
				if (wait) {
					System.out.println("Did not receive response in 2 seconds");
				}
			}
			
			/*if (!wait) {
				System.out.println("Did not receive response in 2 seconds");
			}*/
			
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		list.remove(4);
		list.add(6);
		
		for (Integer i: list) {
			System.out.println(i);
		}
		
	}
	
	public static int smallestPostiveInteger(int[] a) {
		
		if(a.length == 1 && a[0] > 0) {
			return a[0];
		}
		TreeSet<Integer> t = new TreeSet<Integer>();
		for (int i =0; i <a.length; i++) {
			if(a[i] > 0) {
				t.add(a[i]);
			}
		}
		
		Iterator<Integer> it = t.iterator();
		
		int firstValue = t.first();
		while(it.hasNext()) {
			int value = it.next();
			if (value > firstValue) {
				if(value-1 == firstValue) {
					firstValue = value;
					continue;
				} else {
					firstValue = firstValue+1;
					System.out.println(firstValue);
					return firstValue;
				}
				
			}
		}
		return firstValue+1;
	}
}
