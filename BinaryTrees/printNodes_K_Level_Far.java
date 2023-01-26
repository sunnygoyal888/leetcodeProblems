// Question link -> https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/

// Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.

// Solution -> https://www.youtube.com/watch?v=B89In5BctFA

class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        ArrayList<TreeNode> path = new ArrayList<>();
        nodeToRoot(root, target, path);
        for(int i = 0; i < path.size(); i++){
            printKLevelsDown(path.get(i), k-i, res, i == 0 ? null : path.get(i-1));
        }
        return res;
    }

    public void printKLevelsDown(TreeNode root, int k, ArrayList<Integer> res, TreeNode blocker){
        if(root == null || k < 0 || root == blocker){
            return;
        }
        if(k == 0){
            res.add(root.val);
        }
        printKLevelsDown(root.left, k-1, res, blocker);
        printKLevelsDown(root.right, k-1, res, blocker);
    }

    public boolean nodeToRoot(TreeNode root, TreeNode target, ArrayList<TreeNode> path){
        if(root == null){
            return false;
        }
        if(root == target){
            path.add(root);
            return true;
        }
        if(nodeToRoot(root.left, target, path)){
            path.add(root);
            return true;
        }
        if(nodeToRoot(root.right, target, path)){
            path.add(root);
            return true;
        }
        return false;
    }
}
