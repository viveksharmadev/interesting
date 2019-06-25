// https://leetcode.com/problems/reconstruct-itinerary/

class reconstruct-itinerary {
    // tc -> nlogn, sc-> n
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flightsMap = new HashMap<>();
        List<String> res = new ArrayList<>();
        if(tickets==null || tickets.size()==0) return res;
        for(List<String> list : tickets){
            flightsMap.putIfAbsent(list.get(0), new PriorityQueue<>());
            flightsMap.get(list.get(0)).offer(list.get(1));
        }
        
        traverse(flightsMap, "JFK", res);
        return res;
    }
    
    private void traverse(Map<String, PriorityQueue<String>> flightsMap, 
                          String airport, List<String> res){
        PriorityQueue<String> pq = flightsMap.get(airport);
        while(pq!=null && !pq.isEmpty()){
            traverse(flightsMap, (String)pq.poll(), res);
        }
        res.add(0, airport);
    }
}
