package heap;

import java.util.Collections;
import java.util.PriorityQueue;

/*
*https://leetcode.com/problems/last-stone-weight/?utm_source=chatgpt.com
*
* Last Stone(石头) Weight
* You are given an array of integers stones where stones[i] is the weight of the ith stone.
We are playing a game with the stones. On each turn,
* we choose the heaviest two stones and smash(粉碎) them together.
* Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:
If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.
Return the weight of the last remaining stone. If there are no stones left, return 0.



Example 1:
Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.

Example 2:
Input: stones = [1]
Output: 1
* */
class LastStoneWeight1046 {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 最大堆
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() >= 2) { // 保证第二个数有值
            int firstNum = maxHeap.poll();
            int secondNum = maxHeap.poll();
            if (firstNum != secondNum) {
                // 两块石头相撞后的结果要重新放回 heap
                maxHeap.offer(firstNum - secondNum);
            }
        }
        if (maxHeap.isEmpty()) {
            return 0;
        }
        return maxHeap.peek();
    }
}
