// https://leetcode.com/problems/insert-delete-getrandom-o1/
class RandomizedSet {

    // tc -> 1, sc-> n
    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else{
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }else{
            int index = map.get(val);
            if(index < list.size()-1){
                int last = list.get(list.size()-1);
                map.put(last, index);
                list.set(index, last);
            }
            map.remove(val);
            list.remove(list.size()-1);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int index = random.nextInt(list.size());
        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
