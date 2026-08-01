package meiriyiti._26year08month;

public class q486yuceyingjia {

    public static void main(String[] args) {
        int[] nums = {1, 5, 2};
        System.out.println(predictTheWinner(nums));
        int[] nums2 = {1, 5, 233, 7};
        System.out.println(predictTheWinner(nums2));
    }


    public static boolean predictTheWinner(int[] nums) {
        int length = nums.length;
        //dp[i][j]表示从nums[i]~nums[j]中先手玩家与后手玩家的分数差值
        //分差大于0表示先手玩家获胜，小于0表示后手玩家获胜
        int[][] dp = new int[length][length];
        //当只有一个数字的时候，先手玩家直接拿走这个数字，分差就是这个数字本身
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                //先手玩家选择nums[i]，那么后手玩家的分差就是dp[i + 1][j]，所以先手玩家的分差就是nums[i] - dp[i + 1][j]
                //先手玩家选择nums[j]，那么后手玩家的分差就是dp[i][j - 1]，所以先手玩家的分差就是nums[j] - dp[i][j - 1]
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        //从nums[0]~nums[length-1]中先手玩家与后手玩家的分数差值大于等于0，说明先手玩家获胜
        return dp[0][length - 1] >= 0;
    }
}
