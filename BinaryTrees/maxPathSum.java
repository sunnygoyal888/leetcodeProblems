// Question link -> https://leetcode.com/problems/binary-tree-maximum-path-sum/description/

A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
The path sum of a path is the sum of the node's values in the path.
Given the root of a binary tree, return the maximum path sum of any non-empty path.

// Explanation -> https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/2827786/binary-tree-maximum-path-sum/?orderBy=most_votes

// TC - O(n) | SC - O(n)
class Solution {
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int ls = Math.max(0, helper(root.left));
        int rs = Math.max(0, helper(root.right));
        max = Math.max(max, root.val + ls + rs);
        return root.val + Math.max(ls, rs);
    }
}
