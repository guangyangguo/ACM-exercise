package meiriyiti._26year06month;

import java.util.HashMap;
import java.util.Map;

public class q3020zijizhongyuansudezuidashuliang {

    public static void main(String[] args) {
        int[] nums = {5,4,1,2,2};
        System.out.println(getanswer(nums));
        int[] nums1 = {1,3,2,4};
        System.out.println(getanswer(nums1));
    }


    /*
    * 有点难度的，但是还是能理解的
    * */
    public static int getanswer(int[] nums){
        Map<Long, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            cnt.merge((long) num, 1, Integer::sum);
        }

        int oneCnt = cnt.getOrDefault(1L, 0);
        // ans 至少是 1 的数量，向下取奇数
        int ans = (oneCnt & 1) == 1 ? oneCnt : oneCnt - 1;

        cnt.remove(1L);

        for (long num : cnt.keySet()) {
            int res = 0;
            long x = num;

            while (cnt.containsKey(x) && cnt.get(x) > 1) {
                res += 2;
                x *= x;
            }

            ans = Math.max(ans, res + (cnt.containsKey(x) ? 1 : -1));
        }

        return ans;
    }
}
