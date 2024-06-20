// Question link -> https://leetcode.com/problems/minimum-window-substring/

/*
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. 
If there is no such substring, return the empty string "".
Example 1:
Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
*/

// Approach - Sliding Window | TC - O(N) | SC - O(t)
class Solution {
    public String minWindow(String s, String t) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        int minlen = Integer.MAX_VALUE;
        String ans = "";
        int count = map.size();
        int i = 0;
        for(int j = 0; j < s.length(); j++){
            if(map.containsKey(s.charAt(j))){
                map.put(s.charAt(j), map.get(s.charAt(j))-1);
                if(map.get(s.charAt(j)) == 0){
                    count--;
                }
            }
            while(count == 0){
                if(j-i+1 < minlen){
                    minlen = j-i+1;
                    ans = s.substring(i,j+1);
                }
                if(map.containsKey(s.charAt(i))){
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);
                    if(map.get(s.charAt(i)) == 1){
                        count++;
                    }
                }
                i++;
            }
        }

        return ans;
    }
}

// Solution Video => https://www.youtube.com/watch?v=iwv1llyN6mo
