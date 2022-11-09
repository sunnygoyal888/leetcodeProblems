// Queston link - https://leetcode.com/problems/powx-n/
// Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
// Input: x = 2.10000, n = 3      Output: 9.26100
// Input: x = 2.00000, n = -2     Output: 0.25000

class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 1/x * myPow(1/x, -(n+1));    // +1 to avoid overflow
        }
        return (n % 2 == 0) ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
    }
}


// Modified Question
// GFG Question - Power of Numbers
// Given a number and its reverse. Find that number raised to the power of its own reverse.
// Note: As answers can be very large, print the result modulo 10^9 + 7.
// Input: N = 12    Output: 864354781
// Explanation: The reverse of 12 is 21 and 1221 , when divided by 1000000007 gives remainder as 864354781.

class Solution{
    
    long power(int N,int R){
        if(R == 0){
            return 1;
        }
        long res = power(N, R/2) % 1000000007;
        res = (res * res) % 1000000007;
        if(R%2 == 0){
            return res;
        }else{
            return (N*res) % 1000000007;
        }
    }
}
