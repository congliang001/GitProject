package GitProject;

public class No75 {
    public static void main(String[] args) {
        int[] array ={2,0,1};
        No75 no75 = new No75();
        no75.sortColors1(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public void sortColors(int[] nums) {
        //双指针 一次遍历 换1 没问题  换0 要注意 如果0 在前面 说明1 换到后面了 要再换回来
        int index0 = 0, index1 = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                swap(nums,index0,i);
                if(index0 < index1){
                    swap(nums,index1,i);
                }
                index0++;
                index1++;
            }else{
                if(nums[i] == 1){
                    swap(nums,index1,i);
                    index1++;
                }
            }
        }
    }

    public void sortColors1(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p2 = n - 1;
        for(int i = 0; i <= p2; i++){
            while(i <= p2 && nums[i] == 2){
                swap(nums, i, p2);
                p2--;
            }
            if(nums[i] == 0){
                swap(nums, i, p0);
                p0++;
            }
        }

    }

    public void swap (int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
