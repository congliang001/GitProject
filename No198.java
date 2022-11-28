package GitProject;

import java.util.Arrays;

public class No198 {
    int[] memo;

    public static void main(String[] args) {
        No198 no198 = new No198();
        int[] ints = {1,2,3,1};
        int rob = no198.rob(ints);
        System.out.println(rob);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    public int dp(int[] nums, int index){
        if(index >= nums.length){
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        int ans = Math.max(nums[index] + dp(nums, index + 2), dp(nums, index + 1));
        memo[index] = ans;
        return ans;
    }
}
