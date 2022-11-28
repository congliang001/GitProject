package GitProject;

public class No523 {
    public static void main(String[] args) {
        No523 no523 = new No523();
        int[] nums = {5, 0, 0, 0};
        boolean b = no523.checkSubarraySum(nums, 6);
        System.out.println(b);
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] preSum = new int [n + 1];
        for(int i = 1; i <= n; i++){
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        for(int i = 2; i <= n; i++){
            for(int j = 0; j <= i - 2; j++){
                if((preSum[i] - preSum[j]) >= k && (preSum[i] - preSum[j]) % k == 0){
                    System.out.println(i);
                    System.out.println(j);
                    return true;
                }
            }
        }
        return false;
    }
}
