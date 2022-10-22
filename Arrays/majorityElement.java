// Question link - https://leetcode.com/problems/majority-element/
// The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

// If no majority exists, return -1 is given in question then -
// Step1 - Find the potential candidate using Moore's Voting Algorithm
// Step2(extra step) - Check if occurrences of that candidate is greater than n/2 or not.

class Solution {
    public int majorityElement(int[] nums) {
        // Method 4 - Using Moore's Voting Algorithm || TC - O(n) || SC - O(1)
        int count = 0;
        int element = 0;
        for(int num: nums){
            if(count == 0){
                element = num;
            }
            if(element == num){
                count++;
            }
            else{
                count--;
            }
        }
        
        return element;
    }
    
    /* Method 3 - Using HashMap || TC - O(n) || SC - O(n)
    public int majorityElement(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int nc = map.get(nums[i]) + 1;
                map.put(nums[i], nc);
                if(nc > nums.length/2){
                    ans = nums[i];
                    break;
                }
            }else{
                map.put(nums[i], 1);
            }
        }
        return ans;
    }
    */
    
    /* Method 2 - Using Sorting || TC - O(nlogn)
    public int majorityElement1(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    */
    
    /* Method 1 - Brute Force || TC - O(n^2)
    public int majorityElement(int[] nums) {
        int ans = 0;
        for(int i = 0; i < nums.length - 1; i++){
            int count = 1;
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > nums.length/2){
                ans = nums[i];
                break;
            }
        }
        return ans;
    }
    */
}
