
// Iterative || TC - O(n) | SC - O(n) 
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        TreeNode curr = root;
        while(curr != null || st.size() > 0){
            while(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            curr = st.pop();
            list.add(curr.val);
            curr = curr.right;
        }
        
        return list;
    }
}

// Recursive || TC - O(n) | SC - O(n)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            res.add(root.val);
            helper(root.right, res);
        }
    }
}
