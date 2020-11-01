package MeiTUan;

import NiuKe.MaxLength;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.next();
            int maxlen = 0;
            int len = str.length();
            int num = 0;
            HashMap<Character,Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                char s = str.charAt(i);
                num = map.containsKey(s)?map.get(s)+1>num?map.get(s)+1:num:num;
                maxlen = Math.max(i-num+1,maxlen);
                map.put(s,i);
            }
            System.out.println(maxlen);
        }
    }
}
