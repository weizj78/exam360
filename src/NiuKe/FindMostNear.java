package NiuKe;

public class FindMostNear {
    public static void main(String[] args) {

    }
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        int []a = new int[1];
        reverseTree(root,o1,o2,a);
        return a[0];
    }
    public int reverseTree(TreeNode root,int o1,int o2,int []a){
        if(root==null) return 0;
        int sum = reverseTree(root.left,o1,o2,a)+reverseTree(root.right,o1,o2,a);
        if(root.val==o1||root.val==o2) sum+=1;
        if(sum==2) {
            a[0]=root.val;
            sum = -1;
        }
        return sum;
    }
}
