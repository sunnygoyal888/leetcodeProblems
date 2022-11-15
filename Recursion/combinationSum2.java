// Question link - https://leetcode.com/problems/combination-sum-ii/
// The solution set must not contain duplicate combinations.
// Input: candidates = [10,1,2,7,6,1,5], target = 8
// Output: [ [1,1,6], [1,2,5], [1,7], [2,6] ]

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);    // sort to remove duplicates
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        backtrack(candidates, res, ds, target, 0);
        return res;
    }
    
    public void backtrack(int[] candidates, List<List<Integer>> res, List<Integer> ds, int target, int start){
        if(target < 0)  return;
        if(target == 0){
            res.add(new ArrayList<> (ds));
            return;
        }
        
        for(int i = start; i < candidates.length; i++){
            if(i != start && candidates[i] == candidates[i-1]){     // skip duplicates
                continue;
            }
            ds.add(candidates[i]);
            backtrack(candidates, res, ds, target - candidates[i], i+1);
            ds.remove(ds.size() - 1);
        }
    }
}
