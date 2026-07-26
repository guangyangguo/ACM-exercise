package meiriyiti._26year07month;

import java.util.ArrayList;
import java.util.List;

public class q3499caozuohouzuidahuoyuequduanshu1 {

    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("01"));//1
        System.out.println(maxActiveSectionsAfterTrade("0100"));//4
        System.out.println(maxActiveSectionsAfterTrade("1000100"));//7

        System.out.println(maxActiveSectionsAfterTrade1("01"));//1
    }

    /*
    * 自己实现的，感觉没问题，但是执行出错
    * */
    public static int maxActiveSectionsAfterTrade1(String s) {
        //用于存储0,1分段的长度
        List<Integer> list = new ArrayList<>();
        char currstr = s.charAt(0);
        int currindex = 0;
        boolean iszero = currstr == '0';
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(c == currstr){
                continue;
            }else{
                //更新分段的统计
                list.add(i - currindex);
                currstr = c;
                currindex = i;
            }
        }
        int[] ans = list.stream().mapToInt(Integer::intValue).toArray();
        //要找的是和最长的两个0区间
        int startindex = 0;
        //字符串开头是1
        if(!iszero){
            //所有第一个0区间是索引1的位置
            startindex = 1;
        }
        //
        int zerolength = 0;
        //标记两个0区间的索引
        int zeroindexleft = 0;
        int zeroindexright = 0;
        for(int i = startindex + 2;i < ans.length;i++){
            int currzerolength = ans[i] + ans[i - 2];
            //取和最大的两个0区间
            if(currzerolength > zerolength){
                zerolength = currzerolength;
                //更新0区间的索引
                zeroindexleft = i - 2;
                zeroindexright = i;
            }
            //注意是每次加2，所以这里要再加一次
            i++;
        }
        //统计两个0区间和中间1区间的总长度
        int middlelength = ans[zeroindexleft] + ans[zeroindexleft + 1] + ans[zeroindexright];
        //再加上两边可能存在的1区间
        //不同情况不同处理
        if(zeroindexleft == 0){
            if(zeroindexright == ans.length - 1){
                return middlelength;
            }else{
                return middlelength + ans[zeroindexright + 1];
            }
        }else{
            if(zeroindexright == ans.length - 1){
                return ans[zeroindexleft - 1] + middlelength;
            }else{
                return ans[zeroindexleft - 1] + middlelength + ans[zeroindexright + 1];
            }
        }
    }


    /*
    * 官方标解
    * */
    public static int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int cnt1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') cnt1++;
        }

        List<Integer> zeroBlocks = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            if (s.charAt(start) == '0') {
                zeroBlocks.add(i - start);
            }
        }

        int m = zeroBlocks.size();
        if (m < 2) {
            return cnt1;
        }
        int bestGain = 0; // 最优增量
        for (int j = 0; j < m - 1; j++) {
            bestGain = Math.max(bestGain, zeroBlocks.get(j) + zeroBlocks.get(j + 1));
        }

        return cnt1 + bestGain;
    }
}
