// Question link -> https://leetcode.com/problems/largest-rectangle-in-histogram/

class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nseR = new int[heights.length];
        int[] nseL = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < heights.length; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            nseL[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st = new Stack<>();
        for(int i = heights.length-1; i >= 0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            nseR[i] = st.isEmpty() ? heights.length : st.peek();
            st.push(i);
        }
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int area = heights[i] * (nseR[i]-nseL[i]-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

/*
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i <= n; i++){
            int currHeight = i == n ? 0 : heights[i];
            while(!st.isEmpty() && currHeight < heights[st.peek()]){
                int top = st.pop();
                int width = st.isEmpty() ? i : i - st.peek() - 1;
                int area = heights[top] * width;
                maxArea = Math.max(area, maxArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}
*/
// Explanation -> https://leetcode.com/problems/largest-rectangle-in-histogram/discuss/1727776/JavaC%2B%2B-Explanation-going-from-Brute-to-Optimal-Approach
