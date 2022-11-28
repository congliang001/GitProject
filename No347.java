package GitProject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class No347 {
    Map<Integer, Integer> kToF = new HashMap<>();

    public static void main(String[] args) {
        //[1,1,1,2,2,3]
        //2
        No347 no347 = new No347();
        int[] ints = no347.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for(int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        for(int num : nums){
            kToF.put(num, kToF.getOrDefault(num, 0) + 1);
        }
        int[] array = new int[kToF.size()];
        int index = 0;
        for(int i : kToF.keySet()){
            array[index++] = i;
        }
        shuffle(array);
        int left = 0;
        int right = array.length - 1;
        int target = array.length - k;
        while(left <= right){
            int cur = baseQuickSort(array, left, right);
            if(cur == target){
                break;
            }else if(cur < target){
                left = cur + 1;
            }else if(cur > target){
                right = cur - 1;
            }
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
            ans[i] = array[array.length - 1 - i];
        }
        return ans;


    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void shuffle(int[] nums){
        Random random = new Random();
        int n = nums.length;
        for(int i = 0; i < n; i++){
            swap(nums, i, i + random.nextInt(n - i));
        }
    }

    public int baseQuickSort(int[] nums, int start, int end){
        int left = start;
        int pivot = kToF.get(nums[left]);
        while(start < end){
            while(start < end && kToF.get(nums[end]) >= pivot){
                end--;
            }
            while(start < end && kToF.get(nums[start]) <= pivot){
                start++;
            }
            swap(nums, start, end);
        }
        swap(nums, start, left);
        return start;
    }
}
