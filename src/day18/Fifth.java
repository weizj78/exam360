package day18;

import java.util.Scanner;

public class Fifth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [][]arr = new int[n][n];
        int []city = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        city[0] = -1;
        System.out.println(workWeight(arr, city, 0, 1));
    }
    public static int workWeight(int [][]arr,int []city,int curCity,int number){
       if(number == city.length) return arr[curCity][0];

        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < city.length; i++) {
            if(city[i]!=-1&&i!=curCity){
                city[i] = -1;
                minValue = Math.min(arr[curCity][i]+workWeight(arr,city,i,number+1),minValue);
                city[i] = 0;
            }
        }
        return minValue;
    }


}
