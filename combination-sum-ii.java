// https://leetcode.com/problems/combination-sum-ii/
class combination-sum-ii {
    // tc -> 2^n, sc-> n
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {        
        List<List<Integer>> res = new ArrayList<>();
        if(candidates==null || candidates.length==0) return res;
        Arrays.sort(candidates);
        combinationSum2(candidates, target, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void combinationSum2(int[] nums, int target, List<List<Integer>> res,
                                 List<Integer> list, int index){
        if(target<0) return;
        if(target==0){
            res.add(new ArrayList(list));
        }
        // 1,1,2,5,6,7,10
        for(int i=index; i<nums.length; i++){
            //System.out.println("i=> " + i + "\tindex => " + index);
            //System.out.println(list);
            if(i>index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            combinationSum2(nums, target-nums[i], res, list, i+1);
            list.remove(list.size()-1);
        }
    }
}
