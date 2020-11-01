package DesignPattern.jianzhioffer;

public class Fibo {
    public int Fibonacci(int n) {
//        if(n==0) return 0;
//        if(n==1) return 1;
//        return Fibonacci(n-1)+Fibonacci(n-2);

        int []arr = new int[n+1];

        for (int i = 0; i <= n; i++) {
            if(i<=1) arr[i] = i;
            else
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
    public int JumpFloor(int target) {
        int []arr = new int[target+1];
        for (int i = 0; i < target+1; i++) {
            if(i<=2) arr[i] = i;
            else arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[target];
    }
    public int JumpFloorII(int target) {
        int res = 1;
        for (int i = 1; i < target; i++) {
             res = 2*res;
        }

        return res;
    }
}
