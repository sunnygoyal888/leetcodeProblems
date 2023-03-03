// Question link -> https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

// Given a word pat and a text txt. Return the count of the occurences of anagrams of the word in the text.

// Input: txt = forxxorfxdofr     pat = for
// Output: 3
// Explanation: for, orf and ofr appearsin the txt, hence answer is 3.

// Input: txt = aabaabaa        pat = aaba
// Output: 4

class Solution {
    // Approach - Sliding Window | TC - O(N)
    int search(String pat, String txt) {
        // code here
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: pat.toCharArray()){
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)+1);
            }else{
                map.put(ch, 1);
            }
        }
        
        int count = map.size();
        int i = 0;
        int j = 0;
        
        while(j < txt.length()){
            char ch = txt.charAt(j);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0){
                    count--;
                }
            }
            if(j-i+1 == pat.length()){
                if(count == 0){
                    ans++;
                }
                char ch2 = txt.charAt(i);
                if(map.containsKey(ch2)){
                    map.put(ch2, map.get(ch2)+1);
                    if(map.get(ch2) == 1){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }
}

// Solution video -> https://www.youtube.com/watch?v=MW4lJ8Y0xXk
