package GitProject;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No95 {

    public static void main(String[] args) {
        No95 no95 = new No95();
        List<TreeNode> treeNodes = no95.generateTrees(3);
        for (TreeNode t  :treeNodes){
            System.out.println(t);
        }
    }

    public List<TreeNode> generateTrees(int n) {
        return traverse(1,n);
    }

    public List<TreeNode> traverse(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if(start > end){
            list.add(null);
            return list;
        }
        for(int i = start; i <= end; i++){
            List<TreeNode> left = traverse(start, i - 1);
            List<TreeNode> right = traverse(i + 1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}


//class TreeNode {
//      final String NULL = "#";
//      final String SEP = ",";
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode() {}
//      TreeNode(int val) { this.val = val; }
//      TreeNode(int val, TreeNode left, TreeNode right) {
//          this.val = val;
//          this.left = left;
//          this.right = right;
//      }
//
//    @Override
//    public String toString() {
//        Deque<TreeNode> dq = new LinkedList<>();
//        dq.offer(this);
//        StringBuilder builder = new StringBuilder();
//        while(!dq.isEmpty()){
//            int size = dq.size();
//            for(int i = 0; i < size; i++){
//                TreeNode cur = dq.poll();
//                if(cur == null){
//                    builder.append(NULL).append(SEP);
//                    continue;
//                }
//                builder.append(cur.val).append(SEP);
//                if(cur.left != null){
//                    dq.offer(cur.left);
//                }
//                if(cur.right != null){
//                    dq.offer(cur.right);
//                }
//            }
//        }
//        return  builder.toString();
//    }
//}