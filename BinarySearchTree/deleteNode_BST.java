// Question link -> https://leetcode.com/problems/delete-node-in-a-bst/description/

// Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.

// Recursive Approach | TC - O(h) | SC - O(h)
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }
        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            // Case 1: No child
            if(root.left == null && root.right == null){
                return null;
            }
            // Case 2: Only one child
            else if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            // Case 3: Two children
            else{
                int lmax = findMax(root.left);  // find max in left subtree
                root.val = lmax;    // 
                root.left = deleteNode(root.left, lmax);// delete max node in left subtree
                return root;
            }
        }
        return root;
    }

    public int findMax(TreeNode node){
        while(node.right != null){
            node = node.right;
        }
        return node.val;
    }
}

// Solution video -> https://www.youtube.com/watch?v=5_AZcOOc-kM&list=PL-Jc9J83PIiGl_-iS5k7R7SZoZPt0Fab2&index=8
