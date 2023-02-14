// Question link -> https://leetcode.com/problems/subarray-sum-equals-k/description/

// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
// Input: nums = [1,2,3], k = 3
// Output: 2

// Solution video -> https://www.youtube.com/watch?v=20v8zSo2v18

class Solution {
    // Approach 2 - Using HashMap || TC = O(n)
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum,0) + 1);
        }
        
        return count;
    }
    
    // Approach 1 - Brute Force || TC = O(n^2)
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(sum == k){
                    count++;
                }
            }
        }
        
        return count;
    }
}
