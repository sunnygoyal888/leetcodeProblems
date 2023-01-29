// Question link -> https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

// Approach 2 -> Using inorder traversal | TC - O(h)
class Solution {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k);
    }

    public int inorder(TreeNode root, int k){
        if(root == null)    return -1;
        int left = inorder(root.left, k);
        if(left != -1){
            return left;
        }
        if(++count == k)    return root.val;
        return inorder(root.right, k);
    }
}

// Approach 1 -> Store all elements in arraylist using inorder traversal and return (k-1)th element of arraylist
