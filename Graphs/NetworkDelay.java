// Question link -> https://leetcode.com/problems/network-delay-time/description/

/*
You are given a network of n nodes, labeled from 1 to n. 
You are also given times, a list of travel times as directed edges times[i] = (ui, vi, wi), 
where ui is the source node, vi is the target node, and wi is the time it takes for a signal to travel from source to target.

We will send a signal from a given node k. Return the minimum time it takes for all the n nodes to receive the signal. 
If it is impossible for all the n nodes to receive the signal, return -1.
*/

// Approach 1 -> Using Bellman Ford | TC - O(N^2)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for(int i = 0; i < n-1; i++){
            for(int[] time: times){
                int u = time[0];
                int v = time[1];
                int wt = time[2];

                if(dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        int minTime = 0;
        for(int i = 1; i <= n; i++){
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}


// Approach 2 -> Using Dijkstra | TC - O(NlogN)
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        Map<Integer,List<int[]>> map = new HashMap<>();
        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int wt = time[2];

            map.computeIfAbsent(u, i -> new ArrayList<>()).add(new int[]{v,wt});
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{k, 0});

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currNode = curr[0];
            int currWt = curr[1];

            for(int[] nbr: map.getOrDefault(currNode, new ArrayList<>())){
                int next = nbr[0];
                int time = nbr[1];

                if(time + currWt < dist[next]){
                    dist[next] = time + currWt;
                    q.offer(new int[]{next, time + currWt});
                }
            }
        }

        int minTime = 0;
        for(int i = 1; i <= n; i++){
            minTime = Math.max(minTime, dist[i]);
        }

        return minTime == Integer.MAX_VALUE ? -1 : minTime;
    }
}
