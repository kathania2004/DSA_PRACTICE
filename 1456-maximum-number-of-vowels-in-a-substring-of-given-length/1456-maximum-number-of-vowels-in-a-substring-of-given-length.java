class Solution {
    public int maxVowels(String s, int k) {
        int count = 0; 
        //count the vowels 
        for(int i = 0;i < k;i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int max = count;
        //slide the window
        for(int i = k ;i < s.length();i++){
            
            //rmove the leftmost element
            if(isVowel(s.charAt(i - k))){
                count--;
            }

            //add the other element
            if(isVowel(s.charAt(i))){
                count++;
            }
            max = Math.max(max,count);
        }
        return max;
    }
    static boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i'|| ch == 'o' || ch == 'u';
    }
}