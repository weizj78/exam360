package NiuKe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxLength {
    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.left = new TreeNode();
        root.left.val= 0;
//        root.right = new TreeNode();
//        root.right.val=3;
        MaxLength leng = new MaxLength();
        System.out.println(leng.sumNumbers(root));
    }
    public int sumNumbers (TreeNode root) {
        if(root==null) return 0;
       List<Integer> list = new ArrayList<>();
       getNumber(root,0,list);
       int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum+=list.get(i);
        }
        return sum;
    }
    public void getNumber(TreeNode root, int value, List<Integer> list){
        if(root.left==null&&root.right==null){
            list.add(value*10+root.val);
        }
        if(root.left!=null){
            getNumber(root.left,value*10+root.val,list);
        }
        if(root.right!=null){
            getNumber(root.right,value*10+root.val,list);
        }

    }
}
