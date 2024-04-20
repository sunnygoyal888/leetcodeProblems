// Question link => https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

// Similar Problems => Koko Eating Bananas | Minimum days to make M bouquets | Find the smallest Divisor | Split array - Largest Sum

// Optimal Approach | TC - O(nlogn) | SC - O(1)
class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int w: weights){
            lo = Math.max(lo, w);
            hi += w;
        }
        
        while(lo < hi){
            int mid = lo + (hi-lo)/2;
            if(isLeastCapacity(weights, days, mid)){
                hi = mid;
            }else{
                lo = mid + 1;
            }
        }
        return lo;
    }
    
    public boolean isLeastCapacity(int[] weights, int days, int capacity){
        int daysNeed = 1;
        int weightSum = 0;
        for(int w: weights){
            weightSum += w;
            if(weightSum > capacity){
                weightSum = w;
                daysNeed++;
            }
        }
        return daysNeed <= days;
    }
}
