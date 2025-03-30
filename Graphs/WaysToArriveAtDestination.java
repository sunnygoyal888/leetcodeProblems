// Question -> https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/

/*
You are in a city that consists of n intersections numbered from 0 to n - 1 with bi-directional roads between some intersections. 
The inputs are generated such that you can reach any intersection from any other intersection and that there is at most one road between any two intersections.

You are given an integer n and a 2D integer array roads where roads[i] = [ui, vi, timei] means that there is a road between intersections ui and vi that takes timei minutes to travel. 
You want to know in how many ways you can travel from intersection 0 to intersection n - 1 in the shortest amount of time.

Return the number of ways you can arrive at your destination in the shortest amount of time. 
Since the answer may be large, return it modulo 109 + 7.
*/

// Approach - Using Dijkstra | TC - (NlogN)
class Solution {
    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] road: roads){
            int u = road[0];
            int v = road[1];
            int time = road[2];

            graph[u].add(new int[]{v, time});
            graph[v].add(new int[]{u, time});
        }

        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        int mod = (int)(1e9 + 7);

        PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
        pq.add(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            long currTime = curr[0];
            int currNode = (int)curr[1];

            if(currTime > dist[currNode]){
                continue;
            }

            for(int[] nbr: graph[currNode]){
                int next = nbr[0];
                int time = nbr[1];
                if(currTime + time < dist[next]){
                    dist[next] = currTime + time;
                    pq.add(new long[]{currTime + time, next});
                    ways[next] = ways[currNode];
                }
                else if(currTime + time == dist[next]){
                    ways[next] = (ways[next] + ways[currNode]) % mod;
                }
            }
        }

        return ways[n-1] % mod;

    }
}

// Solution video -> https://www.youtube.com/watch?v=_-0mx0SmYxA
