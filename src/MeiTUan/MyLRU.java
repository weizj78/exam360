package MeiTUan;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MyLRU {
    //29 3 2 13 3 12 73 22 37 48 59 17 2 13 69 43 32 14 4 2 61 22 40 30 1 4 46 5 65 17 55
    //3 3 92 25 27 97 40 55 74 91 31 7 33 72 62 61 40 16 2 70 61 67 72 8 5 48 9 75 84
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Xiang[] xiang = new Xiang[n];
            for (int i = 0; i < n; i++) {
                xiang[i] = new Xiang();
                xiang[i].a = scanner.nextInt();
                sum+= xiang[i].a;
            }
            for (int i = 0; i < n; i++) {
                xiang[i].b = scanner.nextInt();
            }


        }
    }
}
class Xiang implements Comparable<Xiang> {
    int a;
    int b;
    @Override
    public int compareTo(Xiang o) {
        if(this.b==o.b){
            return (this.a-o.a);
        }
        return -(this.b-o.b);
    }
}
