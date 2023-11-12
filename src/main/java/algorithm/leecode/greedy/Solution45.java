package algorithm.leecode.greedy;

public class Solution45 {

    // 贪心
    // 用farthestIndex记录每次遍历理论能达到的最远的索引位置
    // 当索引已经达到必须要跳跃的时候(i == currIndex)
    // 此时跳跃次数+1,并且将currIndex重置为下次跳跃的起始点(farthestIndex)
    public static int jumpGame(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int farthestIndex = 0; // 表示每一跳能到的最远的索引
        int currIndex = 0;     // 需要跳跃的最后索引位置
        int steps = 0;         // 记录跳动次数
        for (int i = 0; i < nums.length; i++) {
            farthestIndex = Math.max(nums[i] + i, farthestIndex);
            if (i == currIndex) {
                steps++;
                currIndex = farthestIndex;
                if (farthestIndex >= nums.length - 1) break;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(jumpGame(nums));
    }

}
