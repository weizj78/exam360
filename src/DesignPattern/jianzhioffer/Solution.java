package DesignPattern.jianzhioffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p1 = head;
        for (int i = 2; i <= 5; i++) {
            p1.next = new ListNode(i);
            p1 = p1.next;
        }
        Solution solution = new Solution();
        System.out.println(solution.FindKthToTail(head, 5).val);
    }
    /**
     * 输出该链表的倒数第n个节点
     * @param head
     * @param k
     * @return
     */
    public ListNode FindKthToTail(ListNode head,int k) {

        ListNode p1= head;
        ListNode p2 = head;
        int num = 0;
        while (p2!=null){
            if(num>=k){
                p1 = p1.next;
            }
            p2 = p2.next;
            num++;
        }
        if(num<k) return null;
        return new ListNode(p1.val);
    }

    /**
     * 输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode head = new ListNode(-1);
        ListNode p = head;
        while (head1!=null||head2!=null){
            if(head1==null&&head2!=null){
                p.next = head2;
            }
            else if(head1!=null&&head2==null){
                p.next = head1;
            }
            else if(head1.val<head2.val){
                p.next = head1;
                p = p.next;
                head1 = head1.next;
            }else{
                p.next = head2;
                p = p.next;
                head2 = head2.next;
            }
        }
        return head.next;

    }

    /**
     * 判断一棵树是不是另外一棵树的子结构
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root2 == null) return false;
        if(root1==null) return false;
        if(root1.val==root2.val)
            if(hasSameChild(root1.left,root2.left)&&hasSameChild(root1.right,root2.right))
                return true;
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    public boolean hasSameChild(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null&&root2!=null) return false;
        if(root1.val == root2.val)
            return hasSameChild(root1.left,root2.left)&&hasSameChild(root1.right,root2.right);
        return false;
    }
    @Test
    public void test(){
        int num = 1;
        int [][]arr ={{1},{2},{3},{4}};
//        for (int i = 0; i < 4; i++) {
//            for (int j = 0; j < 4; j++) {
//                arr[i][j] = num;
//                num ++;
//            }
//        }
        System.out.println(Arrays.toString(printMatrix(arr).toArray()));
    }

    /**
     * 获取镜像二叉树
     * @param root
     */
    public void Mirror(TreeNode root) {

        if(root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);

    }


    /**
     * 按照从外向里以顺时针的顺序依次打印出每一个数字
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        int rowlen = matrix.length-1;
        int len = matrix[0].length-1;
        int rowstart = 0;
        int lenstart = 0;

       myPringMatrix(matrix,list,rowlen,len,rowstart,lenstart);
        return list;
    }

    public void myPringMatrix(int [][] matrix,ArrayList<Integer> list,int rowlen,int len,int rowstart,int lenstart){

        for (int i = lenstart; i <= len; i++) {
            list.add(matrix[rowstart][i]);
        }
        rowstart+=1;
        if(rowstart>rowlen) return;
        for (int i = rowstart; i <= rowlen; i++) {
            list.add(matrix[i][len]);
        }
        len-=1;
        if(len<0) return;
        for (int i = len; i >=lenstart ; i--) {
            list.add(matrix[rowlen][i]);
        }
        rowlen-=1;
        if(rowlen<0) return;
        for (int i = rowlen; i >=rowstart ; i--) {
            list.add(matrix[i][lenstart]);
        }
        lenstart+=1;
        if(lenstart>len) return;
        if(list.size()==matrix.length*matrix[0].length)
            return;
        else myPringMatrix(matrix,list,rowlen,len,rowstart,lenstart);
    }
}
