package GitProject;

import java.util.*;

public class No297 {

    final String SEP = ",";
    final String NULL = "#";
    public static void main(String[] args) {
        No297 no297 = new No297();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.right.left = new TreeNode(4);
//        root.right.right = new TreeNode(5);
        String serialize = no297.serialize(root);
        System.out.println(serialize);
        TreeNode deserialize = no297.deserialize(serialize);
        System.out.println(deserialize);
    }


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        return serialize(root, builder).toString();
    }

    public StringBuilder serialize(TreeNode root, StringBuilder builder){
        if(root == null){
            builder.append(NULL).append(SEP);
            return builder;
        }
        builder.append(root.val).append(SEP);
        StringBuilder left = serialize(root.left, builder);
        StringBuilder right = serialize(root.right,builder);
        return builder;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new ArrayDeque<>();
        for(String s : data.split(SEP)){
            dq.offer(s);
        }
        return deserialize(dq);
    }

    public TreeNode deserialize(Deque<String> dq) {
        String s = dq.poll();
        if(s.equals(NULL)){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(dq);
        root.right = deserialize(dq);
        return root;
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
//      TreeNode(int x) { val = x; }

      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

    @Override
    public String toString() {
          if(this == null){
              return "null";
          }
          List<List<Integer>> list = new ArrayList<>();
          Deque<TreeNode> dq = new LinkedList<>();
          dq.offer(this);
          while(!dq.isEmpty()){
              int size = dq.size();
              List<Integer> l = new ArrayList<>();
              for(int i = 0; i < size; i++){
                  TreeNode cur = dq.poll();
                  if(cur == null){
                      l.add(null);
                      continue;
                  }
                  l.add(cur.val);
                  dq.offer(cur.left);
                  dq.offer(cur.right);
              }
              list.add(l);
          }
          list.remove(list.size() - 1);
          return list.toString();
    }
}