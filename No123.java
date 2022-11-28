package GitProject;

public class No123 {
    public static void main(String[] args) {
        No123 no123 = new No123();
        int[] prices = {3,3,5,0,0,3,1,4};
        int i = no123.maxProfit(prices);
        System.out.println(i);
    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][3][2];
//        for(int i = 0; i < n; i++){
//            dp[i][0][0] = 0;
//            dp[i][0][1] = -prices[i];
//        }
        for(int i = 0; i < n; i++){
            for(int j = 1; j < 3; j++){
                if(i - 1 == -1){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                }else{
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                }
            }
        }
        System.out.println(dp[0][0][0]);
        System.out.println(dp[0][0][1]);
        return dp[n - 1][2][0];
    }
}
