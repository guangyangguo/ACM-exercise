package meiriyiti._26year07month;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class q1260erweiwanggeqianyi {

    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(shiftGrid(grid, 1));
    }


//    好理解的方法
//    先观察题目，不要将题目想复杂化
    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k %= total;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 原一维下标
                int idx = i * n + j;
                // 偏移后下标
                int newIdx = (idx + k) % total;
                int ni = newIdx / n;
                int nj = newIdx % n;
                res[ni][nj] = grid[i][j];
            }
        }

        // 转List
        List<List<Integer>> ans = new ArrayList<>();
        for (int[] row : res) {
            List<Integer> list = new ArrayList<>();
            for (int num : row){
                list.add(num);
            }
            ans.add(list);
        }
        return ans;
    }
}
