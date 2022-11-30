// Question link -> https://leetcode.com/problems/next-greater-element-ii/
/*
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. 
If it doesn't exist, return -1 for this number.
*/
// Input: nums = [1,2,1]      Output: [2,-1,2]

// Approach -> First store all elements of array in stack & then do normal NGE1 | TC - O(n)
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        for(int i = nums.length-1; i >= 0; i--){
            st.push(nums[i]);
        }
        
        for(int i = nums.length-1; i >= 0; i--){
            int num = nums[i];
            while(!st.isEmpty() && st.peek() <= nums[i]){
                st.pop();
            }
            nums[i] = st.isEmpty() ? -1 : st.peek();
            st.push(num);
        }
        return nums;
    }
}

// Approach - Loop twice
/*
public int[] nextGreaterElements(int[] nums) {
    int n = nums.length, res[] = new int[n];
    Arrays.fill(res, -1);
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n * 2; i++) {
        while (!st.isEmpty() && nums[st.peek()] < nums[i % n])
            res[st.pop()] = nums[i % n];
        st.push(i%n);
    }
    return res;
}
*/

// Approach - Brute Force | TC - O(n^2)
/*
public int[] nextGreaterElements(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];

    for (int i = 0; i < n; i++) {
        ans[i] = -1;

        for (int j = 0; j < n; j++) {
            if (nums[(i + j) % n] > nums[i]) {
                ans[i] = nums[(i + j) % n];
                break;
            }
        }
    }

    return ans;
}
*/
