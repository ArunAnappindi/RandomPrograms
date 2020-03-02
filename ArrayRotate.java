/**
 * 
 */
package main.java;


/**
 * Good morning! Here's your coding interview problem for today.
 * This problem was asked by Amazon.
 * Given an array and a number k that's smaller than the length of the array, rotate the array to the right k elements in-place.
 */

/**
 * @author 503054866
 *
 */
public class ArrayRotate {

	static int count = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		 
		ArrayRotate rotate = new ArrayRotate(); 
        int arr[] = { 1, 2, 3, 4, 5, 6}; 
        rotate.rightRotate(arr, 2, 6); 
        rotate.printArray(arr, 6); 
	}
	
	 /*Function to left rotate arr[] of siz n by d*/
    void leftRotate(int arr[], int d, int n) 
    { 
        int i, j, k, temp; 
        int g_c_d = gcd(d, n); 
        for (i = 0; i < g_c_d; i++) { 
            /* move i-th values of blocks */
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j + d; 
                if (k >= n) 
                    k = k - n; 
                if (k == i) 
                    break; 
                arr[j] = arr[k]; 
                j = k; 
            } 
            arr[j] = temp; 
        } 
    } 
    
    
    /*Function to left rotate arr[] of siz n by d*/
    void rightRotate(int arr[], int d, int n) 
    { 
        int i, j, k, temp; 
        int g_c_d = gcd(d, n); 
        for (i = 0; i < g_c_d; i++) { 
            /* move i-th values of blocks */
            temp = arr[i]; 
            j = i; 
            while (true) { 
                k = j - d; 
                if (k <= n) 
                    k = n - Math.abs(k); 
                if (k == i) 
                    break; 
                arr[j] = arr[k];  
                j = k;
            } 
            arr[j] = temp; 
        } 
    }
  
    /*UTILITY FUNCTIONS*/
  
    /* function to print an array */
    void printArray(int arr[], int size) 
    { 
        int i; 
        for (i = 0; i < size; i++) 
            System.out.print(arr[i] + " "); 
    } 
  
    /*Fuction to get gcd of a and b*/
    int gcd(int a, int b) 
    { 
        if (b == 0) 
            return a; 
        else
            return gcd(b, a % b); 
    } 

}
