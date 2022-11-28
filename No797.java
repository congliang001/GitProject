package GitProject;

import java.util.ArrayList;
import java.util.List;

public class No797 {
    static List<List<Integer>> ans = new ArrayList<>();
    public static void main(String[] args) {
        No797 no797 = new No797();
        int[][] g = {{1,2}, {3},{3},{}};
        no797.allPathsSourceTarget(g);
        System.out.println(ans);
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> list = new ArrayList<> ();
        builder(graph,0,list);
        return ans;
    }

    public void builder(int[][] graph, int start, List<Integer> list){
        list.add(start);
        int end = graph.length - 1;
        if(start == end){
            System.out.println(list);
            ans.add(list);
//            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for(int i : graph[start]){
            builder(graph,i,list);
        }
        list.remove(list.size() - 1);
    }
}
