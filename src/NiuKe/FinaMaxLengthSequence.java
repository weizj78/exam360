package NiuKe;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class FinaMaxLengthSequence {
    public static void main(String[] args) {
        int []a = {100,4,200,1,3,2,300,400};
        System.out.println(MLS(a));
    }
    public static  int MLS (int[] arr) {
        // write code here
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        Iterator<Integer> iterator = set.iterator();
        int maxlength = 0;
        int templenth = 1;
        int startvalue = iterator.next();
        while (iterator.hasNext()){
            int temp = iterator.next();
            if(temp-startvalue==1){
                templenth++;
                maxlength = Math.max(maxlength,templenth);
            }else {
                maxlength = Math.max(maxlength,templenth);
                templenth = 1;
            }
            startvalue= temp;

        }
        return maxlength;
    }
}
