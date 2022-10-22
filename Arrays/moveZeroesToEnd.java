class Solution {
    public void moveZeroes(int[] nums) {
      // Approach2 - Fill non-zero elements first then -> fill zero at remaining places
        int pos = 0;
        for(int num: nums){
            if(num != 0){
                nums[pos++] = num;
            }
        }
        for(int i = pos; i < nums.length; i++){
            nums[i] = 0;
        }
        
        /* Approach1 - Two pointers | Swapping
        int j = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        } */
    }
}
