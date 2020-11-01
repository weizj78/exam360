package DesignPattern.jianzhioffer;

public class JuXing {
    public static void main(String[] args) {
//        System.out.println(2&1);
        JuXing juxing = new JuXing();
        System.out.println(juxing.NumberOf1(-1));
    }
    public int RectCover(int target) {

        int []arr = new int[target+1];
        for (int i = 0; i <=target ; i++) {
            if(i<=2) arr[i] = i;
            else {
                arr[i] = arr[i-1]+arr[i-2];
            }
        }
        return arr[target];
    }
    public int NumberOf1(int n) {
        int num = 0;
        while (n!=0){
           num++;
           n = n &(n-1);
        }
        return num;
    }
}
