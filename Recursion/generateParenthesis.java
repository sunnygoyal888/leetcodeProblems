// Queston link - https://leetcode.com/problems/generate-parentheses/
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        int open = n;
        int close = n;
        solve(open, close, "", res);
        return res;
    }
    
    public void solve(int open, int close, String output, List<String> res){
        if(open == 0 && close == 0){
            res.add(output);
            return;
        }
        
        if(open != 0){
            solve(open-1, close, output + "(", res);
        }
        if(close > open){
            solve(open, close-1, output + ")", res);
        }
    }
}

// T.C = O(2^n * n)
