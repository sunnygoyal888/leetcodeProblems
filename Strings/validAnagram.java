// Question link - https://leetcode.com/problems/valid-anagram/
// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
// Input: s = "anagram", t = "nagaram"    Output: true
// Input: s = "rat", t = "car"            Output: false

// Approach2 - Using freq array || TC - O(n)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())    return false;
        int[] freq = new int[26];
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int val: freq){
            if(val != 0){
                return false;
            }
        }
        return true;
    }
}

// Approach1 - Sort Both Strings and compare each character || TC - O(nlogn)


// If Question says input contains Unicode characters then
/*
public boolean isAnagram(String s, String t) {
    if(s.length() != t.length())    return false;
    HashMap<Character, Integer> map = new HashMap<>();
    for(int i = 0; i < s.length(); i++){
        char ch1 = s.charAt(i);
        char ch2 = t.charAt(i);
        if(map.containsKey(ch1)){
            map.put(ch1, map.get(ch1)+1);
        }else{
            map.put(ch1, 1);
        }
        if(map.containsKey(ch2)){
            map.put(ch2, map.get(ch2)+1);
        }else{
            map.put(ch2, 1);
        }
    }

    for(int val: map.values()){
        if(val % 2 != 0){
            return false;
        }
    }
    return true;
}
*/
