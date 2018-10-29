package indi.ours.algorithm.leetcode.algorithms;

/**
 * @author wangheng
 * @create 2018-10-29 下午4:02
 * @desc
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 *
 *
 *
 *
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 *
 *
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * 7*（8-1 ）
 *
 * 以数组的额 值 为 高度
 * 以 数组的下标为宽度
 * 求出 区间容量的 值
 **/
public class _11 {

    /**
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int L = height.length, lo = 0, hi = L-1;
        int max = 0;
        while(lo<hi) {
            int loMax = height[lo], hiMax = height[hi];

            int candidate = (hi-lo) * (loMax<hiMax ? loMax : hiMax);
            max = candidate > max ? candidate : max;

            if(height[lo]<=height[hi])
                while(lo<hi && height[lo]<=loMax) ++lo;
            else
                while(hi>lo && height[hi]<=hiMax) --hi;
        }
        return max;

    }
}
