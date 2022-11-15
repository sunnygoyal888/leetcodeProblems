// Question link - https://leetcode.com/problems/subsets/
// Given an integer array nums of unique elements, return all possible subsets (the power set).
// The solution set must not contain duplicate subsets. Return the solution in any order.
// Input: nums = [1,2,3]
// Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(nums, ds, 0, res);
        return res;
    }
    
    public void solve(int[] nums, List<Integer> ds, int idx, List<List<Integer>> res){
        if(idx == nums.length){
            res.add(new ArrayList<> (ds));
            return;
        }
        
        solve(nums, ds, idx+1, res);
        ds.add(nums[idx]);
        solve(nums, ds, idx+1, res);
        ds.remove(ds.size()-1);
    }
    
  
  // Using backtracking
    /*
    public void solve(int[] nums, List<Integer> ds, int start, List<List<Integer>> res){
        res.add(new ArrayList<> (ds));
        for(int i = start; i < nums.length; i++){
            ds.add(nums[i]);
            solve(nums, ds, i+1, res);
            ds.remove(ds.size()-1);
        }
    }
    */
}
