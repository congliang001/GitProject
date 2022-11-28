package GitProject;

public class No114 {
    public static void main(String[] args) {
        No114 no114 = new No114();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println(root);
        no114.flatten(root);
        System.out.println(root);

    }

    public void flatten(TreeNode root) {
        traverse(root);
    }

    public TreeNode traverse(TreeNode root){
        if(root == null){
            return null;
        }
        TreeNode left = traverse(root.left);
        TreeNode right = traverse(root.right);
        TreeNode dummy = root;
        dummy.left = null;
        dummy.right = left;
        while(dummy.right != null){
            dummy = dummy.right;
        }
        dummy.right = right;
        return root;
    }
}
