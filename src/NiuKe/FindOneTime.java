package NiuKe;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class FindOneTime {
    public static void main(String[] args) {
        int []arr = {2,4,3,6,3,2,5,5};
        int []a1 = new int[1];
        int []a2 = new int[1];
        FindNumsAppearOnce(arr,a1,a2);
        System.out.println(a1[0]);
        System.out.println(a2[0]);
    }
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if(hashMap.containsKey(array[i])){
                hashMap.remove(array[i]);
            }else {
                hashMap.put(array[i],1);
            }
        }
        Set<Integer> integers = hashMap.keySet();
        Iterator<Integer> iterator = integers.iterator();
        num1[0] = iterator.next();
        num2[0] = iterator.next();
    }
}
