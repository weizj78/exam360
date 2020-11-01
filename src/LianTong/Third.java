package LianTong;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Third {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            list.add(i);
        }
        int i = 0;
        Iterator<Integer> iterator = list.iterator();
        while (list.size()>0){
            if (!iterator.hasNext()){
                iterator = list.iterator();
            }
            Integer num = iterator.next();
            i++;
            if(i==n){
                System.out.print(num);
                iterator.remove();
                if(list.size()!=0)
                    System.out.print(" ");
                i = 0;
            }
        }
        System.out.println();
    }
}
