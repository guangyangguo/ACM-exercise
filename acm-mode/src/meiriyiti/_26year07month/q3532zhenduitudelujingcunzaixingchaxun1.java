package meiriyiti._26year07month;

import java.util.ArrayList;
import java.util.List;

public class q3532zhenduitudelujingcunzaixingchaxun1 {

    public static void main(String[] args) {
        int[] nums = {1,3};
        int[][] queries = {{0,0},{0,1}};
        boolean[] booleans = pathExistenceQueries(2, nums, 1, queries);
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
        System.out.println("-------------------");
        int[] nums2 = {2,5,6,8};
        int[][] queries2 = {{0,1},{0,2},{1,3},{2,3}};
        boolean[] booleans2 = pathExistenceQueries(4, nums2,2,queries2);
        for (boolean aBoolean : booleans2) {
            System.out.println(aBoolean);
        }
    }

    /*
    * 二分解法
    * */
    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        //list用于存储所有联通分量的最后一个节点索引
        List<Integer> rights = new ArrayList<>();
        for(int i = 1;i < n;i++){
            if(Math.abs(nums[i] - nums[i - 1]) > maxDiff){
                //差值大于maxDiff代表i - 1和i是不连续的
                //i - 1是上一个联通分量的最后一个节点
                rights.add(i - 1);
            }
        }
        //最后一个节点一定是联通分量的最后一个节点
        rights.add(n - 1);
        boolean[] res = new boolean[queries.length];
        for(int i = 0;i < queries.length;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            int idx = lowerBound(rights,x);
            int idy = lowerBound(rights,y);
            //判断x和y是否是同一个联通分量
            res[i] = idx == idy;
        }
        return res;
    }
    //二分判断target是属于哪一个联通分量的
    public static int lowerBound(List<Integer> list, int target){
        int left = 0;
        int right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < target){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return left;
    }


    /*
    * 前缀分组标记法
    * */
    public static boolean[] pathExistenceQueries1(int n, int[] nums, int maxDiff, int[][] queries) {
        //用数组存储元素的下标对应的联通分量的归属
        //初始默认都属于联通分量0
        int[] tags = new int[n];
        for(int i = 1;i < n;i++){
            if(nums[i] - nums[i - 1] > maxDiff){
                //说明i与i-1断开了，那i就是新的联通分量
                tags[i] = tags[i - 1] + 1;
            }else{
                tags[i] = tags[i - 1];
            }
        }
        boolean[] res = new boolean[queries.length];
        for(int i = 0;i < queries.length;i++){
            int x = queries[i][0];
            int y = queries[i][1];
            //判断x和y是否归属同一个联通分量
            res[i] = tags[x] == tags[y];
        }
        return res;
    }
}
