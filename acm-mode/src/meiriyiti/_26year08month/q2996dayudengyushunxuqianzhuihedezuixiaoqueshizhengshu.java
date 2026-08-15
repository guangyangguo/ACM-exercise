package meiriyiti._26year08month;

import java.util.*;

public class q2996dayudengyushunxuqianzhuihedezuixiaoqueshizhengshu {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,5};
        System.out.println(missingInteger(nums1)); // 输出: 6
        int[] nums2 = {1,2,3,4,5};
        System.out.println(missingInteger(nums2)); // 输出: 15
    }

    public static int missingInteger(int[] nums) {
        //题目有个小坑点，是前缀是一定从下标0开始的
        //所以不用考虑存在中间前缀长度大于从0开始的前缀
        int sum = nums[0];
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i < nums.length;i++){
            list.add(nums[i]);
        }
        for(int i = 1;i < nums.length;i++){
            //从0开始，只要碰到不等的，直接结束
            if(nums[i] != nums[i - 1] + 1){
                break;
            }
            sum += nums[i];
        }
        //不包含直接返回
        if(!list.contains(sum)){
            return sum;
        }
        //递增找第一个不包含的数
        while(list.contains(sum)){
            sum++;
        }
        return sum;
    }
}
