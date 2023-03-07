// Question link -> https://leetcode.com/problems/count-number-of-nice-subarrays/description/

// Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.

// Input: nums = [1,1,2,1,1], k = 3
// Output: 2
// Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

// Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
// Output: 16


class Solution {
    // Approach 3 -> Sliding Window | TC - O(N) | SC - O(1)
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostKSubarrays(nums, k) - atMostKSubarrays(nums, k-1);
    }

    public int atMostKSubarrays(int[] nums, int k){
        if(k < 0)   return 0;
        int count = 0;
        int odds = 0;
        int i = 0, j = 0;
        while(j < nums.length){
            if(nums[j] % 2 != 0){
                odds++;
            }
            while(odds > k){
                if(nums[i] % 2 != 0){
                    odds--;
                }
                i++;
            }
            count += (j-i+1);
            j++;
        }
        return count;
    }
}

/* Approach 2 -> Using HashMap | Transformed into Subarrays Sum Equals K problem | TC - O(N) | SC - O(N)
public int numberOfSubarrays(int[] nums, int k) {
    int count = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    map.put(0,1);
    int sum = 0;
    for(int num: nums){
        sum += (num % 2);   // Take even num as 0 & odd as 1
        if(map.containsKey(sum - k)){
            count += map.get(sum - k);
        }
        map.put(sum, map.getOrDefault(sum,0)+1);
    }
    return count;
}
*/

/* Approach 1 -> Brute Force | TC - O(N^2) | SC - O(1)
public int numberOfSubarrays(int[] nums, int k) {
    int count = 0;
    for(int i = 0; i < nums.length; i++){
        int odds = 0;
        for(int j = i; j < nums.length; j++){
            if(nums[j] % 2 != 0){
                odds++;
            }
            if(odds == k){
                count++;
            }
            if(odds > k){
                break;
            }
        }
    }
    return count;
}
*/
