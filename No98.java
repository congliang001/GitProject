package GitProject;

public class No98 {

//    public static void main(String[] args) {
//        No98 no98 = new No98();
//        TreeNode root = new TreeNode(2);
//        root.left = new TreeNode(1);
//        TreeNode right = new TreeNode(4, new TreeNode(3), new TreeNode(6));
//        root.right = right;
//        boolean validBST = no98.isValidBST(root);
//        System.out.println(validBST);
//    }
//
//
//    public boolean isValidBST(TreeNode root) {
//        return traverse(root,null,null);
//    }
//
//    public boolean traverse(TreeNode root, TreeNode min, TreeNode max){
//        if(root == null){
//            return true;
//        }
//        if(min != null && root.val <= min.val){
//            return false;
//        }
//        if(max != null && root.val >= max.val){
//            return false;
//        }
//        return traverse(root.left, min, root) && traverse(root.right,root,max);
//    }
}
//class TreeNode {
//      int val;
//      TreeNode left;
//      TreeNode right;
//      TreeNode(int x) { val = x; }
//      TreeNode(int x, TreeNode left, TreeNode right){
//          val = x;
//          this.left = left;
//          this.right = right;
//      }
//}