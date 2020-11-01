package DesignPattern.jianzhioffer;

import java.util.Arrays;

public class Ncimi {
    public static void main(String[] args) {
        Ncimi ncimi = new Ncimi();
        int []array = {1,2,3,4,5,6,7,8,9};
        ncimi.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }
    public  double Power(double base, int exponent) {
        return exponent>=0?myPower(base,exponent):(1/myPower(base,-exponent));
    }

    public  double myPower(double base,int exp){
        if(base==0) return 0;
        if(exp == 1) return base;
        if(exp == 0) return 1;
        double res = myPower(base,exp>>1);
        return (exp%2==0?1:base)*res*res;
    }


    /**
     * 调整数组奇数与偶数的位置
     * @param array
     */
    public void reOrderArray(int [] array) {
        int right = -1;//第一个偶数的位置

        int len = array.length;
        for (int i = 0; i < len; i++) {
            if(array[i]%2==0&&right==-1) {
                right = i;
                continue;
            }
            if(array[i]%2!=0&&right==-1) {
                continue;
            }

            if(array[i]%2!=0){
                int temp = array[i];
                System.arraycopy(array,right,array,right+1,i-right);
                array[right] = temp;
                right++;
            }

        }
    }
}
