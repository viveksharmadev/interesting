// https://leetcode.com/problems/rearrange-string-k-distance-apart/
class rearrange-string-k-distance-apart {
    // tc -> nlogn, sc-> n
    public String rearrangeString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i),0)+1);
        PriorityQueue<Map.Entry<Character, Integer>> pq 
            = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
        pq.addAll(freqMap.entrySet());
        Queue<Map.Entry<Character, Integer>> list = new LinkedList<>();
        while(!pq.isEmpty()){
            
            //while(list.size()<k && !pq.isEmpty()){
                Map.Entry<Character, Integer> e = pq.poll(); 
                //System.out.println("e.getKey()=> " + e.getKey() 
                  //                 + " e.getValue() " + e.getValue());
                sb.append(e.getKey());
                e.setValue(e.getValue()-1);
                list.offer(e);
                //dist--;
            //}
            if(list.size()<k) continue;
            //while(!list.isEmpty()){
                Map.Entry<Character, Integer> entry = list.poll();
                if(entry.getValue()>0)
                pq.offer(entry);                
            //}
            
           // if(pq.isEmpty()) break;
        }
        return sb.length()==s.length() ? sb.toString() : "";
    }
}
