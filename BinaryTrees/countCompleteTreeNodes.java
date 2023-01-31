// Question link -> https://leetcode.com/problems/count-complete-tree-nodes/description/

// Given the root of a complete binary tree, return the number of the nodes in the tree.
// CBT -> every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible.

// Approach 2 -> Using height | TC - O(logN*logN) | SC - O(logN)
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null)    return 0;

        int lh = findLeftHeight(root.left);
        int rh = findRightHeight(root.right);
        if(lh == rh){
            return (2<<(lh)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public int findLeftHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.left;
        }
        return count;
    }
    public int findRightHeight(TreeNode root){
        int count = 0;
        while(root != null){
            count++;
            root = root.right;
        }
        return count;
    }
}

// Approach 1 -> Traverse and count | TC - O(n) | SC - O(h)
class Solution {
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return 1 + left + right;
    }
}
