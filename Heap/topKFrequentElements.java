// Question link -> https://leetcode.com/problems/top-k-frequent-elements/description/

// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
// Example 1:
// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]

// Solution -> https://leetcode.com/problems/top-k-frequent-elements/solutions/1927648/one-of-the-best-explanation/

class Solution {
    // Approach - Using Bucket Sort | TC - O(N) | SC - O(N)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int val: nums){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        
        ArrayList<Integer> bucket[] = new ArrayList[nums.length+1];
        for(int key: map.keySet()){
            int freq = map.get(key);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }

        int[] res = new int[k];
        int idx = 0;
        for(int i = bucket.length-1; i >= 0; i--){
            if(bucket[i] != null){
                for(int val: bucket[i]){
                    res[idx++] = val;
                    if(idx == k){
                        return res;
                    }
                }
            }
        }

        return res;
    }
    
    // Approach - Using Map & Priority Queue | TC - O(NlogN) | SC - O(D)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int val: nums){
            map.put(val, map.getOrDefault(val,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));
        for(int key: map.keySet()){
            pq.add(key);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            res[i++] = pq.poll();
        }
        return res;
    }
}
