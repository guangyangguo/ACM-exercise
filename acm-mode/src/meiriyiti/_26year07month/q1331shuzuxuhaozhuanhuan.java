package meiriyiti._26year07month;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class q1331shuzuxuhaozhuanhuan {

    public static void main(String[] args) {
        int[] arr = {40,10,20,30};
        int[] ints = arrayRankTransform(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }


    /*
    * 官方标准解法
    * */
    public static int[] arrayRankTransform(int[] arr) {
        int[] sortedarr = new int[arr.length];
        System.arraycopy(arr,0,sortedarr,0,arr.length);
        Arrays.sort(sortedarr);
        Map<Integer,Integer> mp = new HashMap<>();
        for(int a : sortedarr){
            if(!mp.containsKey(a)){
                mp.put(a,mp.size() + 1);
            }
        }
        int[] res = new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            res[i] = mp.get(arr[i]);
        }
        return res;
    }
}
