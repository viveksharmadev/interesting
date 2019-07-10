   // https://leetcode.com/problems/next-permutation/
   
         // Step 1 first get the culprit means the digit that is lesser than any neighbor next digit because this is the candidate to swap with and get bigger number, It is easier to check from last to first to get the immediate smaller digit (culprit) to swap further in step3.
        // From Step1 : Quesion arise why we are not swapping right away in step1 and going to step3 to swap? The answer is because we want to swap with the very last digit in hope to get immediate next greater number so we have to restart checking again from last digit in array to swap with candidate digit accordingly. 
        // Step2 let's consider we did not find such digit means the given number is in descending order. Go ahead and reverse the number and return, we are done for such input
        // Step 3: if control reaches to step 3 means we have to swap the potential candidate that we found in step1, now swap this potential candidate number with the last digit
        // Step 4: this is important step because keep in mind that we need to build the next immediate permutation so sort the remaining digits in ascending order after candidate index
        // Step5 : We are finally DONE.. Congrats

// tc -> n, sc-> 1
class next-permutation {
    public void nextPermutation(int[] nums) {    
        
        int n = nums.length, candidate = 0, candidateIndex = -1;
        //Step1:
        for(int i=n-1; i>0; i--){
            if(nums[i-1]<nums[i]){
                candidate = nums[i-1];
                candidateIndex = i-1;
                break;
            }
        }
        
        // Step2:
        if(candidateIndex==-1){
            sort(nums, 0, n-1);
            return;
        }
        
        //Step3 :
        for(int i=n-1; i>0; i--){
            if(candidate<nums[i]){
                swap(nums, candidateIndex, i);
                break;
            }
        }
        
        //Step4:
        sort(nums, candidateIndex+1, n-1);
    }
    
    private void sort(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++; end--;
        }
    }
    
    private void swap(int[] nums, int start, int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
    
}
