package meiriyiti._26year05month;

import java.util.HashSet;
import java.util.Set;

public class q3043zuichanggonggongqianzhuidechangdu {

    public static void main(String[] args) {
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000};
        System.out.println(longestCommonPrefix(arr1, arr2));
    }

    public static int longestCommonPrefix(int[] arr1,int[] arr2){
        //set集合存储所有的可能前缀情况
        Set<Integer> s = new HashSet<>();
        int res = 0;
        for (int i = 0; i < arr1.length; i++) {
            int num = arr1[i];
            while (num > 0){
                s.add(num);
                num /= 10;
            }
        }
        //遍历arr2，查看是否存在公共前缀，并更新最大值
        for (int i = 0; i < arr2.length; i++) {
            int num = arr2[i];
            while (num > 0){
                if (s.contains(num)){
                    res = Math.max(res,String.valueOf(num).length());
                }
                num /= 10;
            }
        }
        return res;
    }
}
