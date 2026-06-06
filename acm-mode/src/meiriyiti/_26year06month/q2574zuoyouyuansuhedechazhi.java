package meiriyiti._26year06month;

public class q2574zuoyouyuansuhedechazhi {

    public static void main(String[] args) {
        int[] nums = {10,4,8,3};
        int[] ints = leftRightDifference(nums);
        for (int i : ints) {
            System.out.println(i);
        }
    }


    /*
    * 简单题，暴力即可
    * */
    public static int[] leftRightDifference(int[] nums){
        int[] res = new int[nums.length];

        int[] left = new int[nums.length];
        left[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] + nums[i - 1];
        }
        int[] right = new int[nums.length];
        right[nums.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] + nums[i + 1];
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = Math.abs(left[i] - right[i]);
        }
        return res;
    }
}
