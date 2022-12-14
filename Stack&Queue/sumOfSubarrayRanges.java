// Question link -> https://leetcode.com/problems/sum-of-subarray-ranges/description/
// You are given an integer array nums. The range of a subarray of nums is the difference between the largest and smallest element in the subarray.
// Return the sum of all subarray ranges of nums.
// Input: nums = [4,-2,-3,4,1]
// Output: 59

class Solution {
    // Aproach 2 -> Using Monotonic Stack | TC - O(n)
    public long subArrayRanges(int[] nums) {
        Stack<Integer> st = new Stack<>();
        long sum = 0;
        // Add subarray maximums to the global sum
        for(int i = 0; i <= nums.length; i++){
            while(!st.isEmpty() && (i == nums.length || nums[st.peek()] < nums[i])){
                int currMax = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                sum += (long)(currMax-left)*(right-currMax)*nums[currMax];
            }
            st.push(i);
        }

        st.clear();
        // Subtract subarray minimum from the global sum
        for(int i = 0; i <= nums.length; i++){
            while(!st.isEmpty() && (i == nums.length || nums[st.peek()] > nums[i])){
                int currMin = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                int right = i;
                sum -= (long)(currMin-left)*(right-currMin)*nums[currMin];
            }
            st.push(i);
        }

        return sum;
    }
    /* Approach 1 -> Brute Force | TC - O(n^2)
    public long subArrayRanges(int[] nums) {
        long sum = 0;
        for(int i = 0; i < nums.length-1; i++){
            int min = nums[i];
            int max = nums[i];
            for(int j = i+1; j < nums.length; j++){
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                sum += max - min;
            }
        }
        return sum;
    }
    */
}
