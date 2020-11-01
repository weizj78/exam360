package MeiTUanExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JINJI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        int x = sc.nextInt();
        //int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list,(a,b)->{return -(a-b);});
        int temp = list.get(x);
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (list.get(i) >= temp && list.get(i) != 0) num++;
        }
        System.out.println(num);
    }

}
