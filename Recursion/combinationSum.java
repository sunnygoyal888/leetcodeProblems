// Question link - https://leetcode.com/problems/combination-sum/
// The same number may be chosen from candidates an unlimited number of times. 
// Return a list of all unique combinations of candidates where the chosen numbers sum to target.
// Input: candidates = [2,3,6,7], target = 7
// Output: [[2,2,3],[7]]

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        solve(candidates, ds, 0, target, res);
        return res;
    }
    
    public void solve(int[] candidates, List<Integer> ds, int idx, int target, List<List<Integer>> res){
        if(target < 0) return;
        else if(target == 0){
          res.add(new ArrayList<> (ds));
        }
        
        for(int i = idx; i < candidates.length; i++){
            ds.add(candidates[i]);
            solve(candidates, ds, i, target-candidates[i], res);
            ds.remove(ds.size()-1);
        }
    }
}
