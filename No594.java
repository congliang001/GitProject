package GitProject;

import java.util.Arrays;

public class No594 {
    public static void main(String[] args) {

    }

    public static int findLHS(int[] nums) {
        Arrays.sort(nums);
        int left = 0, right = 0;
        int result = 0;
        for(; right < nums.length; right++){
            if(nums[right] - nums[left] > 1 && right > left){
                left++;
            }
            if(nums[right] - nums[left] == 1){
                result = Math.max(result, right - left + 1);
            }
        }
        return  result;
    }
}
