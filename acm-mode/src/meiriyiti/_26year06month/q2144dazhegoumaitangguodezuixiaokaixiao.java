package meiriyiti._26year06month;

import java.util.Arrays;

public class q2144dazhegoumaitangguodezuixiaokaixiao {

    public static void main(String[] args) {
        int[] cost = {1,2,3};
        System.out.println(minimumCost(cost));
    }

    public static int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sumcost = 0;
        for(int i = cost.length - 1;i >= 0;--i){
            //第一贵、第二贵、第三贵的糖果。。。
            //对于需要赠送的糖果的位置会跳过，不计入总成本
            if((cost.length - 1 - i) % 3 != 2){
                sumcost += cost[i];
            }
        }
        return sumcost;
    }
}
