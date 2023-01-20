// Question link -> https://leetcode.com/problems/binary-tree-level-order-traversal/description/

// Using Queue | TC - O(n)
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> level = new ArrayList<>();
            int count = q.size();
            for(int i = 0; i < count; i++){
                TreeNode node = q.remove();
                level.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }
            res.add(new ArrayList<>(level));
        }
        return res;
    }
}
