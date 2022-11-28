package GitProject;

import java.util.Arrays;

public class No354 {
    public static void main(String[] args) {
        No354 no354 = new No354();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        no354.maxEnvelopes(envelopes);
        for(int[] ints : envelopes){
            for(int i : ints){
                System.out.println(i);
                System.out.println(",");
            }
        }
    }

    public void maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];});
    }
}
