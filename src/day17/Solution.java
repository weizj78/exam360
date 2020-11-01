package day17;


import DesignPattern.jianzhioffer.ListNode;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

public class Solution {

    public boolean isCon(int[] numbers) {
        int[] arr = new int[14];
        int maxvalue = 0;
        int minvalue = 14;
        for (int i = 0; i < numbers.length; i++) {
            arr[numbers[i]] += 1;
            if (arr[numbers[i]] >= 2 && numbers[i] != 0) return false;
            if (numbers[i] == 0) continue;
            if (numbers[i] > maxvalue) maxvalue = numbers[i];
            if (numbers[i] < minvalue) minvalue = numbers[i];
        }
        if (maxvalue - minvalue <= 4) return true;
        else return false;

    }


    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0) return false;

        int count = 0; //王牌的个数
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) count++;
            else if (i >= 1) {
                if (numbers[i - 1] != 0) {
                    if (numbers[i] - numbers[i - 1] == 0) return false;
                    else if (numbers[i] - numbers[i - 1] > 1) count -= (numbers[i] - numbers[i - 1] - 1);
                }
            }
        }

        return count >= 0 ? true : false;
    }


    public int[] multiply(int[] A) {

        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        for (int i = 1; i < len; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int tmp = 1;
        for (int i = len - 2; i >= 0; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;
    }

    //    public boolean match(char[] str, char[] pattern) {
//        int i = 0;
//        int j = 0;
//
//        while ()
//    }
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode p2 = head;
        ListNode p1 = pHead;
        while (p1 != null) {
            if (p1.next != null && p1.val == p1.next.val) {
                while (p1.next != null && p1.val == p1.next.val) p1 = p1.next;
                p2.next = p1.next;
                p1 = p1.next;
            } else {
                p2 = p1;
                p1 = p1.next;
            }
        }
        return head.next;
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //当前节点是根节点
        if (pNode.next == null) {
            TreeLinkNode right = pNode;
            while (right.left != null) right = right.left;
            return right;
        }
        //当前节点是父节点的左节点
        if (pNode.next.left == pNode) {
            TreeLinkNode right = pNode;
            if (right != null) {
                while (right.left != null) right = right.left;
                return right;
            }


            return pNode.next;
        }

        //当前节点是父节点的右子节点
        if (pNode.next.right == pNode) {
            TreeLinkNode right = pNode.right;
            if (right != null) {
                while (right.left != null) right = right.left;
                return right;
            } else {
                TreeLinkNode pNext = pNode.next;
                while (pNext.next != null && pNext.next.right == pNext) {
                    pNext = pNext.next;
                }
                return pNext.next;
            }
        }

        return null;

    }

    boolean isSymmetrical(TreeNode pRoot) {

        if (pRoot == null) return true;
        return isSame(pRoot.left, pRoot.right);
    }

    boolean isSame(TreeNode left, TreeNode right) {
        if (left == null && right != null) return false;
        if (left != null && right == null) return false;
        if (left == null && right == null) return true;
        if (left.val != right.val) return false;

        return isSame(left.left, right.right) && isSame(left.right, right.left);
    }





    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(pRoot);
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<ArrayList<Integer>> resList = new ArrayList<>();
        if (pRoot == null) return resList;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            while (!stack1.isEmpty()) {
                TreeNode pop = stack1.pop();
                list.add(pop.val);
                System.out.println(pop.val);
                if (pop.left != null)
                    stack2.push(pop.left);
                if (pop.right != null)
                    stack2.push(pop.right);
            }
            resList.add(list);
            ArrayList<Integer> list2 = new ArrayList<>();
            while (!stack2.isEmpty()) {
                TreeNode pop = stack2.pop();
                list2.add(pop.val);
                System.out.println(pop.val);
                if (pop.right != null)
                    stack1.add(pop.right);
                if (pop.left != null)
                    stack1.add(pop.left);
            }
            if (list2.size() > 0) resList.add(list2);
        }
        return resList;
    }


    //    String Serialize(TreeNode root) {
