// Question link -> https://leetcode.com/problems/sum-of-subarray-minimums/description/

// Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. 
// Since the answer may be large, return the answer modulo 109 + 7.

// Input: arr = [3,1,2,4]         Output: 17
// Explanation: 
// Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
// Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
// Sum is 17.


// All 3 approaches explanation -> https://leetcode.com/problems/sum-of-subarray-minimums/solutions/2700011/sum-of-subarray-minimums/?orderBy=most_votes

class Solution {
  /* Approach 1 -> Brute Force || TC - O(n^2)
    public int sumSubarrayMins(int[] arr) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            int min = arr[i];
            for(int j = i; j < arr.length; j++){
                min = Math.min(min, arr[j]);
                sum = (sum+min) % (1000000007);
            }
        }
        return sum;
    }
    */
  
  // Approach 2 -> Using Next Smaller Element to Left and Right
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nseL[] = new int[n];
        int nseR[] = new int[n];
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            nseL[i] = st.isEmpty() ? i+1 : i-st.peek();
            st.push(i);
        }

        while(!st.isEmpty())    st.pop();

        for(int i = n-1; i >= 0; i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            nseR[i] = st.isEmpty() ? n-i : st.peek()-i;
            st.push(i);
        }

        long sum = 0;
        for(int i = 0; i < n; i++){
            long count = (nseL[i] * nseR[i]) % 1000000007;
            sum += (arr[i] * count) % 1000000007;
            sum = sum % 1000000007;
        }

        return (int)sum;
    }
  
    /* Approach 3 -> Using DP || TC - O(n)
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int[] dp = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.size() > 0){
                int prevSmaller = st.peek();
                dp[i] = dp[prevSmaller] + (i - prevSmaller) * arr[i];
            }else{
                dp[i] = (i+1) * arr[i];
            }
            st.push(i);
        }

        long sum = 0;
        for(int num: dp){
            sum += num;
            sum %= 1000000007;
        }
        return (int)sum;
    }
    */
}
