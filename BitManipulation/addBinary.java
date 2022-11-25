// Given two binary strings a and b, return their sum as a binary string.

// Input: a = "1010", b = "1011"
// Output: "10101"

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while(i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0)   sum += a.charAt(i--) - '0';
            if(j >= 0)   sum += b.charAt(j--) - '0';
            carry = sum > 1 ? 1 : 0;
            sb.append(sum % 2);
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

/* 
For detailed explanation -
https://leetcode.com/problems/add-binary/discuss/1679423/Well-Detailed-Explaination-Java-C%2B%2B-Python-oror-Easy-for-mind-to-Accept-it
*/
