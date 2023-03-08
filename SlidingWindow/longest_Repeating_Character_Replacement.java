// Question link -> https://leetcode.com/problems/longest-repeating-character-replacement/description/

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.
Input: s = "ABAB", k = 2
Output: 4
Input: s = "AABABBA", k = 1
Output: 4
*/

class Solution {
    // Approach 2 -> Sliding Window | TC - O(N)
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 0;
        int maxi = 0;
        int i = 0;
        int j = 0;
        while(j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxi = Math.max(maxi, map.get(ch));
            while(j-i+1 - maxi > k){
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                if(map.get(s.charAt(i)) == 0){
                    map.remove(s.charAt(i));
                }
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}

/* Approach 1 -> Brute Force | TC - O(N^2)
public int characterReplacement(String s, int k) {
    int max = 0;
    for(int i = 0; i < s.length(); i++){
        int count = 0;
        char ch = s.charAt(i);
        int j = i;
        while(j < s.length()){
            if(s.charAt(j) != ch){
                count++;
            }
            if(count > k){
                break;
            }
            j++;
        }
        max = Math.max(max, j-i);
    }
    return max;
}
*/
