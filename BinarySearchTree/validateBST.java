// Question link -> https://leetcode.com/problems/validate-binary-search-tree/description/

/*
A valid BST is defined as follows:
1) The left subtree of a node contains only nodes with keys less than the node's key.
2) The right subtree of a node contains only nodes with keys greater than the node's key.
3) Both the left and right subtrees must also be binary search trees.
*/

// Approach 4 -> Using min & max | TC - (n) | SC - O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    public boolean validate(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        // The current node's value must be between low and high.
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        // The left and right subtree must also be valid.
        return validate(root.left, min, root.val) && validate(root.right, root.val, max);
    }
}

// Approach 3 -> Recursive inorder traversal without storing elements | TC - O(n)
class Solution {
    private Integer prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {
        if(root == null)    return true;
        if(!inorder(root.left)){
            return false;
        }
        if(prev != null && root.val <= prev){
            return false;
        }
        prev = root.val;
        return inorder(root.right);
    }
}

/* Appraoch 2 -> Iterative inorder traversal | TC - O(n)
class Solution {
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        TreeNode prev = null;
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(prev != null && root.val <= prev.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
}
*/

Approach 1 -> Store inorder traversal in list & check if its sorted or not | Only works if there are no duplicates

/* Approach -> Using Pair class
class Solution {
    public boolean isValidBST(TreeNode root) {
        BSTPair ans = helper(root);
        return ans.isBST;
    }

    public BSTPair helper(TreeNode root){
        if(root == null){
            BSTPair bp = new BSTPair();
            bp.min = Integer.MAX_VALUE;
            bp.max = Integer.MIN_VALUE;
            bp.isBST = true;
            return bp;
        }
        BSTPair lp = helper(root.left);
        BSTPair rp = helper(root.right);

        BSTPair mp = new BSTPair();
        mp.isBST = lp.isBST && rp.isBST && (root.val > lp.max && root.val < rp.min);
        mp.min = Math.min(root.val, Math.min(lp.min, rp.min));
        mp.max = Math.max(root.val, Math.max(lp.max, rp.max));
        return mp;
    }
}

class BSTPair{
    boolean isBST;
    int min;
    int max;
}
*/
