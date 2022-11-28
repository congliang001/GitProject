package GitProject;

import java.util.Arrays;

public class No406 {
    public static void main(String[] args) {
        No406 no406 = new No406();
        int[][] people ={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        int[][] ints = no406.reconstructQueue(people);
        for(int i = 0; i < ints.length; i++){
            System.out.print("[");
            System.out.print(ints[i][0]);
            System.out.print(",");
            System.out.print(ints[i][1]);
            System.out.print("]");
        }

    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return b[1] - a[1];
            }else{
                return a[0] - b[0];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][2];
        for(int i = 0; i < n; i++){
            int space = people[i][1] + 1;
            for(int j = 0; j < n; j++){
                if(ans[j] == null){
                    space--;
                }
                if(space == 0){
                    ans[j] = people[i];
                    break;
                }
            }
        }
        return ans;
    }
}
