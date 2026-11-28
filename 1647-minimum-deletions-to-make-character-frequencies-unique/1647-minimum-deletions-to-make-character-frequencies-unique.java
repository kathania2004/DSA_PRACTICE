class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        Arrays.sort(freq);
        int result = 0;
        for(int i = 24 ; i >= 0; i--){
            if(freq[i] >= freq[i + 1]){
                int prev = freq[i];
                freq[i] = Math.max(0,freq[i + 1] - 1);
                result += (prev - freq[i]);
            }
        }
        return result;
    }
}