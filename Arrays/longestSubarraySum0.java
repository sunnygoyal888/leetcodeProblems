// Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.
// Input: A[] = {15,-2,2,-8,1,7,10,23}
// Output: 5    // The largest subarray with sum 0 will be -2 2 -8 1 7.

// Approach 1 - Brute Force - check all subarray's sum || TC - O(n^2)
// Approach 2 - Store prefix sum & index in HashMap as if we encounter same prefix sum again then it means sum of subarray from that index is 0. 
                // Then find length of that subarray using index of that prefix sum i.e. maxlen = i-map.get(sum)
                // TC - O(n) | SC - O(n)

class GfG{
    int maxLen(int arr[], int n){
        // Your code here
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == 0){
                maxlen = i+1;
            }
            else if(map.get(sum) != null){
                maxlen = Math.max(maxlen, i - map.get(sum));
            }else{
                map.put(sum,i);
            }
        }
        return maxlen;
    }
}
