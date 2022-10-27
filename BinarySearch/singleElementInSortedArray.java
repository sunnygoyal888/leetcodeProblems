// Input: nums = [1,1,2,3,3,4,4,8,8]        Output: 2

/*
Intuition -
Observe that for each pair, first element takes even position and second element takes odd position.
eg. 1 is appeared as a pair, so it takes 0 and 1 positions. similarly for all the pairs also.
This pattern will be missed(or reversed) when single element is appeared in the array.

So, left part of single element will follow pattern(even-odd) and right part will follow opposite pattern(odd-even).

From above points, we can implement algorithm.
1) Take left and right pointers.
2) Find mid.
   a) If mid is even, then it's duplicate should be in next index OR if mid is odd, then it's duplicate should be in previous index.
	 b) Check these two conditions, if any of the conditions is satisfied, then pattern is not missed -> check in next half of the array. i.e, left = mid + 1
   c) If condition is not satisfied, then the pattern is missed. so, single number must be before mid. i.e, right = mid
3. At last return the nums[left]
*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 != 0 && nums[mid] == nums[mid-1])){
                lo = mid + 1;
            }else{
                hi = mid;
            }
        }
        return nums[lo];
    }
}

// if((mid%2==0 && nums[mid]==nums[mid+1]) || (mid%2!=0 && nums[mid]==nums[mid-1]))
// this condition can also be written as
// if(nums[mid] == nums[mid^1])
// even ^ 1 = odd(even+1) and odd ^ 1 = even(odd-1)
