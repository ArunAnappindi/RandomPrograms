/**
 * 
 */
package main.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 503054866
 *
 */
public class HappinessPoints {

	
	public static int minNum(int threshold, List<Integer> alist) {
		
		int numProb = 2; //Min Two problems are to be solved to check the threshold with happiness points
		Collections.sort(alist, Collections.reverseOrder()); //Sort the list in descending order
		
		for(int i = 1; i <= alist.size()-1; i++) {
			//Take the maximum point question and reduce it with each question to compare if the threshold is reached.
			if(alist.get(0) - alist.get(i) <= threshold) {
				numProb++;
			} 
		}
		return numProb;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> alist = new ArrayList<>();
		
		alist.add(10);
		alist.add(9);
		alist.add(7);
		alist.add(8);
		alist.add(0);
		alist.add(2);
		
		
		minNum (4, alist);
	}

}
