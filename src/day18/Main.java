package day18;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            String str = sc.next();
            StringBuilder builder = new StringBuilder();
            int curnum = 0;
            int lastnum = 0;
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(j == 0){
                    builder.append(c);
                    curnum++;
                }else if(c == builder.charAt(builder.length()-1)){
                    curnum++;
                    if(lastnum<2&&curnum<3){
                        builder.append(c);
                    }else {
                        curnum--;
                    }
                }else {
                    builder.append(c);
                    lastnum = curnum;
                    curnum = 1;
                }
            }
            System.out.println(builder.toString());
        }
    }
}
