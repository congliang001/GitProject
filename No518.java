package GitProject;

public class No518 {
    public static void main(String[] args) {
        int change = change(5, new int[]{1, 2, 5});
        System.out.println(change);
    }
    //不考虑顺序
    public static int change(int amount, int[] coins) {
        int[] dp = new int [amount + 1];
        dp[0] = 1;
        for(int i = 0; i < coins.length ; i++){
            for(int j = 0; j < dp.length; j++){
                if(j >= coins[i]){
                    dp[j] += dp[j-coins[i]];
                }
            }
        }
        return dp[dp.length - 1];
    }

    //考虑顺序
    public static int change2(int amount, int[] coins) {
        int[] dp = new int [amount + 1];
        dp[0] = 1;
        for(int i = 0; i < dp.length ; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] += dp[i-coins[j]];
                }
            }
        }
        return dp[dp.length - 1];
    }
}
