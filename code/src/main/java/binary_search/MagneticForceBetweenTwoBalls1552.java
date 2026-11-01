package binary_search;

import java.util.Arrays;

/*
* In the universe Earth C-137,
*
* Rick discovered a special form of magnetic force between two balls if they are put in his new invented basket.
* Rick has n empty baskets, the ith basket is at position[i],
* Morty has m balls and needs to distribute the balls into the baskets such
* that the minimum magnetic force between any two balls is maximum.
Rick stated that magnetic磁性 force between two different balls at positions x and y is |x - y|.

Given the integer array position and the integer m. Return the required force.
*
* Example 1:
* Input: position = [1,2,3,4,7], m = 3
Output: 3
Explanation: Distributing the 3 balls into baskets 1, 4 and 7 will make the magnetic force between ball pairs [3, 3, 6].
* The minimum c force is 3. We cannot achieve a larger minimum magnetic force than 3.

* Example 2:
Input: position = [5,4,3,2,1,1000000000], m = 2
Output: 999999999
Explanation: We can use baskets 1 and 1000000000.

* 把 3 个球放进 5 个篮子，使任意两个球之间的最小距离尽可能大
*
* */
public class MagneticForceBetweenTwoBalls1552 {

    // 给定最小距离 distance，判断能否放下 m 个球
    private boolean canPlace(int[] position, int m, int distance) {
        // 第一个球放在最左边，初始数量为1 the first ball placed in the leftmost basket.
        int count = 1;
        // 上一个球放在哪个位置 last placed ball
        int lastPosition = position[0];

        // Try to place the remaining balls from left to right.
        // 从左到右遍历剩余篮子，尝试放置其他球
        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPosition >= distance) {
                count++;
                lastPosition = position[i];
            }

            // Return true once all balls are placed
            if (count >= m) {
                return true;
            }
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        // Sort the basket positions
        Arrays.sort(position);

        int left = 1; // 最小候选距离 Minimum candidate distance.
        int right = position[position.length - 1] - position[0]; // 最大候选距离，Maximum candidate distance
        int result = 0;

        // Binary search for the maximum feasible distance
        while (left <= right) {
            // 当前尝试的距离
            int mid = left + (right - left) / 2;
            if (canPlace(position, m, mid)) {
                // Current distance is feasible; save it.
                // 当前距离可行，先记录这个答案
                result = mid;
                // Try a larger minimum distance.
                // 尝试更大的距离，因为目标是最大化最小距离。
                left = mid + 1;
            } else {
                // Current distance is too large; try a smaller one.
                // 当前距离不可行，缩小距离上界
                right = mid - 1;
            }
        }

        return result;
    }

}
