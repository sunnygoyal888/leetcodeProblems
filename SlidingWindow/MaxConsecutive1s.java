// Question link -> https://leetcode.com/problems/max-consecutive-ones-iii/description/
// Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
// Output: 6

// Approach 3
public int longestOnes(int[] nums, int k){
    int i = 0;
    int j;
    for(j = 0; j < nums.length; j++){
        if(nums[j] == 0)    k--;
        if(k < 0 && nums[i++] == 0){
            k++;
        }
    }
    return j - i;
}

// Approach 2
public int longestOnes(int[] nums, int k){
    int i = 0;
    int numzeros = 0;
    int ans = 0;
    for(int j = 0; j < nums.length; j++){
        if(nums[j] == 0)    numzeros++;
        if(numzeros > k){
            if(nums[i] == 0) numzeros--;
            i++;
        }
        if(numzeros <= k){
            ans = Math.max(ans, j-i+1);
        }
    }
    return ans;
}

/* Approach 1
  public int longestOnes(int[] nums, int k) {
      int left = 0;
      int count = 0;
      int ans = 0;
      for(int right = 0; right < nums.length; right++){
          if(nums[right] == 0)    count++;
          while(count > k){
              if(nums[left] == 0){
                  count--;
              }
              left++;
          }
          ans = Math.max(ans, right-left+1);
      }
      return ans;
  }
*/
