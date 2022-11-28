package GitProject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15 {
    public static void main(String[] args) {
        No15 no15 = new No15();
        List<List<Integer>> lists = no15.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists.get(0));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < length - 2; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            for(int left = i + 1, right = length - 1; left < right;){
                if(left > i + 1 && nums[left] == nums[left - 1]){
                    left++;
                    continue;
                }
                if(right < length - 1 && nums[right] == nums [right + 1]){
                    right--;
                    continue;
                }
                int sum = nums[left] + nums[right];
                if(sum > -nums[i]){
                    right--;
                }else if(sum < -nums[i]){
                    left++;
                }else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}
