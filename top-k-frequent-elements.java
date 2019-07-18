// https://leetcode.com/problems/top-k-frequent-elements/
class top-k-frequent-elements {
    // tc -> n, sc-> n
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) 
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0)+1);
        
        List<Integer>[] buckets = new ArrayList[nums.length+1]; 
        for(int key : freqMap.keySet()){
            int freq = freqMap.get(key);
            if(buckets[freq]==null){
                buckets[freq] = new ArrayList<Integer>();
            }
            buckets[freq].add(key);
        }
        
        for(int pos = buckets.length-1; pos>=0 && res.size()<k; pos--){
            if(buckets[pos]!=null){                      
              res.addAll(buckets[pos]);
            }
        }
        
        return res;
    }
    
    // tc -> nlogk, sc-> n
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) 
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i],0)+1);
        
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
            new Comparator<Map.Entry<Integer, Integer>>(){
                @Override
                public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b){
                    return b.getValue() - a.getValue();
                }
            }
        );
        
        pq.addAll(freqMap.entrySet());
        
        while(!pq.isEmpty() && res.size()<k){
            Map.Entry<Integer, Integer> e = pq.poll();
            res.add(e.getKey());
        }
        return res;
    }
    
}
