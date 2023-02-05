// Question link -> https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/

/*
Given the root of a binary tree, flatten the tree into a "linked list":

The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
The "linked list" should be in the same order as a pre-order traversal of the binary tree.
*/

// Recursive approach | TC - O(n) | SC - O(n)
class Solution {
    private TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null)    return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

/* Iterative approach | TC - O(n) | SC - O(n)
class Solution {
    public void flatten(TreeNode root) {
        if(root == null) return;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
            if(!st.isEmpty()){
                node.right = st.peek();
            }
            node.left = null;
        }
    }
}
*/
