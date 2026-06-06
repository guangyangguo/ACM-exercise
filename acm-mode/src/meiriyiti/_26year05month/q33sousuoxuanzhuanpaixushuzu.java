package meiriyiti._26year05month;

public class q33sousuoxuanzhuanpaixushuzu {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums,0));
    }

    public static int search(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right) / 2;
            if(nums[mid] == target){
                return mid;
                //左半边有序
            }else if(nums[left] <= nums[mid]){
                //target在左半边
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                    //target在右半边
                }else{
                    left = mid + 1;
                }
                //右半边有序
            }else{
                //target在右半边
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                    //target在左半边
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
