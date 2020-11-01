package day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class First {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 1; i < n+1; i++) {
            int k = sc.nextInt();
            if(!map.containsKey(k)){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(k,list);
            }else {
                map.get(k).add(i);
            }
        }
        int qnum = sc.nextInt();
        for (int i = 0; i < qnum; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int k = sc.nextInt();
            ArrayList<Integer> list = map.get(k);
            long count = 0;
            int temp;
            for (int j = 0; list!=null&&j < list.size(); j++) {
                temp = list.get(j);
                if(temp>end) break;
                else if(temp>=start&&temp<=end) count++;
            }

            System.out.println(count);
        }
    }
}
