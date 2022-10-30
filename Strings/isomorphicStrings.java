// Question link - https://leetcode.com/problems/isomorphic-strings/

// Two strings s and t are isomorphic if the characters in s can be replaced to get t.
// All occurrences of a character must be replaced with another character while preserving the order of characters. 
// No two characters may map to the same character, but a character may map to itself.
// Input: s = "paper", t = "title"    Output: true

// Approach3 -
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            char ch1 = s.charAt(i);
            char ch2 = t.charAt(i);
            if(map.containsKey(ch1)){
                if(map.get(ch1) == ch2){
                    continue;
                }else{
                    return false;
                }
            }else{
                if(!map.containsValue(ch2)){
                    map.put(ch1, ch2);
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}

// Approach2 -
/*
  int[] m = new int[512];
  for (int i = 0; i < s1.length(); i++) {
      if (m[s1.charAt(i)] != m[s2.charAt(i)+256]) return false;
      m[s1.charAt(i)] = m[s2.charAt(i)+256] = i+1;
  }
  return true;
*/

// Approach1 -
/*
    Map<Character, Integer> map1 = new HashMap<>();
    Map<Character, Integer> map2 = new HashMap<>();

    for(Integer i = 0; i < s.length(); i++) {
        if(map1.put(s.charAt(i), i) != map2.put(t.charAt(i), i))
        return false;
    }
    return true;
*/
/*
String 1:              A B E A C D B
index pattern:         0 1 2 0 4 5 1
String 2:              X Y I X H K Y
index pattern:         0 1 2 0 4 5 1
*/
