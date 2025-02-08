// Question link -> https://leetcode.com/problems/find-eventual-safe-states/description/

/*
There is a directed graph of n nodes with each node labeled from 0 to n - 1. 
The graph is represented by a 0-indexed 2D integer array graph where graph[i] is an integer array of nodes adjacent to node i, meaning there is an edge from node i to each node in graph[i].

A node is a terminal node if there are no outgoing edges. 
A node is a safe node if every possible path starting from that node leads to a terminal node (or another safe node).

Return an array containing all the safe nodes of the graph. The answer should be sorted in ascending order.
*/

// Approach1 - Using DFS
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
            for(int val: graph[i]){
                adj.get(i).add(val);
            }
        }

        int[] visited = new int[n];
        int[] pathVis = new int[n];

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                dfs(adj, i, visited, pathVis);
            }
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(pathVis[i] == 0){
                ans.add(i);
            }
        }

        return ans;
    }

    public boolean dfs(List<List<Integer>> adj, int i, int[] visited, 
            int[] pathVis){

        visited[i] = 1;
        pathVis[i] = 1;

        for(int nbr: adj.get(i)){
            if(visited[nbr] == 0){
                if(dfs(adj, nbr, visited, pathVis)){
                    return true;
                }
            }
            else if(pathVis[nbr] == 1){
                return true;
            }
        }

        pathVis[i] = 0;
        return false;
    }
}

// Approach2 - Using BFS | TC - O(V+E)
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int val: graph[i]){
                adj.get(val).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            safeNodes.add(node);

            for(int nbr: adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}

// Approach 3 -> Using 3 color approach (same as DFS)
// Solution video -> https://www.youtube.com/watch?v=CHRMnJl6Cg0
