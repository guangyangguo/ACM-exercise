package meiriyiti._26year07month;

import java.util.ArrayList;
import java.util.List;

public class q1291shuncishu {

    public static void main(String[] args) {
        List<Integer> list = sequentialDigits(1000, 13000);
        list.forEach(System.out::println);
    }

    /*
    * 枚举
    * */
    public static List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i <= 9;i++){
            int num = i;
            for(int j = i + 1;j <= 9;j++){
                num = num * 10 + j;
                if(num >= low && num <= high){
                    res.add(num);
                }
            }
        }
        res.sort((a,b) -> a - b);
        return res;
    }



    /*
    * 递归
    * */
    public List<Integer> sequentialDigits1(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for(int i = 1;i <= 9;i++){
            int num = i;
            getdigui(low,high,res,num);
        }
        res.sort((a,b) -> a - b);
        return res;
    }
    public void getdigui(int low,int high,List<Integer> res,int num){
        if(num > high){
            return;
        }
        // 符合区间就加入结果
        if(num >= low && num <= high){
            res.add(num);
        }
        // 取出当前数最后一位
        int last = num % 10;
        // 最后一位是9，不能再往后拼接，直接结束递归
        if(last == 9){
            return;
        }
        // 拼接下一位：最后一位+1，生成新数字
        int newNum = num * 10 + (last + 1);
        // 递归继续往下生成更长的顺次数
        getdigui(low, high, res, newNum);
    }
}
