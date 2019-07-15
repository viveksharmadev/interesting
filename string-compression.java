// https://leetcode.com/problems/string-compression/

class string-compression {
    // tc -> n, sc-> 1
    public int compress(char[] chars) {
        int index = 0, resIndex = 0;
        while(index < chars.length){
            int count = 0;
            char currChar = chars[index];
            while(index<chars.length && chars[index]==currChar){
                index++;
                count++;
            }
            
            chars[resIndex++] = currChar;
            if(count > 1){
                String freq = String.valueOf(count);
                for(int i=0; i<freq.length(); i++){
                    chars[resIndex++] = freq.charAt(i);
                }
            }
        }
        return resIndex;
    }
}
