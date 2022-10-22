class Solution {
    public int longestConsecutive(int[] nums) {
      // Method 2 - Store in hashSet & then find lcs || TC - O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }
        
        int longestSeq = 0;
        for(int num: nums){
            if(!set.contains(num-1)){
                int curr_num = num;
                int count = 1;
                
                while(set.contains(curr_num + 1)){
                    curr_num++;
                    count++;
                }
                
                longestSeq = Math.max(count, longestSeq);
            }
        }
        
        return longestSeq;
    }
  
  // Method1 - Sort the array & then find longest consecutive sequence || TC - O(nlogn)
}
