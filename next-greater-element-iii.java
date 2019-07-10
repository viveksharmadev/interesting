// https://leetcode.com/problems/next-greater-element-iii/

/* // Step 1: first get the culprit means the digit that is lesser than any bigger digit from    
		  last because this is the candidate to swap with the next bigger digit, in hope 
		  to get next bigger number, It is easier to check from last to first to get the immediate               
		  smaller digit (culprit) to swap further in step3.
     // From Step1 : Question arise why we are not swapping right away in step1 and going to step3 to swap? 
		The answer is because we want to swap with the next bigger digit from last in hope to get immediate next 
		greater number so we have to restart checking again from  next bigger digit from last in array to swap with candidate digit accordingly. 
     // Step2: let's consider we did not find such digit means the given number is in descending order. 
	      Go ahead and reverse the number and return, we are done for such input
     // Step 3: if control reaches to step 3 means we have to swap the potential candidate that we found in step1, 
		now swap this potential candidate number with the last digit
     // Step 4: this is important step because keep in mind that we need to build the next immediate permutation so sort the 
		remaining digits in ascending order after candidate index
     // Step5 : We are finally DONE.. Congrats */


class next-greater-element-iii {
	// tc -> n, sc-> n
    public int nextGreaterElement(int num) {
        List<Integer> nums = new ArrayList<>();
        while(num>0){
            int mod = num%10;
            nums.add(0,mod);
            num/=10;
        }
        
       int n = nums.size(), candidate = 0, candidateIndex = -1;
        //Step1:
        for(int i=n-1; i>0; i--){
            if(nums.get(i-1)<nums.get(i)){
                candidate = nums.get(i-1);
                candidateIndex = i-1;
                break;
            }
        }
        
        // Step2:
        if(candidateIndex==-1){
            return -1;
        }
        
        //Step3 :
        for(int i=n-1; i>0; i--){
            if(candidate<nums.get(i)){
                swap(nums, candidateIndex, i);
                break;
            }
        }
        
        //Step4:
        reverse(nums, candidateIndex+1, n-1);
        
        long res = 0;
        for(int number : nums){
            res = res*10 + number;    
        }
    
        return res<=Integer.MAX_VALUE ? (int)res : -1;
    }
    
    
    private void reverse(List<Integer> nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++; end--;
        }
    }
    
    private void swap(List<Integer> nums, int start, int end){
        int temp = nums.get(start);
        nums.set(start, nums.get(end));
        nums.set(end, temp);
    }
    
}
