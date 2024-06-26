package hashing

/**
 * 930. Binary Subarrays With Sum
 *
 * Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.
 *
 * A subarray is a contiguous part of the array.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,0,1,0,1], goal = 2
 * Output: 4
 * Explanation: The 4 subarrays are bolded and underlined below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * Example 2:
 *
 * Input: nums = [0,0,0,0,0], goal = 0
 * Output: 15
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 3 * 104
 * nums[i] is either 0 or 1.
 * 0 <= goal <= nums.length
 */

class LC930BinarySubarraysWithSum {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {

        // We can use a hash table and prefix sum to keep track of the sum and the frequency of the sum
        // At each step, calculate the prefix sum, put it in the map, and increment the frequency of it
        // If the current sum is equal to the goal, increment the ans
        // If the difference between sum and goal is available in the map, we can include them as valid subarrays to the ans

        val map = mutableMapOf<Int, Int>()
        var sum = 0
        var ans = 0
        map[0] = 0

        for (num in nums) {
            sum += num

            if (sum == goal) ans++

            val diff = sum - goal
            if (map.contains(diff)) {
                ans += map[diff]!!
            }
            map[sum] = (map[sum] ?: 0) + 1
        }

        return ans
    }
}