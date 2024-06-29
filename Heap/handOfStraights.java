// Queston link -> https://leetcode.com/problems/hand-of-straights/description/

class Solution {
    // Approach - Using Priority Queue | TC - O(N*logN)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int h: hand){
            pq.add(h);
        }

        while(!pq.isEmpty()){
            int val = pq.poll();
            for(int i = 1; i < groupSize; i++){
                if(!pq.remove(val+i)){
                    return false;
                }
            }
        }
        return true;
    }

    // Approach - Using TreeMap | TC - O(N*logN + N*GS)
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0){
            return false;
        }
        Map<Integer,Integer> map = new TreeMap<>();
        for(int h: hand){
            map.put(h, map.getOrDefault(h,0)+1);
        }

        for(int key: map.keySet()){
            if(map.get(key) > 0){
                for(int i = 1; i < groupSize; i++){
                    // Using getOrDefault here to check whether key exists or not
                    // Comparing with last key as it should be greater
                    if(map.getOrDefault(key+i,0) < map.get(key)){
                        return false;
                    }
                    map.put(key+i, map.get(key+i)-map.get(key));
                }
            }
        }
        return true;
    }
}
