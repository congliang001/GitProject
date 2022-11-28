package GitProject;

public class No53 {
    public static void main(String[] args) {
        No53 no53 = new No53();
        int[] ints = {5,4,-1,7,8};
        int i = no53.maxSubArray(ints);
        System.out.println(i);
    }
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] sum  = new int[n];
        sum[0] = nums[0];
        for(int i = 1; i < n; i++){
            sum[i] = sum[i - 1] + nums[i];
        }
        int min = sum[0];
        int max = sum[0];
        for(int i = 0; i < n; i++){
            min = Math.min(sum[i], min);
            max = Math.max(max, sum[i] - min);
        }
        return max;
    }
}
