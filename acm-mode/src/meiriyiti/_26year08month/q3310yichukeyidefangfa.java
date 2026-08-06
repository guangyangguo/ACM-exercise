package meiriyiti._26year08month;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class q3310yichukeyidefangfa {

    public static void main(String[] args) {
        int[][] invocations = {{1, 2},{0, 1}, {3, 2}};
        List<Integer> list = remainingMethods(4, 1, invocations);
        for (Integer i : list) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[][] invocations2 = {{1, 2},{0, 2}, {0, 1}, {3, 4}};
        List<Integer> list1 = remainingMethods(5, 0, invocations2);
        for (Integer i : list1) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i = 0;i < graph.length;i++){
            graph[i] = new ArrayList<>();
        }
        int[] indegree = new int[n];
        int[] iskeyi = new int[n];
        // 构建调用图
        for(int[] prereq : invocations){
            int premethod = prereq[0];
            int currmethod = prereq[1];
            graph[premethod].add(currmethod);
            indegree[currmethod]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(k);
        iskeyi[k] = 1;
        // BFS找出所有k能直接/间接调用的可疑节点
        while (!queue.isEmpty()){
            int cur = queue.poll();
            for(int nextmethod : graph[cur]){
                if(iskeyi[nextmethod] == 0){
                    iskeyi[nextmethod] = 1;
                    queue.offer(nextmethod);
                }
            }
        }

        boolean isremoveall = true;
        // 遍历所有调用边，判断是否存在【非可疑方法调用可疑方法】
        for(int[] prereq : invocations){
            int premethod = prereq[0];
            int currmethod = prereq[1];
            //这里是关键
            if(iskeyi[premethod] == 0 && iskeyi[currmethod] == 1){
                isremoveall = false;
                break;
            }
        }

        List<Integer> res = new ArrayList<>();
        if(!isremoveall){
            // 不能删除可疑节点，返回全部方法
            for(int i = 0;i < n;i++){
                res.add(i);
            }
        }else{
            // 可以删除，只收集非可疑方法
            for(int i = 0;i < n;i++){
                if(iskeyi[i] == 0){
                    res.add(i);
                }
            }
        }
        return res;
    }
}
