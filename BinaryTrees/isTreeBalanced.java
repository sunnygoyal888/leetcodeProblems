// Question link -> https://leetcode.com/problems/balanced-binary-tree/description/

// Using Travel & Change | Calculating height & isBal simultaneously | TC - O(n) | SC - O(h) for recursive stack
class Solution {
    boolean isBal = true;
    public boolean isBalanced(TreeNode root) {
        helper(root);
        return isBal;
    }

    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int lh = helper(root.left);
        int rh = helper(root.right);
        if(Math.abs(lh-rh) > 1){
            isBal = false;
        }
        return Math.max(lh, rh) + 1;
    }
}

// Using Pair class | TC - O(n)
class BalPair {
    boolean isBal;
    int ht;
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        BalPair p = helper(root);
        return p.isBal;
    }

    public BalPair helper(TreeNode root){
        if(root == null){
            BalPair np = new BalPair();
            np.ht = 0;
            np.isBal = true;
            return np;
        }
        BalPair lp = helper(root.left);
        BalPair rp = helper(root.right);
        
        BalPair mp = new BalPair();
        mp.isBal = lp.isBal && rp.isBal && Math.abs(lp.ht-rp.ht) <= 1;
        mp.ht = Math.max(lp.ht, rp.ht) + 1;

        return mp;
    }
}

// Recursive solution | TC - O(n^2)
/*
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.abs(lh-rh) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
*/
