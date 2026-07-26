package meiriyiti._26year07month;

import java.util.Arrays;

public class q628 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(maximumProduct(nums));
    }

    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        //数组全为正或者全为负都是 nums[len - 1] * nums[len - 2] * nums[len - 3]
        //数组中有负数，只能是两负一正 nums[0] * nums[1] * nums[len - 1]
        return Math.max(nums[len - 1] * nums[len - 2] * nums[len - 3], nums[0] * nums[1] * nums[len - 1]);
    }
}
