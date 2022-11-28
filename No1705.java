package GitProject;

import java.util.PriorityQueue;

public class No1705 {
    public static void main(String[] args) {
        No1705 no1705 = new No1705();
        int[] apples = {1,2,3,5,2};
        int[] days = {3,2,1,4,2};
        int i = no1705.eatenApples(apples, days);
        System.out.println(i);
    }
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        int day = 0, ans = 0;
        while(day < n || !pq.isEmpty()){
            if(day < n && apples[day] > 0){
                pq.add(new int[] {apples[day], day + days[day] - 1});
            }
            while(!pq.isEmpty() && pq.peek()[1] < day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                ans++;
                // int cur = pq.peek()[0];
                if(--pq.peek()[0] == 0){
                    pq.poll();
                }
            }
            day++;
        }
        return ans ;
    }

}
