class Solution {
    public int missingNumber(int[] nums) {
        // Method2 - Using XOR
        // [3,0,1] - 3 ^ 0 ^ 0 ^ 1 ^ 1 ^ 2
        // Rearrange - 0 ^ 0 ^ 1 ^ 1 ^ 2 => 0 ^ 2 => 2
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res = res ^ i ^ nums[i]; // a^b^b = a
        }
        return res;
        
        /* Method1 - Using sum of first n numbers
        int n = nums.length;
        int sum = n*(n+1)/2;
        for(int num: nums){
            sum -= num;
        }
        return sum;
        */
    }
}
