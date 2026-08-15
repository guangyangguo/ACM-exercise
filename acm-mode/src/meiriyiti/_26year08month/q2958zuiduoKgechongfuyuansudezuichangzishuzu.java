package meiriyiti._26year08month;

import java.util.*;

public class q2958zuiduoKgechongfuyuansudezuichangzishuzu {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,1,2,3,1,2};
        System.out.println(maxSubarrayLength(nums1, 2)); // 输出: 6
        int[] num2 = {1,2,1,2,1,2,1,2};
        System.out.println(maxSubarrayLength(num2, 1)); // 输出: 2
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        int res = 0;
        Map<Integer,Integer> mp = new HashMap<>();
        int left = 0;
        for(int i = 0;i < nums.length;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0) + 1);
            while(mp.get(nums[i]) > k){
                mp.put(nums[left],mp.get(nums[left]) - 1);
                left++;
            }
            res = Math.max(res,i - left + 1);
        }
        return res;
    }
}
