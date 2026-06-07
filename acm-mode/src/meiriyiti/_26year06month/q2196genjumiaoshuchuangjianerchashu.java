package meiriyiti._26year06month;

import com.sun.source.tree.Tree;

import java.util.*;

public class q2196genjumiaoshuchuangjianerchashu {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        int[][] descriptions = {{20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}};
        TreeNode root = createBinaryTree(descriptions);
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Boolean> isRoot = new HashMap<>();  // 数值对应的节点是否为根节点的哈希表
        Map<Integer, TreeNode> nodes = new HashMap<>();  // 数值与对应节点的哈希表
        //构造树的过程
        for (int[] d : descriptions) {
            int p = d[0];
            int c = d[1];
            boolean left = d[2] == 1;
            //虽然存的有所有节点，但是仅根节点的值是true，其他节点都是false
            if (!isRoot.containsKey(p)) {
                isRoot.put(p, true);
            }
            isRoot.put(c, false);

            // 创建或更新节点
            if (!nodes.containsKey(p)) {
                nodes.put(p, new TreeNode(p));
            }
            if (!nodes.containsKey(c)) {
                nodes.put(c, new TreeNode(c));
            }
            //建立父子关系
            if (left) {
                nodes.get(p).left = nodes.get(c);
            } else {
                nodes.get(p).right = nodes.get(c);
            }
        }

        // 寻找根节点
        int root = -1;
        for (Map.Entry<Integer, Boolean> entry : isRoot.entrySet()) {
            if (entry.getValue()) {
                root = entry.getKey();
                break;
            }
        }
        return nodes.get(root);
    }


    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int nums = queue.size();
            List<Integer> temp = new ArrayList();
            for(int i = 0;i < nums;i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
