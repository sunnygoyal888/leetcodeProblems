// Question => https://leetcode.com/problems/median-of-two-sorted-arrays/

// Optimal Approach || TC - O(log(min(n1,n2))) || SC - O(1)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        
        int medianPos = (n1 + n2 +1)/2;
        while(low <= high){
            int cut1 = (low+high)/2;
            int cut2 = medianPos - cut1;
            
            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1-1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2-1];
            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];
            
            if(l1 <= r2 && l2 <= r1){
                if((n1+n2)%2 != 0){
                    return Math.max(l1,l2);
                }else{
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }
            }else if(l1 > r2){
                high = cut1 - 1;
            }else{
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
}

// Solution => https://takeuforward.org/data-structure/median-of-two-sorted-arrays-of-different-sizes/
