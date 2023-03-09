// Question link -> https://leetcode.com/problems/number-of-provinces/

// Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
// Output: 2

class Solution {
    // Approach -> Using DFS | TC - O(N^2) | SC - O(N)
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        boolean[] visited = new boolean[isConnected.length];
        for(int i = 0; i < isConnected.length; i++){
            if(visited[i] == false){
                count++;
                dfs(isConnected, i, visited);
            }
        }
        return count;
    }

    public void dfs(int[][] isConnected, int i, boolean[] visited){
        visited[i] = true;
        for(int j = 0; j < isConnected[i].length; j++){
            if(visited[j] == false && isConnected[i][j] == 1){
                dfs(isConnected, j, visited);
            }
        }
    }
}



// On Pepcoding -> https://nados.io/question/get-connected-components-of-a-graph
/* Input: 
7
5
0 1 10
2 3 10
4 5 10
5 6 10
4 6 10
Output: 3
*/
import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }

      ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
      
      // write your code here
      boolean[] visited = new boolean[vtces];
      for(int v = 0; v < vtces; v++){
         if(visited[v] == false){
            ArrayList<Integer> comp = new ArrayList<>();
            drawTree(graph, v, visited, comp);
            comps.add(comp);
         }
      }

      System.out.println(comps.size());
   }

   public static void drawTree(ArrayList<Edge>[] graph, int src, boolean[] visited, ArrayList<Integer> comp){
      visited[src] = true;
      comp.add(src);
      for(Edge e: graph[src]){
         if(visited[e.nbr] == false){
            drawTree(graph, e.nbr, visited, comp);
         }
      }
   }
}

// Solution video -> https://www.youtube.com/watch?v=8UBwFE8H4Mc
