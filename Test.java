package main.java;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*Map<Substring, String> test1 = new HashMap<>();
		test1.put(new Substring("ARG1"), "Val1");
		test1.put(new Substring("ARG1"), "valkw");
		
		String te = test1.get(new Substring("ARG1"));
		Substring s = new Substring("ARG1");
		test1.put(s, "Val1");
		s = new Substring("ARG1");
		test1.put(s, "valkw");
		
		//String te = test1.get(s);
		System.out.println(te);*/
		
		double phase = 750d / (60000 / 60d) * 100 * 0.01; 
		
		double ms = 60000/60 * 0.05 / 100;
		
		/*int[] A = {4,1,3};
		
		int max = Arrays.stream(A)
			      .max()
			      .getAsInt();
		
		int permutation = solution(A, 4);*/
		System.out.println(phase + "   " + ms);
			
		
	}
	
	/**
	 * For example, array A such that:

		    A[0] = 4
		    A[1] = 1
		    A[2] = 3
		    A[3] = 2
		is a permutation, but array A such that:
		
		    A[0] = 4
		    A[1] = 1
		    A[2] = 3
		is not a permutation, because value 2 is missing.
	 * 
	 * 
	 * @param A
	 * @param N
	 * @return
	 */
	
	public static int solution(int[] A, int N) {
		
		int max = Arrays.stream(A)
			      .max()
			      .getAsInt();
		int[] temp = new int[max+1];
		temp[0] = 1;
		
		for (int i =0; i < A.length; i++) {
			int num = A[i];	
			//int count = 0;
			if (temp[num] != 0) {
				//count = temp[num] + 1;
				temp[num] =  temp[num] + 1;
			} else {
				temp[num] = 1;
			}
		}
		
		for (int i =1; i < temp.length; i++) {
			if (temp[i] == 0) {
				return 0;
			} else {
				continue;
			}
		}
		
		return 1;
	}
	
public static int solutionAlter(int[] A, int N) {
		
		int max = Arrays.stream(A)
			      .max()
			      .getAsInt();
		int[] temp = new int[max+1];
		temp[0] = 1;
		
		for (int i =0; i < A.length; i++) {
			int num = A[i];	
			//int count = 0;
			if (temp[num] != 0) {
				//count = temp[num] + 1;
				temp[num] =  temp[num] + 1;
			} else {
				temp[num] = 1;
			}
		}
		
		for (int i =1; i < temp.length; i++) {
			if (temp[i] == 0) {
				return 0;
			} else {
				continue;
			}
		}
		
		return 1;
	}
	

}
