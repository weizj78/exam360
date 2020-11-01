package day18;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int []arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long res = 0;
        for (int i = 0; i < n-2; i++) {
            for (int j = n-1; j > i+1; j--) {
                if(arr[j]-arr[i]>d) continue;
                long num = j - i;
                res+=num*(num-1)/2%99997867;
                break;
            }
        }
        System.out.println(res%99997867);
    }
}
