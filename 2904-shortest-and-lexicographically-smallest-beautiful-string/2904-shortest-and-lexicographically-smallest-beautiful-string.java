class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int count = 0;
        String ans = "";

        for(int right = 0;right < s.length();right++){
            if(s.charAt(right) == '1'){
                count++;
            }

            while(count > k){
                if(s.charAt(right) == '1'){
                    count--;
                }
                left++;
            }

            while(left < right && s.charAt(left) == '0'){
                left++;
            }

            if(count == k){
                String current = s.substring(left,right + 1);

                if(ans.equals("") || current.length() < ans.length() || (current.length() == ans.length() && current.compareTo(ans) < 0)){
                    ans = current;
                }
            }
        }
        return ans;
    }
}