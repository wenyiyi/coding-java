package hashmap;

/*
 *https://leetcode.com/problems/two-sum/
 *
 * Input: nums = [2,7,11,15], target = 9   Output: [0,1]
 * The sum of nums[0] and nums[1] is 2 + 7 = 9,
 * which equals the target. Therefore, the indices [0, 1] are returned.
 *
 * Only one valid answer exists.
 *
 * 无序：hashmap
 * 有序：两个指针
 *
 * 遍历当前数字 num
 * 计算 complement = target - num
 *
 * HashMap 里有没有 complement？
    ├── 有 → 返回两个下标
    └── 没有 → 存入当前 num 和下标
 * get()
 * put()
 * containsKey()
 * remove()
 * size()
 * getOrDefault()
 * */

import java.util.HashMap;

public class TwoSum01 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }

            numMap.put(complement, i);
        }
        return new int[]{};
    }
}
