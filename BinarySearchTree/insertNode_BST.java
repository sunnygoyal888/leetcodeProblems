// Question link -> https://leetcode.com/problems/insert-into-a-binary-search-tree/description/

// You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

// Note - If it is given in question that if element is already present then don't modify tree, simply return -> Then in that case, add an extra condition -> if(root.val == val) return root;

// Appraoch 1 -> Recursive | TC - O(h) | SC - O(h) where h is height of the tree
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val, null, null);
        }

        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }else if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }
}

/* Approach 2 -> Iterative | TC - O(h) | SC - O(1)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode node = root;
        while(true){
            if(node.val < val){
                if(node.right != null){
                    node = node.right;
                }else{
                    node.right = new TreeNode(val);
                    break;
                }
            }else{
                if(node.left != null){
                    node = node.left;
                }else{
                    node.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
*/
