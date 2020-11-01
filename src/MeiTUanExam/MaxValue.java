package MeiTUanExam;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int maxvalue = Integer.MIN_VALUE;
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(sc.nextInt());
            }
            for (int j = 0; j < n; j++) {
                int t = j;
                int res = 0;
                while (t == j || t % list.size() != j) {
                    res += list.get(t%list.size());
                    maxvalue = Math.max(res, maxvalue);
                    t++;
                }
            }
            System.out.println(maxvalue);
        }
    }
}
