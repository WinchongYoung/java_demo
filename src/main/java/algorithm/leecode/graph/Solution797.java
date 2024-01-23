package algorithm.leecode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 图的深度优先搜索
 *  0 ->  1
 *  |     |
 *  V     V
 *  2 ->  3
 */
public class Solution797 {

    List<List<Integer>> ans;        // 用来存放满足条件的路径
    List<Integer> cnt;        // 用来保存 dfs 过程中的节点值

    public void dfs(int[][] graph, int node) {
        if (node == graph.length - 1) {        // 如果当前节点是 n - 1，那么就保存这条路径
            ans.add(new ArrayList<>(cnt));
            return;
        }
        for (int index = 0; index < graph[node].length; index++) {
            int nextNode = graph[node][index];
            cnt.add(nextNode);
            dfs(graph, nextNode);
            cnt.remove(cnt.size() - 1);        // 回溯
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        ans = new ArrayList<>();
        cnt = new ArrayList<>();
        cnt.add(0);            // 注意，0 号节点要加入 cnt 数组中
        dfs(graph, 0);
        return ans;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 2}, {3}, {3}, {}};
        System.out.println(new Solution797().allPathsSourceTarget(graph));
    }
}
