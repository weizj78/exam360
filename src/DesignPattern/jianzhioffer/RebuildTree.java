package DesignPattern.jianzhioffer;



public class RebuildTree {
    public static void main(String[] args) {
        int []pre = {1,2,4,7,3,5,6,8};
        int []in = {4,7,2,1,5,3,8,6};
        RebuildTree re = new RebuildTree();
        re.reverseTree(re.reConstructBinaryTree(pre,in));
    }


    public void reverseTree(TreeNode node){
        if(node==null) return;
        reverseTree(node.left);
        System.out.println(node.val);
        reverseTree(node.right);
    }

    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        TreeNode root = new TreeNode(pre[0]);
        int index = binarySearch(in,pre[0]);
        return reBuildTree(pre,in,0,0,pre.length-1);
    }

    public int binarySearch(int []arr,int target){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target)
                return i;
        }
        return 0;
    }


    public TreeNode reBuildTree(int []pre,int []in,int start,int left,int right){


        if(left>right) return null;

        TreeNode node = new TreeNode(pre[start]);

        int index = binarySearch(in,pre[start]);
        System.out.println(start+" "+left+" "+right+" "+index);
        node.left = reBuildTree(pre,in,start+1,left,index-1);
        node.right = reBuildTree(pre,in,start+(index-left+1),index+1,right);
        return node;
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
