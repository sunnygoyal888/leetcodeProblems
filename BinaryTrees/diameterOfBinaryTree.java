// Question link -> https://leetcode.com/problems/diameter-of-binary-tree/description/

// The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
// The length of a path between two nodes is represented by the number of edges between them.

// Approach 3 -> Using Travel & Change | Using height | TC - O(n)
class Solution {
    int dia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }

    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        dia = Math.max(dia, left + right);
        return 1 + Math.max(left, right);
    }
}

// Approach 2 -> Making a single recursive call & computing diameter & height simultaneously | Using Pair class | TC - O(n) 
/*
class DiaPair {
    int ht;
    int dia;
}

class Solution {
    public int diameterOfBinaryTree(TreeNode root){
        DiaPair p = helper(root);
        return p.dia;
    }

    public DiaPair helper(TreeNode root) {
        if(root == null){
            DiaPair bp = new DiaPair();
            bp.ht = -1;
            bp.dia = 0;
            return bp;
        }
        DiaPair lp = helper(root.left);
        DiaPair rp = helper(root.right);

        DiaPair mp = new DiaPair();
        mp.ht = Math.max(lp.ht, rp.ht) + 1;
        int f = lp.ht + rp.ht + 2;
        mp.dia = Math.max(f, Math.max(lp.dia, rp.dia));
        return mp;
    }
}
*/

// Approach 1 -> Brute Force | Recursion inside Recursion | TC - O(n^2)
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ldia = diameterOfBinaryTree(root.left); // max distance b/w 2 nodes of lhs
        int rdia = diameterOfBinaryTree(root.right); // max distance b/w 2 nodes of rhs
        // max distance b/w left's deppest & right's deepest
        int f = height(root.left) + height(root.right) + 2;
        return Math.max(f, Math.max(ldia, rdia));
    }

    public int height(TreeNode root){
        if(root == null){
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
