class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int right = 0;right < s.length();right++){
            //to check for duplicate element
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            //add current element
            set.add(s.charAt(right));

            //update answer
            max = Math.max(max,right - left + 1);
        }
        return max;
    }
}