package day20;

import java.util.Scanner;
import java.util.Arrays;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pointer []arr = new Pointer[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y= sc.nextInt();
            arr[i] = new Pointer(x,y);
        }
        Arrays.sort(arr);
        int i = 0;
        int max = 0;
        for (int j = 0; j < n; j++) {
            if(j == 0) max = arr[j].y;
            else {
                if(arr[j].y<max) {arr[j] = null;continue;};
                max = Math.max(arr[j].y,max);
            }
        }
        for (int j = n-1; j >=0 ; j--) {
            if(arr[j]!=null){
                System.out.println(arr[j].x+" "+arr[j].y);
            }
        }

    }
    static class Pointer implements Comparable<Pointer>{
        int x;
        int y;
        public Pointer(int x,int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pointer o) {
           return o.x-x;
        }
    }
}
