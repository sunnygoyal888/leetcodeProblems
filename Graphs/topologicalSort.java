// https://practice.geeksforgeeks.org/problems/topological-sort/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=topological-sort

Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge u v, vertex u comes before v in the ordering.
Topological order is possible if and only if the graph has no directed cycles, i.e. if the graph is DAG.
// Topological sorting is a kind of dependencies problem so, we can start with the tasks which do not have any dependencies and can be done straight away.
// So the order of work will be opposite to the topological sort.

/*
DFS Approach -
1) Start from a vertex and recursively call DFS on its adjacent vertices.
2) After visiting all its adjacent vertices when no further call is left, put the vertices on stack while backtracking.
3) Once all DFS calls are over for all components, We will get the stack containing one of the topological sortings of the graph.

Note- A vertex is pushed to stack only when all of its adjacent vertices (and their adjacent vertices and so on) are already in the stack
*/

// Appraoch - DFS | TC - O(V+E) | SC - O(V)
class Solution {
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < V; i++){
            if(vis[i] == false){
                dfs(adj, vis, st, i);
            }
        }
        
        int[] ans = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st, int v){
        vis[v] = true;
        for(Integer nbr: adj.get(v)){
            if(vis[nbr] == false){
                dfs(adj, vis, st, nbr);
            }
        }
        st.push(v);
    }
}

/*
BFS Approach - Kahn's Algorithm
1) Count all the incoming edges for each vertex & store it in an array.
2) Add those vertices whose incoming degree is 0 inside Queue.
3) Remove a vertex from Queue(add it in ans) & decrease indegree by 1 for all its neighbouring vertices. If indegree of any neighbour becomes 0 then add it to the Queue.
4) Repeat step 3 until the queue is empty.
*/
// Kahn’s topological sort algorithm works by finding vertices with no incoming edges and removing all outgoing edges from these vertices.

// Approach - BFS | TC - O(V+E) | SC - O(V)
class Solution {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int v: adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        
        int[] ans = new int[V];
        int i = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            ans[i++] = node;
            for(int nbr: adj.get(node)){
                indegree[nbr]--;
                if(indegree[nbr] == 0){
                    q.add(nbr);
                }
            }
        }
        return ans;
    }
}
