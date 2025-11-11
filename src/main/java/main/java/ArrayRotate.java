package main.java;

public class ArrayRotate {

    static int count = 0;

    public static void main(String[] args) {
        ArrayRotate rotate = new ArrayRotate();
        int arr[] = {1, 2, 3, 4, 5, 6};
        rotate.rightRotate(arr, 2, 6);
        rotate.printArray(arr, 6);
    }

    void leftRotate(int arr[], int d, int n) {
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
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

    void rightRotate(int arr[], int d, int n) {
        int i, j, k, temp;
        int g_c_d = gcd(d, n);
        for (i = 0; i < g_c_d; i++) {
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

    void printArray(int arr[], int size) {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
    }

    int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return gcd(b, a % b);
    }

}