//
//    }
//    TreeNode Deserialize(String str) {
//
//    }
    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode[] res = new TreeNode[1];
        int[] a = new int[1];
        a[0] = k;
        findKthNode(pRoot, a, res);
        return res[0];
    }

    void findKthNode(TreeNode root, int[] a, TreeNode[] res) {
        if (root == null || a[0] == 0) return;
        findKthNode(root.left, a, res);
        if (a[0] == 0) return;
        a[0]--;
        res[0] = a[0] == 0 ? root : null;
        findKthNode(root.right, a, res);
    }

    @Test
    public void test01() {
        Insert(5);
        boolean[] bo = new boolean[1];
        System.out.println(bo[0]);
    }

    TreeSet<Integer> set = new TreeSet<>();

    public void Insert(Integer num) {
        set.add(num);
    }

    public Double GetMedian() {
        int size = set.size();
        if (size == 1)
            return set.stream().iterator().next() * 1.0;
        Object[] res = set.toArray();
        if (size % 2 != 0)
            return (Integer) res[((size - 1) / 2)] / 1.0;
        else return ((Integer) res[(size - 1) / 2] + (Integer) res[(size - 1) / 2 + 1]) / 2.0;

    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {

        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while (p1 != null && p1.next != null) {
            p1 = p1.next.next;
            p2 = p2.next;
            if (p1 == p2) {
                break;
            }
        }
        if (p1 == null || p1.next == null) return null;
        p1 = pHead;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    @Test
    public void test03() {
        char[] matrix = {'A', 'B', 'C', 'E', 'S', 'F', 'C', 'S', 'A', 'D', 'E', 'E'};
        char[] str = {'A', 'B', 'C', 'C', 'E', 'D'};
        System.out.println(hasPath(matrix, 3, 4, str));
    }


    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[] flag = new boolean[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isContains(matrix, 0, i, j, rows, cols, str, flag))
                    return true;
            }
        }
        return false;
    }

    /**
     * @param matrix
     * @param index
     * @param x
     * @param y
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean isContains(char[] matrix, int index, int x, int y, int rows, int cols, char[] str, boolean[] flag) {
        int curindex = x * cols + y;
        System.out.println(x + " " + y);
        if (index >= str.length) return true;
        if (x <= -1 || x >= rows || y <= -1 || y >= cols || str[index] != matrix[curindex] || flag[curindex] == true)
            return false;
        flag[curindex] = true;
        boolean upRes = isContains(matrix, index + 1, x + 1, y, rows, cols, str, flag);
        if (upRes) return true;
        boolean downRes = isContains(matrix, index + 1, x - 1, y, rows, cols, str, flag);
        if (downRes) return true;
        boolean leftRes = isContains(matrix, index + 1, x, y - 1, rows, cols, str, flag);
        if (leftRes) return true;
        boolean rightRes = isContains(matrix, index + 1, x, y + 1, rows, cols, str, flag);
        if (rightRes) return true;
        flag[curindex] = false;
        return false;
    }


    public int LastRemaining_Solution(int n, int m) {
        if (n == 0 || m == 0) return -1;
        int s = 0;
        for (int i = 2; i <= n; i++) {
            s = (s + m) % i;
        }
        return s;
    }


    @Test
    public void test04() {
        System.out.println(movingCount(5, 10, 10));
    }

    public Integer getValues(int x, int y) {
        String sx = Integer.toString(x);
        String sy = Integer.toString(y);
        int res = 0;
        for (int i = 0; i < sx.length(); i++) {
            res += sx.charAt(i) - '0';
        }
        for (int i = 0; i < sy.length(); i++) {
            res += sy.charAt(i) - '0';
        }
        return res;
    }

    public int movingCount(int threshold, int rows, int cols) {
        int[][] arr = new int[rows][cols];
        return comeIn(threshold, rows, cols, 0, 0, arr);
    }

    public int comeIn(int threshold, int rows, int cols, int x, int y, int[][] flags) {
        if (x <= -1 || x >= rows || y <= -1 || y >= cols || getValues(x, y) > threshold || flags[x][y] == 1) return 0;
        System.out.println(x + " " + y + " " + getValues(x, y));
        int res = 1;
        flags[x][y] = 1;
        res += comeIn(threshold, rows, cols, x + 1, y, flags);
        res += comeIn(threshold, rows, cols, x - 1, y, flags);
        res += comeIn(threshold, rows, cols, x, y + 1, flags);
        res += comeIn(threshold, rows, cols, x, y - 1, flags);
        return res;
    }

    @Test
    public void test05() {
        char[] str = {'g', 'o', 'o', 'g', 'l', 'e'};
        for (int i = 0; i < str.length; i++) {
            Insert(str[i]);
            System.out.println(FirstAppearingOnce());
        }
    }

    HashMap<Character, Integer> map = new HashMap<>();
    LinkedList<Character> list = new LinkedList<>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            System.out.println(ch + " " + map.get(ch));
            map.put(ch, map.get(ch) + 1);
        } else map.put(ch, 1);
        list.add(ch);
    }

    public char FirstAppearingOnce() {
        while (!list.isEmpty()) {
            if (map.get(list.getFirst()) == 1) {
                System.out.println(map.get(list.getFirst()));
                return list.getFirst();
            } else {
                list.removeFirst();
            }
        }
        return '#';
    }

    String Serialize(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        if(root!=null)
            list.add(root);
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            TreeNode temp = list.getFirst();
            list.removeFirst();
            if (temp != null) {
                if(temp==root)
                builder.append(Integer.toString(temp.val));
                else builder.append(","+Integer.toString(temp.val));
               // if(temp.left==null&&temp.right==null) continue;
                list.add(temp.left);
                list.add(temp.right);
            }else {
                builder.append(",#");
            }
        }
        return builder.toString();
    }

    TreeNode Deserialize(String str) {
        if(str.length() == 0) return null;
        String[] split = str.split(",");
        System.out.println(split.length);
        LinkedList<TreeNode> list = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        list.add(root);
        int index = 1;
        while (index<split.length&&!list.isEmpty()){
            TreeNode first = list.getFirst();
            list.removeFirst();
            first.left = split[index].charAt(0) =='#'?null:new TreeNode(Integer.parseInt(split[index]));
            if(first.left!=null) list.add(first.left);
            index++;
            if(index>=split.length) break;
            first.right = split[index].charAt(0) =='#'?null:new TreeNode(Integer.parseInt(split[index]));
            if(first.right!=null) list.add(first.right);
         }
        return root;
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);
        TreeNode deserialize = Deserialize(Serialize(root));
        System.out.println(Serialize(root));
    }


    public boolean isNumeric(char[] str) {

        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);

    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

