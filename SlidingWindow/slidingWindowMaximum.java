// Question link -> https://leetcode.com/problems/sliding-window-maximum/description/

// Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
// Output: [3,3,5,5,6,7]

// Approach - Sliding Window | TC - O(N)
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int i = 0;
        for(int j = 0; j < nums.length; j++){
            while(q.size() > 0 && q.peekLast() < nums[j]){
                q.removeLast();
            }
            q.add(nums[j]);
            if(j-i+1 == k){
                ans[i] = q.peek();
                if(nums[i] == q.peek()){
                    q.removeFirst();
                }
                i++;
            }
        }
        return ans;
    }
}

// Solution video -> https://www.youtube.com/watch?v=xFJXtB5vSmM
