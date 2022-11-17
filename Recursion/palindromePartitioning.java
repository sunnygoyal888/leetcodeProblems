// Question link - https://leetcode.com/problems/palindrome-partitioning/
// Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> ds = new ArrayList<>();
        solve(0, s, ds, res);
        return res;
    }
    
    public void solve(int idx, String s, List<String> ds, List<List<String>> res){
        if(idx == s.length()){
            res.add(new ArrayList<>(ds));
            return;
        }
      // Partition
        for(int i = idx; i < s.length(); i++){
            if(isPalindrome(s, idx, i)){  // what we are checking over here is, if we partition the string from index to i Example-(0, 0) is palindrome or not
                ds.add(s.substring(idx,i+1)); // take the substring and store it in our list & call the next substring from index + 1
                solve(i+1, s, ds, res); // as we have done for (0, 0) then our next will be from (1)
                ds.remove(ds.size()-1); // please make sure you remove when you backtrack
                // Why? Because let say i had partion y, so when i go back. I can't have yy
            }
        }
    }
    
    public boolean isPalindrome(String s, int lo, int hi){
        while(lo < hi){
            if(s.charAt(lo++) != s.charAt(hi--))
                return false;
        }
        return true;
    }
}

// TC - O(N*2^N)
