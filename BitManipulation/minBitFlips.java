// Question link - https://leetcode.com/problems/minimum-bit-flips-to-convert-number/

// Given two integers start and goal, return the minimum number of bit flips to convert start to goal.
// Input: start = 10, goal = 7
// Output: 3

// Appraoch 3 -> Using Brian Kernighan's Algorithm || TC - O(logn)
class Solution {
    public int minBitFlips(int start, int goal) {
        int x = start^goal;   // xor will give bits which are different in start & goal
      
        // Count no of set bits in x using Brian Kernighan's Algo
        int count = 0;
        while(x != 0){
            x = x & (x-1);
            count++;
        }
        return count;
    }
}

// Approach 2 -> Using Java in-built function || TC - O(1)
/*
public int minBitFlips(int start, int goal) {
  return Integer.bitCount(start^goal);
}
*/

// Approach 1 -> Brute Force || TC - O(n)
