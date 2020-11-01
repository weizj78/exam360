package DesignPattern.jianzhioffer;

public class TwoArrFind {

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        System.out.println(Find(7, arr));

    }


    public static boolean Find(int target, int[][] array) {
        int low = 0;
        int right = array.length - 1;


        while (low<array[0].length&&right>=0){
            if(array[low][right]>target){
                right--;
            }else if(array[low][right]<target){
                low++;
            }else return true;
        }

        return false;
    }
}
