// https://leetcode.com/problems/subsets/
class subsets {
    // tc -> 2^n, sc-> n
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        setSubsets(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void setSubsets(int[] nums, List<List<Integer>> res, List<Integer> list, int index){
        res.add(new ArrayList(list));
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            setSubsets(nums, res, list, i+1);
            list.remove(list.size()-1);
        }        
    }
    
    // tc -> n*2^n, sc-> n*2^n
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        
        for(int num : nums){
            int n = res.size();
            for(int i=0; i<n; i++){
                List<Integer> list = new ArrayList(res.get(i));
                list.add(num);
                res.add(list);
            }
        }
        
        return res;
    }
}
