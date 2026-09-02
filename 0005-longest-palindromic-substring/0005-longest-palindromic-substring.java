class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int maxlength = 0;
        for(int left = 0;left < s.length();left++){
            for(int right = left;right < s.length();right++){
                
                if(isPallindrome(s,left,right)){
                    int length = right - left + 1;
                    if(length > maxlength){
                        maxlength = length;
                        res = s.substring(left,right + 1);
                    }

                }
            }
        }
        return res;
    }
        
    static boolean isPallindrome(String s,int left,int right){
            while(left <= right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
        return true;
    }
}