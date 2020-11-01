package MeiTUanExam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            int []arr = new int[m];
            for (int i = 0; i < m; i++) {
                arr[i] = sc.nextInt();
            }
            boolean flag = true;
            int num = n-m;
            boolean []ab = new boolean[2];
            for (int i = 0; i < m; i++) {
                if(ab[0]==false) ab[0] = arr[i] == a;
                if(ab[1]==false) ab[1] = arr[i] == b;
                if(arr[i]>a&&arr[i]>b) {
                    flag = false;
                    break;
                }
                if(arr[i]<a&&arr[i]<b) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                if(ab[0] == true&&ab[1] == true)
                    System.out.println("YES");
                else if(ab[0]==true||ab[1]==true){
                    if(n-m>=1)
                        System.out.println("YES");
                    else System.out.println("NO");
                }else {
                    if(n-m>=2){
                        System.out.println("YES");
                    }else {
                        System.out.println("NO");
                    }
                }
            }else {
                System.out.println("NO");
            }

        }
    }
}
