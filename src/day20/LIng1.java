package day20;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LIng1 {
    public static void main(String[] args) {
        int []w = {5,8,4};
        int []v = {18,20,7};
        int size = 10;

        int [][]arr = new int[w.length][size+1];

        for (int i = 0; i < w.length; i++) {
            for (int j = 1; j <= size; j++) {
                if(i==0&&j>w[i]){
                    arr[i][j] = v[i];
                }else if(i!=0){
                    if(j<w[i]){
                        arr[i][j] = arr[i-1][j];
                    }else if(j==w[i]){
                        arr[i][j] = Math.max(arr[i-1][j],v[i]);
                    }else {
                        arr[i][j] = Math.max(v[i]+arr[i-1][j-w[i]],arr[i-1][j]);
                    }
                }
            }
        }
        System.out.println(arr[w.length-1][size]);

    }
    public ListNode detectCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1!=null&&p1.next!=null){
            p1 = p1.next.next;
            p2 = p2.next;
            if(p1 == p2 ) break;
        }
        if(p1 == null || p1.next == null) return null;
        p1 = head;
        while (p1!=p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    @Test
    public void test(){
        String str = "[])";
        System.out.println(isValid(str));
    }
    public int[] twoSum (int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i],i);
        }
        int []arr = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int temp = target - numbers[i];
            if(map.containsKey(temp)&&map.get(temp)!=i){
                arr[0] = i+1;
                arr[1] = map.get(temp)+1;
                return arr;
            }
        }
        return arr;
    }

    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(stack.isEmpty()&&(c == ')'||c == ']'||c == '}')){
                return false;
            }else if(c == '{'||c == '['||c == '('){
                stack.add(c);
            }else if(!stack.isEmpty()){
                if(c==')'&&stack.peek()=='(')
                    stack.pop();
                else if(c==']'&&stack.peek()=='[')
                    stack.pop();
                else if(c=='}'&&stack.peek()=='{')
                    stack.pop();
                else return false;

            }
        }
        return stack.isEmpty();
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }

