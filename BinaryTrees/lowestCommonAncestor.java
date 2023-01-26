// Question link -> https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
// The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).

class Solution {
    // Approach 2 -> Recursive | TC - O(n) | SC - O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if (root == null || root == p || root == q)   // found p or q or touch the ground
          return root;

      // search p and q from left and right
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      if (left != null && right != null)    // from root's left & right we found both p and q, so root is the LCA
          return root;
      // left is not null means from left's left & right we found both q and q so left is the LCA, otherwise, right is the answer
      else      
          return left != null ? left : right;
    }
}

/* Approach 1 -> Find node to root path & then compare both paths | TC - O(n)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)    return null;
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();
        rootToNode(root, p, list1);
        rootToNode(root, q, list2);
        int n = list1.size() > list2.size() ? list2.size() : list1.size();
        TreeNode node = root;
        for(int i = 0; i < n; i++){
            if(list1.get(i) == list2.get(i)){
                node = list1.get(i);
            }else{
                break;
            }
        }
        return node;
    }

    public boolean rootToNode(TreeNode root, TreeNode node, ArrayList<TreeNode> list){
        if(root == null){
            return false;
        }
        list.add(root);
        if(root == node){
            return true;
        }
        if(rootToNode(root.left, node, list) || rootToNode(root.right, node, list)){
            return true;
        }
        list.remove(list.size()-1);
        return false;
    }
}
*/
