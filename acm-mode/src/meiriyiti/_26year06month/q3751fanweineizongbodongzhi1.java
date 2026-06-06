package meiriyiti._26year06month;

import java.util.ArrayList;
import java.util.List;

public class q3751fanweineizongbodongzhi1 {

    public static void main(String[] args) {
        System.out.println(totalWaviness(120, 130));
    }


    /*
    * 暴力解，不算难
    * */
    public static int totalWaviness(int num1, int num2) {
        int count = 0;
        for(int i = num1;i <= num2;i++){
            int[] shuzu = getints(i);
            for(int j = 1;j < shuzu.length - 1;j++){
                if(shuzu[j] > shuzu[j - 1] && shuzu[j] > shuzu[j + 1]){
                    count++;
                }
                if(shuzu[j] < shuzu[j - 1] && shuzu[j] < shuzu[j + 1]){
                    count++;
                }
            }
        }
        return count;
    }
    public static int[] getints(int n){
        List<Integer> list = new ArrayList<>();
        while(n >= 10){
            int yushu = n % 10;
            list.add(yushu);
            n /= 10;
        }
        list.add(n);
        int[] res = list.stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
}
