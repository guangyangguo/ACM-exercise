package meiriyiti._26year07month;

import java.util.ArrayList;
import java.util.List;

public class q2492lianggechengshijiandezuixiaofenshu {

    public static void main(String[] args) {
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
        System.out.println(minScore(4,roads));

        int[][] roads2 = {{1,2,2},{1,3,4},{3,4,7}};
        System.out.println(minScore(4,roads2));
    }

    public static record Edge(int v,int dis){}
    public static int minScore(int n,int[][] roads){
        boolean vis[] = new boolean[n + 1];
        List<Edge> graph[] = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            graph[road[0]].add(new Edge(road[1], road[2]));
            graph[road[1]].add(new Edge(road[0], road[2]));
        }
        int[] ans = {Integer.MAX_VALUE};
        dis(1,graph,vis,ans);
        return ans[0];
    }
    public static void dis(int u, List<Edge>[] graph,boolean[] vis,int[] ans){
        if(vis[u] == false){
            vis[u] = true;
        }
        for (Edge edge : graph[u]) {
            ans[0] = Math.min(ans[0],edge.dis);
            if(vis[edge.v] == false){
                dis(edge.v,graph,vis,ans);
            }
        }
    }
}
