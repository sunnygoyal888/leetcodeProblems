// Question link -> https://leetcode.com/problems/binary-tree-postorder-traversal/description/

// Using One Stack & LinkedList addFirst() method
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
              stack.push(cur.left);
            }
            if (cur.right != null) {
              stack.push(cur.right);
            } 
        }
      return ans;
    }
}

/* Using Two Stacks
public List<Integer> postorderTraversal(TreeNode node) {
    ArrayList<Integer> postOrder = new ArrayList<>();
    if (node == null) return postOrder;

    Stack<TreeNode> st1 = new Stack<>();
    Stack<TreeNode> st2 = new Stack<>();
    st1.push(node);
    while(!st1.isEmpty()) {
        node = st1.pop();
        st2.push(node);
        if(node.left != null)
            st1.push(node.left);
        if(node.right != null)
            st1.push(node.right);
    }
    while(!st2.isEmpty()) {
        postOrder.add(st2.peek().data);
        st2.pop();
    }
    return postOrder;
}
*/

// Recursive
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    public void helper(TreeNode root, List<Integer> res) {
        if (root != null) {
            helper(root.left, res);
            helper(root.right, res);
            res.add(root.val);
        }
    }
}
