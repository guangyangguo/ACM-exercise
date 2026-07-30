package meiriyiti._26year07month;

import java.util.Arrays;

public class q628sangeshudezuidachengji {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        System.out.println(maximumProduct(nums1)); // 输出 6
        int[] nums2 = {-1,-2,-3};
        System.out.println(maximumProduct(nums2)); // 输出 -6
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //数组全为正或全为负都是 nums[len - 1] * nums[len - 2] * nums[len - 3]
        //如果数组中存在负数只能是两负一正 nums[0] * nums[1] * nums[len - 1]
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }
}
