package meiriyiti._26year07month;

import java.util.Arrays;

public class q1979zhaochushuzudezuidagongyueshu {

    public static void main(String[] args) {
        int[] nums = {2,5,6,9,10};
        System.out.println(findGCD(nums));
    }

    public static int findGCD(int[] nums){
        Arrays.sort(nums);
        return gcd(nums[0],nums[nums.length - 1]);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
