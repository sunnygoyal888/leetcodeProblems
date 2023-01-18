// Question link -> https://leetcode.com/problems/binary-tree-preorder-traversal/

// Iterative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();
        if(root == null)    return preorder;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        
        while(st.size() > 0){
            TreeNode node = st.pop();
            preorder.add(node.val);
            if(node.right != null){
                st.push(node.right);
            }
            if(node.left != null){
                st.push(node.left);
            }
        }
        return preorder;
    }
  
    /* Same as above but with slight modification
      List<Integer> list = new ArrayList<>();
      Stack<TreeNode> st = new Stack<>();
      st.push(root);

      while(st.size() > 0){
          TreeNode node = st.pop();
          if(node != null){
              list.add(node.val);
              st.push(node.right);
              st.push(node.left);
          }
      }
      return list;
    */
  
    /* Method2 - Only add right child in stack
      while (root != null || !stack.isEmpty()) {
          if (root != null) {
              result.add(root.val);
              stack.push(root.right);
              root = root.left;
          } else {
              root = stack.pop();
          }
    }*/
}

// Recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            res.add(root.val);
            helper(root.left, res);
            helper(root.right, res);
        }
    }
}
