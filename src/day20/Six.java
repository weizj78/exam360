package day20;

import java.util.Scanner;

public class Six {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1024 - n;
        int num64 = res/64;
        int num16 = res%64/16;
        int num4 = res%64%16/4;
        int num1 = res%64%16%4;
        System.out.println(num64+num16+num4+num1);
    }
}
