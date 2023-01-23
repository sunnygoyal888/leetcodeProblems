// Question link -> https://leetcode.com/problems/binary-tree-right-side-view/description/

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Recursive Approach | TC - O(n) | SC - O(h)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    public void helper(TreeNode root, ArrayList<Integer> res, int level){
        if(root == null){
            return;
        }
        if(level == res.size()){
            res.add(root.val);
        }
        helper(root.right, res, level+1);
        helper(root.left, res, level+1);
    }
}

// Similarly, for Left Side View of BT -> first make a recursion call for the left subtree & then right subtree.
