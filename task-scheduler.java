// https://leetcode.com/problems/task-scheduler/
class task-scheduler {
    // tc -> nlogn, sc-> n
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char t : tasks){
            freqMap.put(t, freqMap.getOrDefault(t, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Character, Integer>> pq 
            = new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
        pq.addAll(freqMap.entrySet());
        
        int ctn = 0;
        while(!pq.isEmpty()){
            int interval = n+1; // why +1? For Buffer time or idle time
            List<Map.Entry<Character, Integer>> localList
                = new LinkedList<>(); // This list is to update pq because we want to update pq, correctly but not duplicates Entry there
            while(interval > 0 && !pq.isEmpty()){
                Map.Entry<Character, Integer> e = pq.poll();
                e.setValue(e.getValue()-1);
                localList.add(e);
                interval--;
                ctn++;
            }
            
            for(Map.Entry<Character, Integer> e : localList){
                if(e.getValue() > 0) pq.offer(e);                
            }
            
            if(pq.isEmpty()) break;
            //System.out.println(interval);
            ctn += interval; // important because here we are adding idle time 
        }
        return ctn;
    }
}
