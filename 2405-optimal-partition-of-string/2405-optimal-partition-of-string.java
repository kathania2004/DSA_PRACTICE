class Solution {
    public int partitionString(String s) {
        int n = s.length();
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen,-1);
        int start = 0;
        int count = 0;
        for(int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if(lastSeen[ch - 'a'] >= start){
                count++;
                start = i;
            }
            lastSeen[ch - 'a'] = i;
        }
        return count + 1;
        
    }
}