package main.java;

public class CountPairsInArray {

    static int sockMerchant(int n, int[] arr) {
        int[] temp;

        if (n % 2 == 0) {
            temp = new int[n / 2];
        } else {
            temp = new int[n - 1 / 2];
        }

        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i] % 2);
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {19, 20, 20, 10, 10, 30, 50, 10, 20};
        sockMerchant(arr.length, arr);
    }

}

