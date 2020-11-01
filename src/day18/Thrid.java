package day18;

import java.util.ArrayList;
import java.util.Scanner;

public class Thrid {
    public static void main(String[] args) {
        int []arr = new int[13];
        int []count = new int[10];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 13; i++) {
            arr[i] = sc.nextInt();
            count[arr[i]]++;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if(count[i]+1<=4){
                count[i]+=1;
                if(isWin(count)){
                    list.add(i);
                }
                count[i]-=1;
            }
        }
        if(list.size()==0) System.out.println(0);
        else {
            for (int i = 0; i < list.size(); i++) {
                if(i != list.size()-1) System.out.print(list.get(i)+" ");
                else System.out.print(list.get(i));
            }
        }

    }
    public static  boolean isWin(int []count){
        //选择雀头
        for (int i = 1; i <= 9; i++) {
            if(count[i]>=2){
                count[i] -=2;
                if(hasTrip(count,4)){
                    count[i] +=2;
                    return true;
                }
                count[i]+=2;
            }
        }
        return false;
    }

    public static boolean hasTrip(int []count,int num){
        if(num ==0) return true;
        for (int i = 1; i <=9 ; i++) {
            if(count[i]>=3) {
                count[i] -= 3;
                if(hasTrip(count,num-1)){
                    count[i-1]+=3;
                    return true;
                }
                count[i] += 3;
            }
            if(i>=2&&i<=8&&count[i]>=1&&count[i-1]>=1&&count[i+1]>=1){
                count[i-1]-=1;
                count[i]-=1;
                count[i+1]-=1;
                boolean flag = hasTrip(count,num-1);
                count[i-1]+=1;
                count[i]+=1;
                count[i+1]+=1;
                if(flag) return true;
            }
        }
        return false;
    }


}
