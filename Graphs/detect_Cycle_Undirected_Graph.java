// Question link -> https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-an-undirected-graph

// Approach - Using BFS
class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; v++){
            if(visited[v] == false){
                boolean cycle = bfs(adj, v, visited);
                if(cycle){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, int src, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(q.size() > 0){
            int rem = q.remove();
            if(visited[rem] == true){
                return true;
            }
            visited[rem] = true;
            for(int nbr: adj.get(rem)){
                if(visited[nbr] == false){
                    q.add(nbr);
                }
            }
        }

        return false;
    }
}

// Approach - Using DFS
class Solution {
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] visited = new int[V];
        for(int v = 0; v < V; v++){
            if(visited[v] == 0){
                if(dfs(adj, v, -1, visited) == true){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int src, int parent, int[] visited){
        visited[src] = 1;
        for(int nbr: adj.get(src)){
            if(visited[nbr] == 0){
                if(dfs(adj, nbr, src, visited) == true){
                    return true;
                }
            }
            else if(nbr != parent){
                return true;
            }
        }
        return false;
    }
}
