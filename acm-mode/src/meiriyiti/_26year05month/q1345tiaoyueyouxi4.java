package meiriyiti._26year05month;

import java.util.*;

public class q1345tiaoyueyouxi4 {

    public static void main(String[] args) {
        int[] arr = {100,-23,-23,404,100,23,23,23,3,404};
        System.out.println(minJump(arr));
    }




    /*
    * 自己实现，广度优先
    * */
    public static int minJump(int[] arr){
        int n = arr.length;
        if (n == 1){
            return 0;
        }
        if (arr[0] == arr[n - 1]){
            return 1;
        }
        Map<Integer, List<Integer>> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (mp.containsKey(arr[i])){
                mp.get(arr[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mp.put(arr[i], list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] step = new int[n];
        Arrays.fill(step, n + 1);
        step[0] = 0;
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer currindex = queue.poll();
                int nextindex1 = currindex + 1;
                int nextindex2 = currindex - 1;
                if (nextindex1 < n && nextindex1 >= 0 && !visited[nextindex1]){
                    step[nextindex1] = Math.min(step[nextindex1], step[currindex] + 1);
                    queue.offer(nextindex1);
                    visited[nextindex1] = true;
                }
                if (nextindex2 < n && nextindex2 >= 0 && !visited[nextindex2]){
                    step[nextindex2] = Math.min(step[nextindex2], step[currindex] + 1);
                    queue.offer(nextindex2);
                    visited[nextindex2] = true;
                }
                int currnum =  arr[currindex];
                List<Integer> list = mp.get(currnum);
                for(Integer nextindex : list){
                    if (nextindex != currindex && !visited[nextindex]){
                        step[nextindex] = Math.min(step[nextindex], step[currindex] + 1);
                        queue.offer(nextindex);
                        visited[nextindex] = true;
                    }
                }
                // ！！！这里要清空这个list，否则会重复访问，超时
                list.clear();
            }
        }
        return step[n - 1];
    }
}
