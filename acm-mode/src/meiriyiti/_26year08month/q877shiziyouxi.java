package meiriyiti._26year08month;

public class q877shiziyouxi {

    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(stoneGame(piles));
        int[] piles2 = {3, 7, 2, 3};
        System.out.println(stoneGame(piles2));
    }


    /*
    * 和486题类似，都是先手玩家和后手玩家轮流选择数字，最后分数高的玩家获胜
    * */
    public static boolean stoneGame(int[] piles) {
        int length = piles.length;
        //dp[i][j]表示从piles[i]~piles[j]中先手玩家与后手玩家的分数差值
        //分差大于0表示先手玩家获胜，小于0表示后手玩家获胜
        int[][] dp = new int[length][length];
        //当只有一个数字的时候，先手玩家直接拿走这个数字，分差就是这个数字本身
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                //先手玩家选择piles[i]，那么后手玩家的分差就是dp[i + 1][j]，所以先手玩家的分差就是piles[i] - dp[i + 1][j]
                //先手玩家选择piles[j]，那么后手玩家的分差就是dp[i][j - 1]，所以先手玩家的分差就是piles[j] - dp[i][j - 1]
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        //从piles[0]~piles[length-1]中先手玩家与后手玩家的分数差值大于等于0，说明先手玩家获胜
        return dp[0][length - 1] >= 0;
    }
}
