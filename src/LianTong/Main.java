package LianTong;

import java.util.*;
public class Main{
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        double money = sc.nextDouble();
        double mon = sc.nextInt();
        double zhao = mon - money;
        int n10 = (int)zhao/10;
        int n5 = (int)zhao%10/5;
        int n1 = (int)zhao%10%5/1;
        double res = zhao - (int)zhao;
        double n05 = res/0.5;
        double n01 = res%0.5/0.1;
        String format = String.format("%.1f", zhao);

        System.out.print(format+" ");
        if(n10>0){
            System.out.print(10+":"+n10+";");
        }
        if(n5>0){
            System.out.print(5+":"+n5+";");
        }
        if(n1>0){
            System.out.print(1+":"+n1+";");
        }
        if(n05>0){
            System.out.println(0.5+":"+(int)n05+";");
        }
        if(n01>0){
            System.out.println(0.1+":"+(int)n01+";");
        }
    }
}
