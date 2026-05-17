package meiriyiti;

import java.util.LinkedList;
import java.util.Queue;

public class q1306 {

    public static void main(String[] args) {
        //true
        int[] arr = {4,2,3,0,3,1,2};
        //false
        int[] arr2 = {3,0,2,1,2};
        System.out.println(canReachEnd(arr2, 2));
    }

    /*
    * 利用队列进行BFS实现
    * */
    public static boolean canReachEnd(int[] arr,int start) {
        int[] visited = new int[arr.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i < size;i++){
                Integer currindex = queue.poll();
                int next1 = currindex + arr[currindex];
                int next2 = currindex - arr[currindex];
                if(next1 >= 0 && next1 < arr.length && visited[next1] == 0){
                    if(arr[next1] == 0){
                        return true;
                    }
                    visited[next1] = 1;
                    queue.offer(next1);
                }
                if (next2 >= 0 && next2 < arr.length && visited[next2] == 0){
                    if(arr[next2] == 0){
                        return true;
                    }
                    visited[next2] = 1;
                    queue.offer(next2);
                }
            }
        }
        return false;
    }
}
