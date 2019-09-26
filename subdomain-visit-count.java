// https://leetcode.com/problems/subdomain-visit-count/
class subdomain-visit-count {
    // tc -> n, sc-> n
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String str : cpdomains){
            int index = str.indexOf(' ');
            int num = Integer.parseInt(str.substring(0, index));
            String s = str.substring(index+1);
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='.'){
                    String subStr = s.substring(i+1);
                    map.put(subStr, map.getOrDefault(subStr,0)+num);
                }
            }
            map.put(s, map.getOrDefault(s,0)+num);
        }        
        
        for(String key : map.keySet()){
            res.add(map.get(key) + " " + key);
        }
        
        return res;
    }
}
