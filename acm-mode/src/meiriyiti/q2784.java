package meiriyiti;

import java.util.Arrays;

public class q2784 {

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        int[] nums1 = {1,3,3,2};
        System.out.println(findanswer(nums1));
    }

    /*
    * O(nlongn)的时间复杂度，O(1)的空间复杂度
    * */
    public static boolean findanswer(int[] nums){
        int maxnum = 0;
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            maxnum = Math.max(maxnum, nums[i]);
            len++;
        }
        if(len - 1 != maxnum){
            return false;
        }
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] != i + 1){
                return false;
            }
        }
        if(nums[nums.length - 1] != maxnum){
            return false;
        }
        return true;
    }



    public boolean isGood(int[] nums) {
        int n = 0;
        // 先找最大值
        for (int x : nums) {
            n = Math.max(n, x);
        }
        // 条件1：长度必须为 n+1
        if (nums.length != n + 1) {
            return false;
        }

        int[] freq = new int[n + 1];
        for (int x : nums) {
            freq[x]++;
            // 提前终止
            if ((x < n && freq[x] > 1) || (x == n && freq[x] > 2)) {
                return false;
            }
        }

        // 条件2：1..n-1 各出现1次
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }
        // 条件3：n 出现2次
        return freq[n] == 2;
    }
}
