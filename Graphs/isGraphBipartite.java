// Question link -> https://leetcode.com/problems/is-graph-bipartite/description/

// Approach 3 -> DFS | Graph Coloring | TC - O(V+E) | SC - O(V)
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        for(int v = 0; v < graph.length; v++){
            if(colors[v] == 0){
                if(dfs(graph, colors, v, 1) == false){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int[][] graph, int[] colors, int v, int color){
        colors[v] = color;
        for(int nbr: graph[v]){
            if(colors[nbr] == 0){
                if(dfs(graph, colors, nbr, -color) == false){
                    return false;
                }
            }
            else if(colors[nbr] == color){
                return false;
            }
        }
        return true;
    }
}
// Solution video -> https://www.youtube.com/watch?v=KG5YFfR0j8A


// Approach 2 -> BFS | Graph Coloring | TC - O(V+E) | SC - O(V+E)
public boolean bfs(int[][] graph, int[] colors, int v){
    Queue<Integer> q = new ArrayDeque<>();
    q.add(v);
    colors[v] = 1;
    while(!q.isEmpty()){
        int node = q.remove();
        for(int nbr: graph[node]){
            if(colors[nbr] == 0){
                q.add(nbr);
                colors[nbr] = -colors[node];
            }
            else if(colors[nbr] == colors[node]){
                return false;
            }
        }
    }
    return true;
}


/* Approach 1 -> BFS
class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] visited = new int[graph.length];
        Arrays.fill(visited, -1);
        for(int i = 0; i < graph.length; i++){
            if(visited[i] == -1){
                boolean isBipartite = bfs(graph, visited, i);
                if(!isBipartite)    return false;
            }
        }
        return true;
    }

    public boolean bfs(int[][] graph, int[] visited, int src){
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(src, 0));
        while(!q.isEmpty()){
            Pair rem = q.remove();
            if(visited[rem.v] != -1){
                if(visited[rem.v] != rem.level){
                    return false;
                }
            }else{
                visited[rem.v] = rem.level;
            }
            for(int nbr: graph[rem.v]){
                if(visited[nbr] == -1){
                    q.add(new Pair(nbr, rem.level+1));
                }
            }
        }
        return true;
    }
}

class Pair{
    int v;
    int level;
    Pair(int v, int level){
        this.v = v;
        this.level = level;
    }
}
*/
// Solution video -> https://www.youtube.com/watch?v=ZBhZ1DXGrhA
