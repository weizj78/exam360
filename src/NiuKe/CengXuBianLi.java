package NiuKe;

import java.util.ArrayList;
import java.util.List;

public class CengXuBianLi {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        levelReverse(root,1,list);
        return list;
    }

    public void levelReverse(TreeNode root,int level,ArrayList<ArrayList<Integer>> list){
       if(root==null) return;
        if(list.size()<level){
            list.add(new ArrayList<Integer>());
        }
        List<Integer> levelList = list.get(level-1);
        levelList.add(root.val);
        levelReverse(root.left,level+1,list);
        levelReverse(root.right,level+1,list);
    }
}
