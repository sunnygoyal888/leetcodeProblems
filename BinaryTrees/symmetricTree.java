// Question link -> https://leetcode.com/problems/symmetric-tree/description/

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// Recursive Approach | TC - O(n) | SC - O(n)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return helper(root.left, root.right);
    }

    public boolean helper(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
            return false;
        }
        return helper(p.left, q.right) && helper(p.right, q.left);
    }
}

/* Iterative Approach | TC - O(n)
public boolean isSymmetric(TreeNode root) {
    Stack<TreeNode> st = new Stack<>();
        st.push(root.left);
        st.push(root.right);
        while(!st.isEmpty()){
            TreeNode n1 = st.pop();
            TreeNode n2 = st.pop();
            if(n1 == null && n2 == null)    continue;
            if(n1 == null || n1 == null || n1.val != n2.val){
                return false;
            }
            st.push(n1.left);
            st.push(n2.right);
            st.push(n1.right);
            st.push(n2.left);
        }
        return true;
}
*/
