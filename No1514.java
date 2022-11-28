package GitProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//public class No1514 {
//
//    public static void main(String[] args) {
//        No1514 no1514 = new No1514();
//        double v = no1514.maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2);
//        System.out.println(v);
//    }
//
//
//    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
//        List<double[]>[] graph = builderGraph(edges,succProb, n);
//        double[] probability = new double[n];
//        Arrays.fill(probability, -1);
//        probability[start] = 1;
//        PriorityQueue<State> pq = new PriorityQueue<> ((a, b) -> {return Double.compare(b.probability, a.probability);});
//        pq.offer(new State(start, 1));
//        while(!pq.isEmpty()){
//            State cur = pq.poll();
//            int curTo = cur.to;
//            double curProbability = cur.probability;
//            if(curTo == end){
//                return curProbability;
//            }
//            if(probability[curTo] > curProbability){
//                continue;
//            }
//            for(double[] ints : graph[curTo]){
//                int nextTo = (int)ints[0];
//                double nextProability = ints[1];
//                double probToNextNode = probability[curTo] * nextProability;
//                if(probability[nextTo] < probToNextNode){
//                    probability[nextTo] = probToNextNode;
//                    pq.offer(new State (nextTo, probToNextNode));
//                }
//            }
//        }
//        return 0.0;
//
//    }
//
//    public List<double[]>[] builderGraph(int[][] edges, double[] succProb, int n){
//        List<double[]>[] graph = new ArrayList[n];
////        Arrays.fill(graph, new ArrayList<double[]> ());
//        for(int i = 0; i < graph.length; i++){
//            graph[i] = new ArrayList<double[]>();
//        }
//        for(int i = 0; i < edges.length; i++){
//            int from = edges[i][0];
//            int to = edges[i][1];
//            double probability = succProb[i];
//            graph[from].add(new double[] {(double)to, probability});
//            graph[to].add(new double[] {(double)from, probability});
//        }
//        return graph;
//    }
//}

//class State{
//    int to;
//    double probability;
//
//    public State(int to, double probability){
//        this.to = to;
//        this.probability = probability;
//    }
//}