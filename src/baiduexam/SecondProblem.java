package baiduexam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SecondProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int len = str.length();
        int []arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = -1;
        }

        int []brr = new int[len];

        for (int i = 0; i < len; i++) {
            char s = str.charAt(i);
            if(i == 0){
                arr[s-'0'] = 0;
                brr[0] = 0;
            }else {
                if(arr[s-'0'] == -1){
                    brr[i] = brr[i-1]+1;
                    arr[s - '0'] = brr[i];
                }else {
                    brr[i] = Math.min(arr[s-'0']+1,brr[i-1]+1);
                    arr[s-'0'] = Math.min(brr[i-1]+1,arr[s-'0']);
                }
            }
        }
        System.out.println(brr[n-1]);
    }
}
