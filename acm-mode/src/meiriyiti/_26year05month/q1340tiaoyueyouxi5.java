package meiriyiti._26year05month;

import java.util.Arrays;

/**
 * LeetCode 1340. 跳跃游戏 V
 *
 * 题目描述：
 * 给定一个整数数组 arr 和一个整数 d。
 * 从下标 i 出发，可以跳转到下标 j，需要满足以下所有条件：
 *   1. 0 <= j < arr.length 且 j 不等于 i
 *   2. |i - j| <= d（跳跃距离不超过 d）
 *   3. arr[i] > arr[j]（只能从高处跳到低处）
 *   4. 从 i 到 j 的路径上，所有中间元素 arr[k] 都必须满足 arr[i] > arr[k]（中间不能有更高的障碍）
 *
 * 可以从任意下标开始跳跃，每一步都可以选择任意满足条件的下标。允许多次访问同一位置。
 * 请求出最多可以访问的不同下标数量。
 *
 * 时间复杂度：O(n * d)，其中 n 为数组长度
 * 空间复杂度：O(n)，递归调用栈深度和记忆化数组
 */
public class q1340tiaoyueyouxi5 {

    /**
     * 记忆化数组 f[i] 表示从下标 i 出发，最多可以访问的不同下标数量（包含起点 i 自身）
     * f[i] = -1 表示该位置尚未计算过
     * f[i] >= 1 表示已经计算完毕
     */
    private static int[] f;

    public static void main(String[] args) {
        // 测试用例
        // arr = [6,4,14,6,8,13,9,7,10,6,12], d = 2
        // 预期输出：4
        // 一种可行的跳跃路径：10 -> 9 -> 7 -> 6 (或 10 -> 9 -> 8 -> 6)
        int[] arr = {6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12};
        System.out.println(maxJumps(arr, 2));
    }

    /**
     * 计算从任意起点出发，最多可以访问的下标数量
     *
     * @param arr 每个位置的高度数组
     * @param d   最大跳跃距离
     * @return    最多可以访问的不同下标数量
     */
    public static int maxJumps(int[] arr, int d) {
        int n = arr.length;
        f = new int[n];
        // 初始化为 -1，表示所有位置都未计算
        Arrays.fill(f, -1);

        // 对每个位置进行 DFS 记忆化搜索，确保所有位置的结果都被计算
        for (int i = 0; i < n; ++i) {
            dfs(arr, i, d, n);
        }

        // 在所有起点中取最大值作为最终答案
        int ans = 0;
        for (int val : f) {
            ans = Math.max(ans, val);
        }
        return ans;
    }

    /**
     * DFS 记忆化搜索：计算从下标 id 出发最多能访问的下标数量
     *
     * 核心思想：
     *   对于当前位置 id，尝试向左右两侧跳跃。
     *   每侧最多跳 d 步，但若遇到高度 >= arr[id] 的位置则停止（被挡住，无法继续向该方向前进）。
     *   从所有合法的目标位置中选择能获得最大访问数的那个，
     *   当前 f[id] = max(自身1步, 跳到邻居后的 f[邻居] + 1)
     *
     * @param arr 高度数组
     * @param id  当前所在位置的下标
     * @param d   最大跳跃距离
     * @param n   数组长度
     */
    private static void dfs(int[] arr, int id, int d, int n) {
        // 如果当前位置已经计算过，直接返回（记忆化剪枝）
        if (f[id] != -1) {
            return;
        }

        // 初始化为 1，表示至少可以访问当前位置自身
        f[id] = 1;

        // 向左探索：从 id-1 开始递减，最多走 d 步
        // 条件：i >= 0（不越界） && id - i <= d（距离不超过 d） && arr[id] > arr[i]（目标位置更低）
        // 注意：一旦遇到 arr[id] <= arr[i]（高度不够或相等），循环立即终止，
        //       因为该位置挡住了去路，无法越过它跳到更左边（满足条件4：中间不能有更高的障碍）
        for (int i = id - 1; i >= 0 && id - i <= d && arr[id] > arr[i]; --i) {
            // 递归计算邻居位置的结果
            dfs(arr, i, d, n);
            // 更新当前最大值：跳到 i 再从 i 出发，+1 表示多访问了当前位置
            f[id] = Math.max(f[id], f[i] + 1);
        }

        // 向右探索：从 id+1 开始递增，最多走 d 步
        // 条件：i < n（不越界） && i - id <= d（距离不超过 d） && arr[id] > arr[i]（目标位置更低）
        // 同理，遇到 arr[id] <= arr[i] 时循环终止
        for (int i = id + 1; i < n && i - id <= d && arr[id] > arr[i]; ++i) {
            // 递归计算邻居位置的结果
            dfs(arr, i, d, n);
            // 更新当前最大值
            f[id] = Math.max(f[id], f[i] + 1);
        }
    }
}
