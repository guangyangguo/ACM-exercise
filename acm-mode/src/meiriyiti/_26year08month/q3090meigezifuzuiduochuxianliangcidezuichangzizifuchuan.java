package meiriyiti._26year08month;

public class q3090meigezifuzuiduochuxianliangcidezuichangzizifuchuan {

    public static void main(String[] args) {
        String s1 = "bcbbbcba";
        System.out.println(maximumLengthSubstring(s1)); // 输出: 4
        String s2 = "aaaa";
        System.out.println(maximumLengthSubstring(s2)); // 输出: 2
    }

    public static int maximumLengthSubstring(String s) {
        int len = s.length();
        int res = 0;
        for(int left = 0;left < len;left++){
            int[] ins = new int[26];
            for(int right = left;right < len;right++){
                int ch = s.charAt(right) - 'a';
                ins[ch]++;
                if(ins[ch] > 2){
                    break;
                }
                res = Math.max(res,right - left + 1);
            }
        }
        return res;
    }
}
