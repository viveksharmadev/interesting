// https://leetcode.com/problems/relative-sort-array/
class Solution {
   // tc -> n, sc-> 1
   public int[] relativeSortArray(int[] arr1, int[] arr2) {
       int[] count = new int[1001];
       for(int num : arr1) count[num]++;
       
       int j = 0;
       for(int i=0; i<arr2.length; i++){
           while(count[arr2[i]]>0){
               arr1[j++] = arr2[i];
               count[arr2[i]]--;
           }
       }
       
       for(int i=0; i<count.length; i++){
           while(count[i]-- >0){
               arr1[j++] = i;                
           }
       }
       
       return arr1;
   }

   // tc -> nlogn, sc-> n
   public int[] relativeSortArray(int[] arr1, int[] arr2) {
       Map<Integer, Integer> map = new TreeMap<>();
       for(int num : arr1) 
       map.put(num, map.getOrDefault(num,0)+1);
       
       int j = 0;
       for(int i=0; i<arr2.length; i++){
           while(map.get(arr2[i])>0){
               arr1[j++] = arr2[i];
               map.put(arr2[i], map.get(arr2[i])-1);
           }
       }
       
       for(int key : map.keySet()){
           while(map.get(key)>0){
               arr1[j++] = key;
               map.put(key, map.get(key)-1);
           }
       }
       
       return arr1;
   }
}
