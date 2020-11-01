package LianTong;

import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String str2 = sc.next();
        int count = 0;
        while (str.contains(str2)){
            int i = str.indexOf(str2);
            count++;
            str = str.substring(i+1);
        }
        System.out.println(count);
    }
}
