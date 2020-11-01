package day21;

import NiuKe.MaxLength;

import java.util.*;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int num = sc.nextInt();
        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(map.containsKey(c)) map.get(c).add(i);
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(c,list);
            }
        }
        Iterator<Character> iterator = map.keySet().iterator();
        int res = 0;
        while (iterator.hasNext()){
            char c = iterator.next();
            ArrayList<Integer> list = map.get(c);
            int len = list.size();
            int [][]arr = new int[len][len];
            for (int i = 1; i < len; i++) {
                for (int j = i-1; j >=0 ; j--) {
                    int dis = list.get(i)-list.get(j)-(i-j);
                    if(i!=j+1)
                        dis+=arr[j+1][i-1];
                    arr[j][i] = dis;
                    if(arr[j][i]<num) res = (i-j+1)>res?(i-j+1):res;
                }
            }
        }
        System.out.println(res);
    }
}
