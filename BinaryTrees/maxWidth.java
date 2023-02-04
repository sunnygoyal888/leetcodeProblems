// Question link -> https://leetcode.com/problems/maximum-width-of-binary-tree/description/

// Given the root of a binary tree, return the maximum width of the given tree. The maximum width of a tree is the maximum width among all levels.
/*
The width of one level is defined as the length between the end-nodes (the leftmost and rightmost non-null nodes), where the null nodes 
between the end-nodes that would be present in a complete binary tree extending down to that level are also counted into the length calculation.
*/

// Approach -> calculate no of nodes at each level using Indexing | TC - O(n) | SC - O(n)
// width = (maximum index at that level) - (minimum index at that level) + 1
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int ans = 1;
        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().idx;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                int curr_idx = q.peek().idx - min;
                TreeNode node = q.peek().node;
                q.poll();
                if(i == 0)      first = curr_idx;
                if(i == size-1)     last = curr_idx;
                if(node.left != null){
                    q.add(new Pair(node.left, curr_idx*2+1));
                }
                if(node.right != null){
                    q.add(new Pair(node.right, curr_idx*2+2));
                }
            }
            ans = Math.max(ans, last-first+1);
        }
        return ans;
    }
}

class Pair{
    TreeNode node;
    int idx;
    Pair(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}

// Explanation -> https://leetcode.com/problems/maximum-width-of-binary-tree/solutions/1803302/c-detailed-explanation-w-why-covering-integer-overflow-condition-dry-run/?orderBy=most_votes
// Video -> https://www.youtube.com/watch?v=ZbybYvcVLks
