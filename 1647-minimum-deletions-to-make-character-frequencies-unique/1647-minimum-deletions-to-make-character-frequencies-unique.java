class Solution {
    public int minDeletions(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < 26;i++){
            while(freq[i] > 0 && set.contains(freq[i])){
                freq[i]--;
                result += 1;

            }
            set.add(freq[i]);
        }
        return result;
    }
}