package GitProject;

public class No264 {
    public static void main(String[] args) {
        int[] ints = nthUglyNumber(10);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public static int[] nthUglyNumber(int n) {
        int[] dp = new int [n];
        dp[0] = 1;
        int mul2 = 0, mul3 = 0, mul5 = 0;
        for(int i = 1; i < n; i++){
            dp[i] = Math.min(Math.min(dp[mul2] * 2, dp[mul3] * 3),dp[mul5] * 5);
            if(dp[i] == dp[mul2] * 2){
                mul2++;
                continue;
            }
            if(dp[i] == dp[mul3] * 3){
                mul3++;
                continue;
            }
            if(dp[i] == dp[mul5] * 5){
                mul5++;
                continue;
            }
        }
        return dp;
    }
}
