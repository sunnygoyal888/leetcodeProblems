// Question link -> https://practice.geeksforgeeks.org/problems/burning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=burning-tree
// Question link -> https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/description/


// Solution -> https://www.youtube.com/watch?v=dtBj2A_7JOk
// Using DFS | TC - O(n)
class Solution {
    int totalTime = 0;
    public int amountOfTime(TreeNode root, int start) {
        burningTree(root, start);
        return totalTime;
    }

    public void burnTree(TreeNode root, TreeNode blockNode, int time){
        if(root == null || root == blockNode){
            return;
        }
        totalTime = Math.max(totalTime, time);
        burnTree(root.left, blockNode, time+1);
        burnTree(root.right, blockNode, time+1);
    }

    public int burningTree(TreeNode root, int start){
        if(root == null)    return -1;
        if(root.val == start){
            burnTree(root, null, 0);
            return 1;
        }

        int lt = burningTree(root.left, start);
        if(lt != -1){
            burnTree(root, root.left, lt);
            return lt + 1;
        }
        int rt = burningTree(root.right, start);
        if(rt != -1){
            burnTree(root, root.right, rt);
            return rt + 1;
        }
        return -1;
    }
}

// Using BFS and HashMap
class Solution {
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> hm = new HashMap<>();
        TreeNode targetNode = getParentMapping(root, start, hm);

        Queue<TreeNode> q = new ArrayDeque<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.add(targetNode);
        visited.put(targetNode, true);
        int time = 0;
        while(!q.isEmpty()){
            time++;
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.left != null && !visited.containsKey(node.left)){
                    visited.put(node.left, true);
                    q.add(node.left);
                }
                if(node.right != null && !visited.containsKey(node.right)){
                    visited.put(node.right, true);
                    q.add(node.right);
                }
                if(hm.get(node) != null && !visited.containsKey(hm.get(node))){
                    visited.put(hm.get(node), true);
                    q.add(hm.get(node));
                }
            }
        }
        return time - 1;
    }
    
    public TreeNode getParentMapping(TreeNode root, int start, HashMap<TreeNode, TreeNode> hm){
        TreeNode target = null;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if(node.val == start){
                    target = node;
                }
                if(node.left != null){
                    q.add(node.left);
                    hm.put(node.left, node);
                }
                if(node.right != null){
                    q.add(node.right);
                    hm.put(node.right, node);
                }
            }
        }
        return target;
    }
}
