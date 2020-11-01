package day21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Second {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            for (int j = 0; j < num; j++) {
                int color = sc.nextInt();
                if(!map.containsKey(color)){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.put(color,list);
                }else map.get(color).add(i);
            }
        }
        int count = 0;
        for (int i = 1; i <= c; i++) {
            ArrayList<Integer> list = map.get(i);
            if(list!=null){
                int lastindex = list.get(0);
                int temp;
                boolean flag = true;
                for (int j = 1; j < list.size(); j++) {
                    temp = list.get(j);
                    if(temp-lastindex<m){
                        flag = false;
                        break;
                    }
                    lastindex = temp;
                }
                if(!flag) count++;
                else if(flag&&list.size()>1&&n-list.get(list.size()-1)+list.get(0)<m) count++;
            }
        }
        System.out.println(count);
    }
}
