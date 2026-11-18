class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int low = 0;
        int result = -1;
        HashMap<Character,Integer> map = new HashMap<>();
        if(n == 0){
            return 0;
        }
        for(int high = 0;high < n;high++){
            char ch = s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0) + 1);
            while(map.get(ch) > 1){
                char atLow = s.charAt(low);
                map.put(atLow,map.get(atLow) - 1);
                if(map.get(atLow) == 0){
                    map.remove(atLow);
                }
                low++;
            }
            int len = high - low  + 1;
            result  = Math.max(result,len);
        }
        return result;
    }
}