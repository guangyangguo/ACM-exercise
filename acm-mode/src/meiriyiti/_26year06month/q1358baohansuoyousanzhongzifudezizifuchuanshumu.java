package meiriyiti._26year06month;

public class q1358baohansuoyousanzhongzifudezizifuchuanshumu {

    public static void main(String[] args) {
        String s1 = "abcabc";
        System.out.println(numberOfSubstrings(s1)); // 输出: 10
        String s2 = "aaacb";
        System.out.println(numberOfSubstrings(s2)); // 输出: 3
    }

    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int[] count = new int[3];
        int left = 0;
        for (int right = 0; right < n; right++) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                ans += n - right;
                count[s.charAt(left) - 'a']--;
                left++;
            }
        }
        return ans;
    }


    public static int numberOfSubstrings1(String s) {
        char[] chars = s.toCharArray();
        int[] cnt = new int[3];
        int res = 0;
        int left = 0;
        for (char c : chars) {
            cnt[c - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[chars[left] - 'a']--;
                left++;
            }
            //核心，关键
            res += left;
        }
        return res;
    }
}
