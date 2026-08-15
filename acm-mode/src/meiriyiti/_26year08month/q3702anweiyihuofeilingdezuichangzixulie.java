package meiriyiti._26year08month;

public class q3702anweiyihuofeilingdezuichangzixulie {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        System.out.println(longestSubsequence(nums1)); // 输出: 2
        int[] nums2 = {2,3,4};
        System.out.println(longestSubsequence(nums2)); // 输出: 3
        int[] nums3 = {0, 0, 0};
        System.out.println(longestSubsequence(nums3)); // 输出: 0
    }

    public static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalxor = 0;
        boolean allzero = true;
        for(int x : nums){
            totalxor ^= x;
            if(x > 0){
                allzero = false;
            }
        }
        //所有元素异或都不为0，它自己就是最长的
        if(totalxor > 0){
            return n;
        }
        //所有元素异或为0
        //如果是所有元素都是0，那么就不存在这样的子序列，因为题目要的是异或结果非0
        //如果是不是所有元素都为0，但是所有元素异或结果为0，那么去掉一个元素的异或结果就一定非0
        return allzero ? 0 : n - 1;
    }
}
