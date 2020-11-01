package MeiTUan;

import java.util.Scanner;

public class NewLRU {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String []str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = new String(scanner.next());
        }
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int num = 0;
            for (int i = 0; i < str[a-1].length()&&i<str[b-1].length(); i++) {
                System.out.println(str[a-1].charAt(i)+" "+str[b-1].charAt(i));
                if(str[a-1].charAt(i) == str[b-1].charAt(i)){
                    num++;
                }else break;
            }
            System.out.println(num);
        }
    }
}
