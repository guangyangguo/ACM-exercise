package meiriyiti._26year05month;

public class q3300tihuanweishuweiheyihoudezuixiaoyuansu {

    public static void main(String[] args) {
        int[] nums = {10,12,13,14};
        System.out.println(minElement(nums));
    }


    /*
    * 简单题
    * */
    public static int minElement(int[] nums){
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int he = gethe(nums[i]);
            res = Math.min(res, he);
        }
        return res;
    }
    public static int gethe(int num){
        int res = 0;
        while (num >= 10){
            res += num % 10;
            num /= 10;
        }
        res += num;
        return res;
    }
}
