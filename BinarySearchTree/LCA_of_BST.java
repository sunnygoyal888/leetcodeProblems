// Question link -> https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/

// The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).

// Approach 1 -> Recursive | TC - O(H) | SC - O(H)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }else if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }else{
            return root;
        }
    }
}

// Approach 2 -> Iterative | TC - O(H) | SC - O(1)
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        while(root != null){
            if(root.val > large){   // p, q lies in left subtree
                root = root.left;
            }else if(root.val < small){     // p, q lies in right subtree
                root = root.right;
            }else{      // root is LCA b/w p and q
                return root;
            }
        }
        return null;
    }
}
