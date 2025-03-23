// Question link -> https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

/*
There are n cities connected by some number of flights. You are given an array flights where flights[i] = [fromi, toi, pricei] indicates that there is a flight from city fromi to city toi with cost pricei.

You are also given three integers src, dst, and k, return the cheapest price from src to dst with at most k stops. If there is no such route, return -1.
*/


// Approach - Using Dijkstra | TC - O(V+E)
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<Pair>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < flights.length; i++){
            graph[flights[i][0]].add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(0, 0, src));

        while(!q.isEmpty()){
            Tuple tp = q.poll();
            int stops = tp.stops;
            int cost = tp.dist;
            int node = tp.vt;

            if(stops > k){
                continue;
            }

            for(Pair p: graph[node]){
                int nbr = p.vt;
                int nbrwt = p.wt;
                
                if(stops <= k && cost + nbrwt < distance[nbr]){
                    distance[nbr] = cost + nbrwt;
                    q.offer(new Tuple(stops+1, distance[nbr], nbr));
                }
            }
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    class Tuple{
        int stops;
        int dist;
        int vt;

        Tuple(int stops, int dist, int vt){
            this.stops = stops;
            this.dist = dist;
            this.vt = vt;
        }
    }

    class Pair{
        int vt;
        int wt;
        Pair(int vt, int wt){
            this.vt = vt;
            this.wt = wt;
        }
    }
}
