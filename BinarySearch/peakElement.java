// Question - https://leetcode.com/problems/find-peak-element/
// A peak element is an element that is strictly greater than its neighbors.
// You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

// BS on Answer Concept - on unsorted arrays
// 2 Criteria -> a) mid is element or not b) left/right - which subarray to search

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 1 || nums[0] > nums[1]){    // Edge case
            return 0;
        }
        if(nums[n-1] > nums[n-2]){          // Edge case
            return n-1;
        }
        int lo = 1;
        int hi = n-2;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid-1] > nums[mid]){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        return -1;  // dummy return
    }
    /* What we are essentially doing is going in the direction of the rising slope(by choosing the element which is greater than current). 
       How does that guarantee the result? Think about it, there are 2 possibilities -
       a) rising slope has to keep rising till end of the array b) rising slope will encounter a lesser element and go down.
       In both scenarios, we will have an answer. As in
       a) the answer is the end element because we take the boundary as -INFINITY 
       b) the answer is the largest element before the slope falls.
    */
    
    
    /*  More simplified version
    if(nums.length == 1) return 0;
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        
        return left;
    */
}
