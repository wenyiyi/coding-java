package dp;
/*
https://leetcode.com/problems/coin-change/

Coin Change
Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.
You may assume that you have an infinite(无限的) number of each kind of coin.


Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

DP 规律
1. Can I break the problem into smaller subproblems?
2. Does the same subproblem appear multiple times?
3. Same state → same answer?
*/

import java.util.Arrays;


/*
todo问题：凑出 amount，最少需要多少枚硬币

DP四问
第一步：怎么定义dp[]
DP 第一件事就是把最终问题泛化：
凑出 11 最少需要几枚？
        ↓
凑出任意金额 i 最少需要几枚？
dp[i] = 凑出金额 i 最少需要的硬币数量
dp[0] = 凑 0 元最少几枚
dp[1] = 凑 1 元最少几枚
dp[2] = 凑 2 元最少几枚
...
dp[11] = 凑 11 元最少几枚

第二步：要得到dp[i]，最后一步怎么来
最后拿 1 元：
dp[i-1] + 1

最后拿 2 元：
dp[i-2] + 1

最后拿 5 元：
dp[i-5] + 1

dp[i] = min(dp[i], dp[i-coin]+1)

第三步：初始化状态
dp[0]=0 ✅
❌
dp[1] = 0
dp[2] = 0
dp[3] = 0
一个常见办法就是初始化成一个足够大的、不可能成为正确答案的数
如：假设有 1 元硬币，凑 amount 元 最多也只需 amount 枚硬币
dp[i] = amount + 1

第四步：return 什么
return dp[amount]

(该题特殊点：如果 dp[amount] == amount + 1
说明它从初始的“不可能值”开始，经过所有状态转移后依然没有被更新，即 amount 无法凑出。
return -1)
*/
class Solution322 {
    public int coinChange(int[] coins, int amount) {
        // 1 define dp[i] as the minimum number of coins needed to make amount i todo lenght=amount+1 new int[amount + 1]
        int[] dp = new int[amount + 1];
        int result = 0;

        // 2 initialize dp[0] and all states
        Arrays.fill(dp, amount + 1); // todo
        dp[0] = 0;// todo set dp[0] after  Arrays.fill


        // 3 how to get dp[i],find the last step
//        for (int i = 1; i <= amount; i++) {
//            for (int coin : coins) {
//                if (i >= coin) {
//                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
//                }
//            }
//        }
        // LC 322 Coin Change（最少硬币数）：先遍历 amount 或先遍历 coins，都可以。
        // LC 518 Coin Change II（组合数量）：必须先遍历 coins，再正向遍历 amount，才能避免重复计算不同顺序的相同组合。
        // todo foreach coins first
        for (int coin : coins) {
            for (int currAmount = coin; currAmount <= amount; currAmount++) {
                dp[currAmount] = Math.min(dp[currAmount], dp[currAmount - coin] + 1);
            }
        }


        if (dp[amount] == amount + 1) {
            return -1;
        }

        // 4 return
        return dp[amount];
    }

}
