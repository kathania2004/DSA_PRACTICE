class Solution {
    public int longestPalindrome(String s) {
           HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        //int res = 0;
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch, 0) + 1);
        }
        boolean odd = false;
        int length = 0;
        for(int freq : map.values()){
            if(freq % 2 == 0){
                length += freq;
            }else{
                length += freq - 1;
                odd = true;
            }
        }
        if(odd){
            length++;
        }
        return length;
    }
}