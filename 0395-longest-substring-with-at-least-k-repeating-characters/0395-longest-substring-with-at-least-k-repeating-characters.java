class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s,0,s.length() - 1,k);
    }
    int helper(String s, int start, int end, int k){
        if(start > end){
            return 0;
        }

        HashMap<Character,Integer> map = new HashMap<>();

        for(int i = start ; i <= end ; i++){
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch , 0) + 1);
        }

        for(int i = start ; i <= end; i++){

            if(map.get(s.charAt(i)) < k){
                int index = i;
                int leftSub = helper(s,start,i - 1,k);
                int rightSub = helper(s,i + 1,end,k);
                return Math.max(leftSub,rightSub);
            }
        }
        //no bad character entire string is valid 
        return end - start + 1;
    }
}