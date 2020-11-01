package day20;

import java.util.Scanner;

public class Seven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n+1];
        arr[0] = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(get(arr, 1));
    }
    public static int get(int []arr,int k){
        if(k == arr.length-1)
            return arr[k]/2+arr[k]%2;
        else {
            int temp = get(arr,k+1)+arr[k];
            return temp/2+temp%2;
        }
    }


}
