package GitProject;

public class No31 {
    public static void main(String[] args) {
        No31 no31 = new No31();
        int[] ints = {2, 3, 1};
        no31.nextPermutation(ints);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int left;
        int right;
        for(left = length - 2; left >= 0 ; left--){
            if(nums[left] < nums[left + 1]){
                break;
            }
        }
        if(left >= 0){
            for(right = length - 1; right > left; right--){
                if(nums[left] < nums[right]){
                    break;
                }
            }
            swap(nums,left,right);
        }

        for(int i = left + 1, j = length - 1; i < j ; i++ , j--){
            swap(nums,i,j);
        }
    }

    public void swap (int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
