package day21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ThreeOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char [][]arr = new char[n][m];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            if(str.contains("S"))
            {
                x = i;
                y = str.indexOf("S");
            }
            arr[i] = str.toCharArray();
        }

        System.out.println(walk(arr, n, m, x, y, 0));

    }
    public static int walk(char [][]arr,int n,int m,int x,int y,int len){
        System.out.println(x+" "+y);
        if(arr[x][y] == '#') return -1;
        if(arr[x][y]=='0') return len;
        arr[x][y] = '#';
        ArrayList<Integer> list = new ArrayList<>();
        if(x-1>=0){
            int res1 = walk(arr,n,m,x-1,y,len+1);
            if(res1!=-1) list.add(res1);
        }
        if(x+1<n){
            int res2 = walk(arr,n,m,x+1,y,len+1);
            if(res2!=-1) list.add(res2);
        }
        if(y-1>=0){
            int res3 = walk(arr,n,m,x,y-1,len+1);
            if(res3!=-1) list.add(res3);
        }
        if(y+1<m){
            int res4 = walk(arr,n,m,x,y+1,len+1);
            if(res4!=-1) list.add(res4);
        }
        arr[x][y] = '.';
        if(list.size()>0) return Collections.min(list);
        return -1;
    }

}
