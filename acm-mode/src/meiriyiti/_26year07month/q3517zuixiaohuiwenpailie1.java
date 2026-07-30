package meiriyiti._26year07month;

import java.util.Arrays;

public class q3517zuixiaohuiwenpailie1 {

    public static void main(String[] args) {
        String s1 = "babab";
        System.out.println(smallestPalindrome(s1));
        String s2 = "daccad";
        System.out.println(smallestPalindrome(s2));
    }

    public static String smallestPalindrome(String s) {
        int len = s.length();
        int partition = len / 2;
        char[] chars = s.toCharArray();
        //sort允许仅排序数组中的一部分
        Arrays.sort(chars,0,partition);
        //填充后半数组
        for(int i = 0;i < partition;i++){
            chars[len - 1 - i] = chars[i];
        }
        return new String(chars);
    }
}
