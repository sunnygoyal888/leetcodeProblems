// Question link - https://leetcode.com/problems/count-good-numbers/
// A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
// For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime. 
// However, "3245" is not good because 3 is at an even index but is not even.
// Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
// Input: n = 4       Output: 400       Explanation: 5 * 4 * 5 * 4

class Solution {
    public int countGoodNumbers(long n) {
        long mod = (int)1e9+7;
        return (int)(power(5,(n+1)/2,mod) * power(4,n/2,mod) % mod);
    }
    
    public long power(int x, long n, long mod){
        if(n == 0){
            return 1;
        }
        long temp = power(x, n/2, mod);
        temp = (temp * temp) % mod;
        return n % 2 == 0 ? temp : (x*temp)%mod;
    }
}
