package DesignPattern.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindStackarray {
    public static void main(String[] args) {
        int []arr1 = {1,2,3,4,5};
        int []arr2 = {4,5,3,2,1};
        int []arr3 = {4,3,5,1,2};
        System.out.println(IsPopOrder(arr1, arr2));
        System.out.println(IsPopOrder(arr1, arr3));
    }
    public static  boolean IsPopOrder(int [] pushA,int [] popA) {

        Stack<Integer> stack = new Stack<>();
        int len = pushA.length;
        int j = 0;
        for (int i = 0; i < len; i++) {
            stack.push(pushA[i]);
            while (stack.peek() == popA[j]){
                stack.pop();
                j++;
                if(stack.isEmpty()) break;
             }
        }
        return stack.isEmpty();
    }


    /**
     * 逐层打印二叉树
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> reslist = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root!=null)
            list.add(root);
        TreeNode temp ;
        while (list.size()!=0){
            temp = list.getFirst();
            reslist.add(temp.val);
            list.removeFirst();
            if(temp.left!=null) list.add(temp.left);
            if(temp.right!=null) list.add(temp.right);
        }

        return reslist;

    }
}
