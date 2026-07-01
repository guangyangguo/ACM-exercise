package meiriyiti._26year07month;

import java.util.*;

public class q2812zhaochuzuianquanlujing {

    /*
    * 虽然是中等题，但是难度应该算是难题
    * */
    public static void main(String[] args) {
        List<List<Integer>> grid1 = new ArrayList<>();
        grid1.add(new ArrayList<>(List.of(1,0,0)));
        grid1.add(new ArrayList<>(List.of(0,0,0)));
        grid1.add(new ArrayList<>(List.of(0,0,1)));
        System.out.println(maximumSafenessFactor(grid1));

        List<List<Integer>> grid2 = new ArrayList<>();
        grid2.add(new ArrayList<>(List.of(0,0,0,1)));
        grid2.add(new ArrayList<>(List.of(0,0,0,0)));
        grid2.add(new ArrayList<>(List.of(0,0,0,0)));
        grid2.add(new ArrayList<>(List.of(1,0,0,0)));
        System.out.println(maximumSafenessFactor(grid2));
    }
    private static final int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    private static int n;
    private static int[][] dist;


    //AI的解法，对的，但是不理解
    public int maximumSafenessFactor2(List<List<Integer>> grid) {
        n = grid.size();
        // 特判：起点或终点是小偷，安全系数直接为0
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }

        // 1. 多源BFS预处理每个格子到最近小偷的距离
        dist = new int[n][n];
        // 初始化距离为-1（未访问）
        for (int[] row : dist) Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();

        // 收集所有小偷坐标存入List<int[]>
        List<int[]> thiefList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    thiefList.add(new int[]{i, j});
                    dist[i][j] = 0; // 小偷自身距离为0
                    q.offer(new int[]{i, j});
                }
            }
        }

        // 多源BFS扩散计算最小距离
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                // 边界合法且未访问
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        // 2. 二分答案：最大化最小安全系数
        int left = 0;
        int right = Math.min(dist[0][0], dist[n - 1][n - 1]);
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            // 检查是否存在路径，所有格子距离>=mid
            if (check(mid)) {
                ans = mid;
                left = mid + 1; // 可行，尝试更大安全系数
            } else {
                right = mid - 1; // 不可行，缩小上限
            }
        }
        return ans;
    }

    // BFS判定函数：是否能从(0,0)走到(n-1,n-1)，路径所有格子dist>=limit
    private boolean check(int limit) {
        if (dist[0][0] < limit) return false; // 起点本身不满足直接返回false
        boolean[][] vis = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            // 到达终点，直接返回true
            if (x == n - 1 && y == n - 1) return true;
            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                // 边界合法 + 未访问 + 当前格子距离>=限制值
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !vis[nx][ny] && dist[nx][ny] >= limit) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }



    //对的解法，能理解，但是个别用例超时
    public int maximumSafenessFactor1(List<List<Integer>> grid) {
        int[][] grids = grid.stream()
                .map(row -> row.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
        int m = grids.length;
        int n = grids[0].length;
        if(grids[0][0] == 1 || grids[m - 1][n - 1] == 1){
            return 0;
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grids[i][j] == 1){
                    list.add(new int[]{i,j});
                }
            }
        }
        int[][] juli = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grids[i][j] == 1){
                    continue;
                }
                int jiedianjuli = jisuan(list,i,j);
                juli[i][j] = jiedianjuli;
            }
        }
        // ========== 新增：二分答案完整逻辑 ==========
        int left = 0;
        int right = Math.min(juli[0][0], juli[m-1][n-1]);
        int ans = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            // 判断是否存在路径，路径所有格子juli >= mid
            if(check(mid, juli, m, n)){
                ans = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return ans;
    }


    //自己实现的，思路是对的，但是没有实现完全
    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int[][] grids = grid.stream()
                .map(row -> row.stream()
                        .mapToInt(Integer::intValue)
                        .toArray())
                .toArray(int[][]::new);
        int m = grids.length;
        int n = grids[0].length;
        int[][] dp = new int[m][n];
        if(grids[0][0] == 1 || grids[m - 1][n - 1] == 1){
            return 0;
        }
        List<int[]> list = new ArrayList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grids[i][j] == 1){
                    list.add(new int[]{i,j});
                }
            }
        }
        int[][] juli = new int[m][n];
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grids[i][j] == 1){
                    juli[i][j] = Integer.MAX_VALUE;
                    continue;
                }
                int jiedianjuli = jisuan(list,i,j);
                juli[i][j] = jiedianjuli;
            }
        }
        return 0;
    }
    public static int jisuan(List<int[]> list,int i,int j){
        int res = Integer.MAX_VALUE;
        for(int[] ints : list){
            int xiaotoux = ints[0];
            int xiaotouy = ints[1];
            res = Math.abs(xiaotoux - i) + Math.abs(xiaotouy - j);
        }
        return res;
    }



    private static boolean check(int limit, int[][] juli, int m, int n){
        if(juli[0][0] < limit) return false;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            if(x == m-1 && y == n-1) return true;
            for(int[] d : dirs){
                int nx = x + d[0];
                int ny = y + d[1];
                if(nx >=0 && nx < m && ny >=0 && ny < n && !vis[nx][ny] && juli[nx][ny] >= limit){
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
