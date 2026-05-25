package meiriyiti;

import java.util.LinkedList;
import java.util.Queue;

public class q1871tiaoyueyouxi7 {

    public static void main(String[] args) {
        String s = "011010";
        System.out.println(canReach(s, 2, 3));
    }




    /*
    * 滑动窗口计数法
    * i是当前处理的元素，他计算的是[i-maxJump, i-minJump]区间中有多少个能到i的元素
    * 所以 i-minJump是进入区间，用加，i-maxJump是离开区间，用减
    * */
    public static boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int count = 0;

        for (int i = 1; i < n; i++) {
            // i-minJump 进入窗口，累加可达数
            if (i - minJump >= 0) {
                count += dp[i - minJump] ? 1 : 0;
            }
            // i-maxJump-1 移出窗口，减去可达数
            if (i - maxJump - 1 >= 0) {
                count -= dp[i - maxJump - 1] ? 1 : 0;
            }
            // 满足字符为0+窗口有来路，标记可达
            dp[i] = (s.charAt(i) == '0') && (count > 0);
        }
        return dp[n - 1];
    }


    /*
    * 优化的BFS
    * */
    public static boolean canReach1(String s,int minJump,int maxJump){
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        //记录上次访问的最远位置，避免重复访问
        int last = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int index = queue.poll();
                int left = index + minJump;
                int right = Math.min(index + maxJump, s.length() - 1);
                //从上次最远位置开始
                left = Math.max(left, last + 1);
                for(int j = left;j <= right;j++){
                    if(s.charAt(j) == '0'){
                        if(j == s.length() - 1){
                            return true;
                        }
                        dp[j] = true;
                        queue.offer(j);
                    }
                }
                //更新至最远位置
                last = right;
            }
        }
        return dp[s.length() - 1];
    }


    /*
    * 思路对的，但是超时
    * */
    public static boolean canReach2(String s,int minJump,int maxJump){
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                int index = queue.poll();
                int left = index + minJump;
                int right = Math.min(index + maxJump, s.length() - 1);
                for(int j = left;j <= right;j++){
                    if (j == s.length() - 1){
                        return true;
                    }
                    if(s.charAt(j) == '0' && !dp[j]){
                        dp[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
