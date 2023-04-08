// Question link -> https://practice.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=detect-cycle-in-a-directed-graph

// Approach - DFS | TC - O(V+E) | SC - O(V)
class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] vis = new int[V];
        int[] pathvis = new int[V];
        for(int i = 0; i < V; i++){
            if(vis[i] == 0){
                if(dfs(adj, vis, pathvis, i)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] vis, int[] pathvis, int i){
        vis[i] = 1;
        pathvis[i] = 1;
        for(Integer nbr: adj.get(i)){
            if(vis[nbr] == 0){
                if(dfs(adj, vis, pathvis, nbr)) return true;
            }
            else if(pathvis[nbr] == 1){
                return true;
            }
        }
        pathvis[i] = 0;
        return false;
    }
}
// Solution video -> https://www.youtube.com/watch?v=9twcmtQj4DU


// Approach - BFS | Using Kahn's Algorithm | TC - O(V+E) | SC - O(V)
class Solution {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        //Find indegree of every vertex.
        for(int i = 0; i < V; i++){
            for(Integer v: adj.get(i)){
                indegree[v]++;
            }
        }
        // Add vertices with indegree = 0 into queue
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        // count number of vertices covered in kahn's algorithm
        int count = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            count++;
            for(int nbr: adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        
        if(count == V){
            return false;
        }
        return true;
    }
}
/* Explaination - Topological order is possible if and only if the graph has no directed cycles, i.e. if the graph is DAG. 
   So if count is less than no. of Vertices(V) then we are sure that there is a cycle present in the graph.
*/
