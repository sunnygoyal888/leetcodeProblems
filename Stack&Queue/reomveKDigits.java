// Question link -> https://leetcode.com/problems/remove-k-digits/description/
// Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer after removing k digits from num.
// Input: num = "1432219", k = 3        Output: "1219"
// Input: num = "10200", k = 1          Output: "200"

class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()){
            return "0";
        }
        Stack<Character> st = new Stack<>();
        for(char ch: num.toCharArray()){
            while(k > 0 && !st.isEmpty() && st.peek() > ch){
                k--;
                st.pop();
            }
            st.push(ch);
            // Removing leading zeros
            if(st.size() == 1 && ch == '0'){
                st.pop();
            }
        }
        // handle edge cases
        // eg. 1234 -> k != 0 as inc order so pop last k elements
        while(k > 0 && !st.isEmpty()){
            k--;
            st.pop();
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.append(st.pop());
        }
        if(res.length() == 0){
            return "0";
        }
        return res.reverse().toString();
    }
}
