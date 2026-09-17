package heap;

/*
* Given an integer array nums and an integer k, return the k most frequent elements.
* You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Example 3:
Input: nums = [1,2,1,2,1,2,3,1,3,2], k = 2
Output: [1,2]
*
* */

import java.util.*;

/*
 *  hashMap
 *  1-3
 *  2-2
 *  3-1
 *
 *  offer [1,3]
    Heap:
    [1,3]

    offer [2,2]
    Heap:
      [2,2]  ← frequency 最小，在堆顶
      /
   [1,3]

    offer [3,1]
    Heap:
       [3,1]  ← frequency 最小
      /     \
   [1,3]   [2,2]

size = 3 > k
↓
poll()
↓
删除 [3,1]
 *
 * 最小堆：堆顶是最小值
 * 最大堆：堆顶是最大值
 * 堆顶是淘汰口
 * 找 Top K 最大
    → 维护大小为 K 的 Min Heap
    → 超过 K 就踢掉最小的
    → 最后留下最大的 K 个

    找 Top K 最小
    → 维护大小为 K 的 Max Heap
    → 超过 K 就踢掉最大的
    → 最后留下最小的 K 个
    Top K largest → Min Heap；Top K smallest → Max Heap

nums
 ↓
HashMap 统计 frequency
 ↓
num → frequency
 ↓
Min Heap [num, frequency]
 ↓
始终维持 size <= k
 ↓
淘汰 frequency 最小的
 ↓
剩下 Top K
*
*
* Time  O(n log k) ← k 是 Top K
  Space O(n)
 *
 * */
public class top_k_frequent_elements_347 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            // 如果 key 存在就拿 value；不存在就返回默认值 0
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        // 最小堆，按照 int[] 的第二个元素 pair[1] 比较
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        numMap.forEach((key, value) -> {
            int[] pair = new int[]{key, value};
            minHeap.offer(pair);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        });

        // 需要输出的是元素，而不是次数
        int[] result = new int[k];
        int i;
        for (i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(minHeap.poll())[0];
        }
        return result;
    }

}
