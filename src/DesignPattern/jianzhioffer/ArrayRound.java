package DesignPattern.jianzhioffer;

public class ArrayRound {
    public int minNumberInRotateArray(int [] array) {

        if(array.length == 0) return 0;
        int left = 0;
        int right = array.length-1;
        while (left<=right){
            int mid = (left+right)/2;
            if(right-left==1) return array[left];
            if(array[mid]>=array[0]){
                left = mid;
            }
            if(array[mid]<=array[0]){
                right = mid;
            }
        }
        return -1;
    }
}
