package meiriyiti._26year05month;

import java.util.Arrays;

public class q1752jianchashuzushifoujingpaixuhelunzhuandedao {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        int[] nums1 = {2,1,3,4};
        System.out.println(check(nums1));
        System.out.println(check1(nums));
    }


    /*
    * 算是比较巧的解法：核心思想是有序数组旋转后，最多只会出现一次nums[i] > nums[i + 1]的情况(nums[n-1]和nums[0]也要比较)
    * 如果出现两次以上，说明不是旋转有序数组。
    * */
    public static boolean check(int[] nums){
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return true;
    }



    /*
    * 暴力解法，模拟所有可能出现的旋转情况，比较每种情况是否与排序后的数组相同。
    * */
    public static boolean check1(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted); // 得到正确的有序数组

        // 尝试旋转 i 次（i从0到n-1）
        for (int i = 0; i < n; i++) {
            boolean match = true;
            for (int j = 0; j < n; j++) {
                // 旋转 i 次后的元素位置
                if (nums[(j + i) % n] != sorted[j]) {
                    match = false;
                    break;
                }
            }
            if (match){
                return true;
            }
        }
        return false;
    }

}
