package GitProject;

public class No104 {
    int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        No104 no104 = new No104();
        System.out.println(no104.maxDepth(root));
    }

    public int maxDepth(TreeNode root) {
        traverse(root);
        return ans;
    }

    public int traverse(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int depth = Math.max(left, right) + 1;
        ans = Math.max(ans, depth);
        return depth;
    }
}
