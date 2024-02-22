package algorithm.leecode.greedy;

/**
 * 买卖股票最佳时机
 * 输入：prices = [7,1,5,3,6,4]
 * 输出：7
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
 * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
 * 总利润为 4 + 3 = 7 。
 */
public class Solution122 {

    // 贪心
    public int maxProfit(int[] prices) {
        int sum = 0;
        if (prices.length <= 1) {
            return sum;
        }
        for (int i = prices.length - 1; i >= 1; --i) {
            sum += Math.max(0, prices[i] - prices[i - 1]);
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Solution122().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(new Solution122().maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // 动态规划
    public int maxProfit2(int[] prices) {
        int len = prices.length;
        if (prices.length <= 1) {
            return 0;
        }
        // dp数组记录最大利润
        int[][] dp = new int[len][2];
        // 第一个下标表示第几天
        // 第二个下标0表示持有现金 2表示持有股票
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 持有现金利润 = max(继续持有, 股票换现金加钱)
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            // 持有股票利润 = max(继续持有, 现金换股票扣钱)
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[len - 1][0];
    }

}
