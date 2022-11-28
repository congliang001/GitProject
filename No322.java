package GitProject;

import java.util.Arrays;

public class No322 {
    int[] memo;

    public static void main(String[] args) {
        No322 no322 = new No322();
        int[] coins = {1,2,5};
        int i = no322.coinChange(coins, 11);
        System.out.println(i);
    }
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -10);
        return dp(coins, amount);
    }

    public int dp(int[] coins, int amount){
        if(amount == 0){
            return 0;
        }
        if(amount < 0){
            return -1;
        }
        if(memo[amount] != -10){
            return memo[amount];
        }
        int ans = Integer.MAX_VALUE;
        for(int coin : coins){
//            if(amount >= coin){

                    int i = dp(coins, amount - coin);
                    if(i == -1){
                        continue;
                    }
                    ans = Math.min(ans, i + 1);
//            }
        }
        memo[amount] = ans == Integer.MAX_VALUE ? -1 : ans;
        return memo[amount];
    }
}
