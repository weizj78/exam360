package baiduexam;

import java.util.ArrayList;
import java.util.Scanner;

public class FIrstProblem {
    public static void main(String[] args) {

        String str = "";

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        int [][]temp = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            temp[a][b] = 1;
        }
        int right = myFind(temp, p);
        int left = myFindleft(temp,p);
        for (int i = left+1; i <= n-right; i++) {
            System.out.print(i);
            if(i != n-right)
                System.out.print(" ");
        }
        System.out.println();
    }

    public static int myFindleft(int [][]arr,int num){
        int left=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr[0].length; i++) {
            if(arr[i][num] == 1){
                left++;
                arr[i][num] = 0;
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            left+=myFindleft(arr,list.get(i));
        }
        return left;
    }


    public static int myFind(int [][]arr,int num){
        int right=0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < arr[0].length; i++) {
            if(arr[num][i] == 1){
                right++;
                arr[num][i] = 0;
                list.add(i);
            }
        }
        
        for (int i = 0; i < list.size(); i++) {
            right+=myFind(arr,list.get(i));
        }
        return right;
    }
}
