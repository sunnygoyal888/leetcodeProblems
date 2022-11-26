// You are given a number N. Find the total count of set bits for all numbers from 1 to N(both inclusive).
/*
Input: N = 4
Output: 5
Explanation:
For numbers from 1 to 4.
For 1: 0 0 1 = 1 set bits
For 2: 0 1 0 = 1 set bits
For 3: 0 1 1 = 2 set bits
For 4: 1 0 0 = 1 set bits
Therefore, the total set bits is 5.
*/

// Detailed Explanation -> https://www.youtube.com/watch?v=g6OxU-hRGtY

class Solution{
  public static int countSetBits(int n){
      if(n == 0)  return 0;
      int x = powerOfTwo(n);
      int bits_till2x = x * (1 << (x-1));
      int msb2xton = n - (1 << x) + 1;
      int rest = n - (1 << x);
      int ans = bits_till2x + msb2xton + countSetBits(rest);
      return ans;
  }
  
  public static int powerOfTwo(int n){
      int x = 0;
      while((1 << x) <= n){
          x++;
      }
      return x-1;
  }
}


// Same logic as above but shorter code
/*
class Solution{
  public static int countSetBits(int n){
    if(n <= 1)  return n;
    int x = (int)(Math.log(n) / Math.log(2));
    return (x*(1<<(x-1))) + (n-(1<<x)+1) + countSetBits(n-(1<<x));
  }
}
*/
