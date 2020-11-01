package DesignPattern.jianzhioffer;

import org.junit.Test;

import java.util.Arrays;

public class DuiSort {

    public int getleftChild(int n){
        return 2*n+1;
    }

    public int getRightChild(int n){
        return 2*n+2;
    }

    /**
     * 构建初始堆
     * @param arr
     */
    public void buildDui(int []arr){
        int n = (arr.length-1)/2;
        for (int i = n; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
        }
    }


    /**
     * 调整堆
     * @param arr
     * @param i
     * @param length
     */
    public void adjustHeap(int []arr,int i,int length){
        while (i<length){
            int left = getleftChild(i);
            int right = getRightChild(i);
            if(right<length&&arr[right]>arr[i]&&arr[left]<arr[right]){
                swap(arr,i,right);
                i = right;
            }else if(left<length&&arr[left]>arr[i]){
                swap(arr,i,left);
                i = left;
            }else {
                break;
            }
        }
    }


    public void srot(int []arr){
        buildDui(arr);
        int len = arr.length;
        for (int i = len-1; i >0 ; i--) {
            swap(arr,i,0);
            adjustHeap(arr,0,i);
        }
    }


    @Test
    public void test(){
        int []arr = {3,1,4,2,2,2,2,8,5,9,7,6};
        srot(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void swap(int []arr,int x,int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

}
