// Question link -> https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

// Solution video -> https://www.youtube.com/watch?v=q_a6lpbKJdw

// Approach - Using BFS | TreeMap & PiorityQueue | TC - O(nlogn) | SC - O(n)
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0, 0));
        Map<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int row = p.row;
            int col = p.col;

            if(!map.containsKey(col)){
                map.put(col, new TreeMap<>());
            }
            if(!map.get(col).containsKey(row)){
                map.get(col).put(row, new PriorityQueue<>());
            }
            map.get(col).get(row).add(node.val);

            if(node.left != null){
                q.add(new Pair(node.left, row+1, col-1));
            }
            if(node.right != null){
                q.add(new Pair(node.right, row+1, col+1));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> colNodes: map.values()){
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> nodeVals: colNodes.values()){
                while(!nodeVals.isEmpty()){
                    list.add(nodeVals.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}

class Pair {
    TreeNode node;
    int row;
    int col;
    Pair(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
