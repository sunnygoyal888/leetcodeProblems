// Question link -> https://leetcode.com/problems/binary-subarrays-with-sum/description/

// Given a binary array nums and an integer goal, return the number of non-empty subarrays with a sum goal.

// Input: nums = [1,0,1,0,1], goal = 2      Output: 4
// Input: nums = [0,0,0,0,0], goal = 0      Output: 15

class Solution {
    // Approach 3 -> Sliding Window | TC - O(N)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMostSubarraysWithSum(nums, goal) - atMostSubarraysWithSum(nums, goal-1);
    }

    public int atMostSubarraysWithSum(int[] nums, int goal){
        if(goal < 0)    return 0;
        int count  = 0;
        int sum = 0;
        int i = 0, j = 0;
        while(j < nums.length){
            sum += nums[j];
            while(sum > goal){
                sum -= nums[i++];
            }
            count += (j-i+1);
            j++;
        }
        return count;
    }
}
// Explanation -> https://leetcode.com/problems/binary-subarrays-with-sum/solutions/2866679/easy-and-detailed-sliding-window-approach-at-most-method-detailed-explanation-c-o-n/?orderBy=most_votes

/* Approach 2 -> Using HashMap | TC - O(N) | SC - O(N)
public int numSubarraysWithSum(int[] nums, int goal) {
    int count = 0;
    int sum = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0,1);
    for(int num: nums){
        sum += num;
        if(map.containsKey(sum - goal)){
            count += map.get(sum-goal);
        }
        map.put(sum, map.getOrDefault(sum,0) + 1);
    }
    return count;
}
*/

/* Approach 1 -> Brute Force | TC - O(N^2)
public int numSubarraysWithSum(int[] nums, int goal) {
    int count = 0;
    for(int i = 0; i < nums.length; i++){
        int sum = 0;
        for(int j = i; j < nums.length; j++){
            sum += nums[j];
            if(sum == goal){
                count++;
            }
            if(sum > goal){
                break;
            }
        }
    }
    return count;
}
*/
