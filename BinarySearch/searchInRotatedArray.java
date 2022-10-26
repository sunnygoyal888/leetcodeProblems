// Question - https://leetcode.com/problems/search-in-rotated-sorted-array/

// Intuition - For any index there exists one sorted and one unsorted subarray i.e. There is at least one segment (left or right part) is monotonically increasing.
/* Steps -
1) Check which part is sorted (left or right part) i.e. Check whether pivot(or min) is on left side or right side of pivot.
2) Check target element lies in which part & drop the other part.
3) Perform BS on that part.
*/

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid] == target){
                return mid;
            }
          //if left part is monotonically increasing, or the pivot point is on the right part
            else if(nums[lo] <= nums[mid]){
                if(target >= nums[lo] && target < nums[mid]){     //must use "<=" at here to make sure target is in the left part
                    hi = mid - 1;
                }else{
                    lo = mid + 1;
                }
            }
          //if right part is monotonically increasing, or the pivot point is on the left part
          else{
                if(target <= nums[hi] && target > nums[mid]){
                    lo = mid + 1;
                }else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}

// Another Approach
/*
Since array is rotated it means both left part & right part of min element are sorted. So find index of min element in array. 
Then search for the element in both part using BS. Return index if found else return -1.
index = minIndex(arr,0,n-1,key)
left = BS(arr,0,index-1,key)
right = BS(arr,index,n-1,key)
*/
