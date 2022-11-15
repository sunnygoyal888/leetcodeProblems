// Question link - https://leetcode.com/problems/subsets-ii/
// Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
// Input: nums = [1,2,2]
// Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

// Using backtracking || TC - O(2^n)
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(nums, ds, 0, res);
        return res;
    }
    
    public void solve(int[] nums, List<Integer> ds, int idx, List<List<Integer>> res){
        res.add(new ArrayList<> (ds));
        for(int i = idx; i < nums.length; i++){
            if(i != idx && nums[i] == nums[i-1]){
                continue;
            }
            ds.add(nums[i]);
            solve(nums, ds, i+1, res);
            ds.remove(ds.size()-1);
        }
    }
}

Recursion Tree Diagram Including Duplicate Subsets
===================================================
    
    NOTE:  T : Included ith indexed's element, F : Excluded ith indexed's element
    
                                  [1, 1, 2]                0th -> indicates making decisions for 0th indexed element
                           T         /   \          F
                +------------------+      +----------------------+
               /                                                  \
             {1}+--+                                                {}__   1st -> indexed's decisions
           T/       \F                                            /    \ 
           /         \                                          T/      \F
          {1, 1}       {1}+  (duplicate_subtree) --------->    {1}       {}     2nd -> indexed's decisions
        T/    \F      T/   \F                                T/  \    T /  \F
        /      \      /     \                                /    \    /    \
     {1, 1, 2} {1, 1} {1, 2} {1}                            {1, 2} {1} {2}   {}     3rd -> elements are exhausted
     ^                         ^                              ^         ^     ^
     |                         |                              |         |     |              
     |                         |                              |         |     |  
     +-------------------------+                              +---------+     |
                ^                                               duplicates    ^  
                |                                               subsets       |         
                +-------------------------------------------------------------+
                                        required subsets
