package meiriyiti;

import java.util.HashSet;
import java.util.Set;

public class q3120tongjiteshuzimudeshuliang1 {

    public static void main(String[] args) {
        String word = "abAbcBC";
        System.out.println(numberOfSpecialChars(word));
    }


    /*
    * 用两个 int 的低 26 位分别存储小写/大写的出现情况，最后取交集 + 统计 1 的个数
    * */
    public static int numberOfSpecialChars(String word) {
        int lower = 0, upper = 0;

        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower |= 1 << (c - 'a');
            } else {
                upper |= 1 << (c - 'A');
            }
        }

        return Integer.bitCount(lower & upper);
    }




    /*
    * 自己实现
    * */
    public static int numberOfSpecialChars1(String word){
        Set<Character> setlower = new HashSet<>();
        Set<Character> setupper = new HashSet<>();
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                setlower.add(c);
            } else if (Character.isUpperCase(c)) {
                setupper.add(c);
            }
        }
        for (Character c : setlower) {
            if(setupper.contains(Character.toUpperCase(c))){
                count++;
            }
        }
        return count;
    }



    /*
    * 布尔数组，也好理解
    * */
    public static int numberOfSpecialChars2(String word) {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        int count = 0;
        for (char c : word.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                lower[c - 'a'] = true;
            } else {
                upper[c - 'A'] = true;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (lower[i] && upper[i]) {
                count++;
            }
        }
        return count;
    }

}
