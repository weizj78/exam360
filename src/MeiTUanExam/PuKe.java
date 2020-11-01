package MeiTUanExam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class PuKe {
    public static void main(String[] args) {
        int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        LinkedList<Character> list = new LinkedList<>();
        int num = 0;
        for (int i = 0; i < n; i++) {
            if(i == 0)
                list.add(sc.next().charAt(0));
            else {
                char s = sc.next().charAt(0);
                if(list.contains(s)){
                    int len = list.size();
                    int k = list.indexOf(s);
                    int tempres = len-list.indexOf(s)+1;
                    num = Math.max(tempres,num);
                    while (list.size()>k){
                        list.removeLast();
                    }
                }else {
                    list.add(s);
                }

            }
        }
        System.out.println(num);
    }

}
