package day21;

import java.util.Scanner;

public class ThreeTwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int lastRoom = sc.nextInt();
        long []arr = new long[n+1];
        long minvalue = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextLong();
        }
        for (int i = lastRoom; i >=1 ; i--) {
            if(arr[i]<minvalue){
                minvalue = arr[i];
                index = i;
            }
        }
        for (int i = n; i >lastRoom ; i--) {
            if(arr[i]<minvalue){
                minvalue = arr[i];
                index = i;
            }
        }
        long x = lastRoom<index?lastRoom+n-index:lastRoom-index;
        arr[index] = minvalue*n+x;
        System.out.println(index+" "+x);
        for (int i = 1; i <= n; i++) {
            if(i == index) continue;
            arr[i] -= minvalue;
            if(i-index>=0&&i-index<=x) arr[i] -=1;
            else if(n-index+i<=x) arr[i] -=1;
        }
        for (int i = 1; i <= n; i++) {
            if(i!=n) System.out.print(arr[i]+" ");
            else System.out.println(arr[i]);
        }


    }
}
