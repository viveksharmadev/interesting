// https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/

class search-in-a-sorted-array-of-unknown-size {
    // tc -> n, sc-> 1
    public int search(ArrayReader reader, int target) {
        int index = -1; boolean found = false;
        while(reader.get(++index)!=2147483647){
            if(reader.get(index)==target){
                found = true;
                return index;
            }
        }
        return found ? index : -1;
    }
    
    // tc -> O(T) where T is an index of target, sc-> O(1)
    public int search(ArrayReader reader, int target) {
        int start = 0, end = 1;
        while(reader.get(end)<target){
            end = end<<1; // end*2
        }
        // int start = hi >> 1; /// hi/2 can also be placed here
        while(start <= end){
            int mid = start + (end-start)/2;
            if(target < reader.get(mid)){
                end = mid-1;
            }else if(target > reader.get(mid)){
                start = mid+1;
            }else{
                return mid;
            }
        }
        return -1;
    }
}
