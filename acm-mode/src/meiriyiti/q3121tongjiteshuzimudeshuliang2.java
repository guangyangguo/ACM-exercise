package meiriyiti;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class q3121tongjiteshuzimudeshuliang2 {

    public static void main(String[] args) {
        String word = "abAbcBC";  //3
        String word1 = "AbBCab";  //0
        System.out.println(numberOfSpecialChars(word1));
    }


    /*
    * 自己实现，思路清晰
    * 与3120统计特殊字母数量1的区别是在1的基础上要求每个小写字母都出现在大写字母之前
    * */
    public static int numberOfSpecialChars(String word){
        Set<Character> setlower = new HashSet<>();
        Set<Character> setupper = new HashSet<>();
        //记录每个字母出现的位置
        Map<Character,Integer> mp = new HashMap<>();
        int count = 0;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if (Character.isLowerCase(c)){
                //小写字母记录最后一个位置即可，所以不停覆盖
                mp.put(c,i);
                setlower.add(c);
            }else {
                //大写字母记录第一个位置即可，所以不重复添加
                if (!mp.containsKey(c)){
                    mp.put(c,i);
                }
                setupper.add(c);
            }
        }
        for (Character c : setlower){
            if (setupper.contains(Character.toUpperCase(c)) && mp.get(c) < mp.get(Character.toUpperCase(c))){
                count++;
            }
        }
        return count;
    }
}
