package haxi;

import java.util.HashSet;
import java.util.Set;

public class zuichanglianxuxulie {

    /*
    * 128.最长连续序列
    * */

    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(findanswer(nums));
    }

    public static int findanswer(int[] nums){
        Set<Integer> s = new HashSet<>();
        for(int num : nums){
            s.add(num);
        }
        int result = 0;
        for(int num : s){
            if(!s.contains(num - 1)){
                int currlen = 1;
                int currnum = num;
                while (s.contains(currnum + 1)){
                    currlen++;
                    currnum++;
                }
                result = Math.max(result,currlen);
            }
        }
        return result;
    }

}
