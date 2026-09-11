package heap;

/*
https://leetcode.com/problems/kth-largest-element-in-an-array/?utm_source=chatgpt.com

Kth Largest Element in an Array
*Given an integer array nums and an integer k, return the kth largest element in the array.
Note that it is the kth largest element in the sorted order, not the kth distinct element.
Can you solve it without sorting?

Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4

Constraints:
1 <= k <= nums.length <= 105
-104 <= nums[i] <= 104
*
* */

import java.util.PriorityQueue;

/*
 * offer(x)	添加元素	push
   poll()	删除并返回堆顶	pop
   peek()	查看堆顶，不删除	top
   size()	元素数量	size
   isEmpty()	是否为空	empty
 *
 * */
public class KthLargestElement215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0) {
            return 0;
        }
        // heap.offer(5);
        // heap.offer(2);
        // heap.offer(6);
        // heap.offer(3);
        //System.out.println(heap.peek()); // 2 小的优先出来
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 默认最小堆

        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                // 删除并返回堆顶
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
