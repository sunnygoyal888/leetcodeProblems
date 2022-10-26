// Question link - https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Input: nums = [3,4,5,1,2]
// Output: 1

class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        while(lo < hi){
            if(nums[lo] < nums[hi]){    // in case array is already sorted or answer lies in sorted part
                return nums[lo];
            }
            int mid = lo + (hi-lo)/2;
            if(nums[mid] < nums[hi]){
                hi = mid;           // we don't use hi = mid-1 here as if mid is min element then it will skip it
            }else{
                lo = mid + 1;
            }
        }
        return nums[lo];
    }
}

// Another Approach
/*
int start = 0, end = n-1;
while(start <= end){
    if(arr[start] <= arr[end]){
        return start;
    }
    int mid = start + (end-start)/2;
    int prev = (mid+n-1)%n;
    int next = (mid+1)%n;
    if(arr[mid] <= arr[next] && arr[mid] <= arr[prev]){
        return mid;
    }else if(arr[mid] <= arr[end]){
        end = mid - 1;
    }else{
        start = mid + 1;
    }
}
return 0;
*/
