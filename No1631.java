package GitProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No1631 {
    public static void main(String[] args) {
        No1631 no1631 = new No1631();
        int[][] a = {{1,2,2}, {3,8,2}, {5,3,5}};
        int i = no1631.minimumEffortPath(a);
        System.out.println(i);
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] minEffort = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        }
        minEffort[0][0] = 0;
        PriorityQueue<State> pq = new PriorityQueue<> ((a, b) -> {return a.effortFromStart - b.effortFromStart;});
        pq.offer(new State(0,0,0));
        while(!pq.isEmpty()){
            State cur = pq.poll();
            int i = cur.i;
            int j = cur.j;
            int effort = cur.effortFromStart;
            if(i == n - 1 && j == m - 1){
                return effort;
            }
            if(effort > minEffort[i][j]){
                continue;
            }
            List<int[]> neighbors = buildGraph(i, j, heights);
            for(int[] ints : neighbors){
                int nextI = ints[0];
                int nextJ = ints[1];
                int weight = Math.max(minEffort[i][j], Math.abs(heights[i][j] - heights[nextI][nextJ]));
                if(minEffort[nextI][nextJ] > weight){
                    minEffort[nextI][nextJ] = weight;
                    pq.offer(new State(nextI, nextJ, weight));
                }
            }
        }

        return minEffort[n - 1][m - 1];

    }


    public List<int[]> buildGraph(int i, int j, int[][] heights){
        int n = heights.length;
        int m = heights[0].length;

        List<int[]> list = new ArrayList<>();
        int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int k = 0; k < move.length; k++){
            int newI = i + move[k][0];
            int newJ = j + move[k][1];
            if(newI < 0 || newI >= n || newJ < 0 || newJ >= m){
                continue;
            }
            list.add(new int[] {newI, newJ});
        }
        return list;
    }
}
class State{
    int i;
    int j;
    int effortFromStart;

    public State(int i, int j, int effortFromStart){
        this.i = i;
        this.j = j;
        this.effortFromStart = effortFromStart;
    }
}