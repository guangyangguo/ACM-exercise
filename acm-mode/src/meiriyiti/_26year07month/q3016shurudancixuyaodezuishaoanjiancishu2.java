package meiriyiti._26year07month;

import java.util.Arrays;

public class q3016shurudancixuyaodezuishaoanjiancishu2 {

    public static void main(String[] args) {
        String word1 = "abcde";
        System.out.println(minimumPushes(word1)); // 输出 5
        String word2 = "xyzxyzxyzxyz";
        System.out.println(minimumPushes(word2)); // 输出 12
    }

    public static int minimumPushes(String word) {
        int res = 0;
        int[] nums = new int[26];
        for(int i = 0;i < word.length();i++){
            char chs = word.charAt(i);
            nums[chs - 'a']++;
        }
        Arrays.sort(nums);
        int i = 25;
        while(i >= 0 && nums[i] > 0){
            int beishu = 1;
            if(i >= 18 && i <= 25){
                beishu = 1;
            }
            else if(i >= 10 && i <= 17){
                beishu = 2;
            }else if(i >= 2 && i <= 9){
                beishu = 3;
            }else{
                beishu = 4;
            }
            res += nums[i] * beishu;
            i--;
        }
        return res;
    }
}
