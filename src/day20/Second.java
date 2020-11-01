package day20;

import java.util.Scanner;
import java.util.TreeSet;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        int maxVal = 0;
        int minvalue = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            set.add(num);

        }
        System.out.println(maxVal);
    }
}
