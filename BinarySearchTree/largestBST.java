// Question link -> https://www.naukri.com/code360/problems/largest-bst_2098944
// Solution Video -> https://www.youtube.com/watch?v=X0oXMdtUDwo&list=PLgUwDviBIf0q8Hkd7bK2Bpryj2xVJk8Vk&index=56

  // Approach 1
  static class BSTPair{
        boolean isBST;
        int min;
        int max;
        int size;
        TreeNode lbst;
  }

  public static BSTPair largestBSTinTree(TreeNode root){
      if(root == null){
          BSTPair bp = new BSTPair();
          bp.isBST = true;
          bp.min = Integer.MAX_VALUE;
          bp.max = Integer.MIN_VALUE;
          bp.size = 0;
          bp.lbst = null;
          return bp;
      }

      BSTPair lp = largestBSTinTree(root.left);
      BSTPair rp = largestBSTinTree(root.right);

      BSTPair mp = new BSTPair();
      mp.isBST = lp.isBST && rp.isBST && (lp.max < root.data && rp.min > root.data);
      mp.min = Math.min(root.data, Math.min(lp.min, rp.min));
      mp.max = Math.max(root.data, Math.max(lp.max, rp.max));

      if(mp.isBST){
          mp.lbst = root;
          mp.size = lp.size + rp.size + 1;
      } else if (lp.size > rp.size) {
          mp.lbst = lp.lbst;
          mp.size = lp.size;
      } else {
          mp.lbst = rp.lbst;
          mp.size = rp.size;
      }

      return mp;
  }

// Approach 2
public class Solution {
	static class Pair{
		int min;
		int max;
		int size;
		Pair(int min, int max, int size){
			this.min = min;
			this.max = max;
			this.size = size;
		}
	}
	public static int largestBST(TreeNode<Integer> root) {
		// Write your code here.
		return helper(root).size;
	}

	public static Pair helper(TreeNode<Integer> root){
		if(root == null){
			return new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
		}

		Pair left = helper(root.left);
		Pair right = helper(root.right);

		if(left.max < root.data && right.min > root.data){
			return new Pair(Math.min(left.min, root.data), 
				Math.max(right.max, root.data), left.size + right.size + 1);
		}

		return new Pair(Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left.size, right.size));
	}
}
