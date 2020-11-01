package NiuKe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class FindMaxDistictChildLength {
    public static void main(String[] args) {
        int []arr = {2,3,4,5};
        System.out.println(maxLength(arr));
    }
    public static int maxLength (int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int len = arr.length;
        int maxlength = 0;
        int lastindex = 0;
        for (int i = 0; i < len; i++) {
           lastindex = map.containsKey(arr[i])?(map.get(arr[i])+1):lastindex;
           maxlength = Math.max(maxlength,i-lastindex+1);
           map.put(arr[i],i);
        }
        return maxlength;
    }
}
