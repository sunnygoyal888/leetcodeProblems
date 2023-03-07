// Question link -> https://leetcode.com/problems/subarrays-with-k-different-integers/description/

// Given an integer array nums and an integer k, return the number of good subarrays of nums.
// A good array is an array where the number of different integers in that array is exactly k.
/*
Input: nums = [1,2,1,2,3], k = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2]
*/

class Solution {
    // Approach 2 -> Sliding Window | TC - O(N) | SC - O(N)
    // exactly(K) = atMost(K) - atMost(K-1)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k-1);
    }

    public int atMost(int[] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            while(map.size() > k){
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            count += (j-i+1);
        }
        return count;
    }
}

/* Approach 1 -> Brute Force | TC - O(N^2) | SC - O(N)
public int subarraysWithKDistinct(int[] nums, int k) {
    int ans = 0;
    for(int i = 0; i < nums.length; i++){
        HashSet<Integer> set = new HashSet<>();
        for(int j = i; j < nums.length; j++){
            set.add(nums[j]);
            if(set.size() > k){
                break;
            }
            if(set.size() == k){
                ans++;
            }
        }
    }
    return ans;
}
*/
