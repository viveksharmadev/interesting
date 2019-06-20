// https://leetcode.com/problems/insert-interval/
class insert-interval {
    // tc -> n, sc-> n
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals){
            if(newInterval==null || interval[1]<newInterval[0]){
                res.add(interval);
            }else if(interval[0]<=newInterval[1]){
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }else{
                res.add(newInterval);
                res.add(interval);
                newInterval=null;
            }
        }
        if(newInterval!=null) res.add(newInterval);
        return res.toArray(new int[][]{});
    }
}
