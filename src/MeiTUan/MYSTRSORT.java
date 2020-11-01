package MeiTUan;

import java.util.Comparator;
import java.util.Scanner;

public class MYSTRSORT implements Comparator<String> {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String []strs = sc.next().split(",");
        MYSTRSORT sort = new MYSTRSORT();
        sort.quickSort(strs,0,strs.length-1);
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]);
            if(i!=strs.length-1){
                System.out.print(",");
            }
        }
    }

    public void myPrint(String []strs){
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i]);
            if(i!=strs.length-1){
                System.out.print(",");
            }
        }
        System.out.println();

    }

    public void quickSort(String []arr,int left,int right){
        if(left>=right) return;
        int x = left;
        int y = right;
        String temp = arr[left];
        while (right>left){
            while (right>left&&compare(temp,arr[right])>=0) {
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&compare(temp,arr[left])<=0) left++;
            arr[right] = arr[left];
        }

        arr[left] = temp;
        quickSort(arr,x,left-1);
        quickSort(arr,left+1,y);
    }


    @Override
    public int compare(String o1, String o2) {
        for (int i = 0; i <o1.length()&&i<o2.length() ; i++) {
            if(o1.charAt(i)==o2.charAt(i)){
                continue;
            }

            else return o1.charAt(i)-o2.charAt(i);
        }
        return -(o1.length()-o2.length());
    }
}
