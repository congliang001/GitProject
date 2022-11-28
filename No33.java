package GitProject;

public class No33 {
    public static void main(String[] args) {
        int search = new No33().search(new int[]{3,1}, 1);
        System.out.println(search);
    }


    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = (left + right) / 2;;
        while(left <= right){
            if(target == nums[mid]){
                return mid;
            }else{
                if(nums[left] <= nums[mid]){ //左边升序
                    if(target < nums[mid] && target >= nums[left]){
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }else{  //右边升序
                    if(target > nums[mid] && target <= nums[right]){
                        left = mid + 1;
                    }else{
                        right = mid - 1;
                    }
                }
            }
            mid = (left + right) / 2;
        }
        return -1;
    }
}
