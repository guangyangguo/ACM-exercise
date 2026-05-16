package meiriyiti;

public class q154 {

    public static void main(String[] args) {
        int[] nums = {1,3,5};
        System.out.println(findanswer(nums));
    }


    /*
    * 这个代码同样可解153题
    * */
    public static int findanswer(int[] nums){
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < nums[right]) {
                // 最小值在 [left, mid]
                right = mid;
            } else if (nums[mid] > nums[right]) {
                // 最小值在 [mid+1, right]
                left = mid + 1;
            } else {
                // nums[mid] == nums[right]，只能缩小右边界
                right--;
            }
        }
        return nums[left];
    }
}
