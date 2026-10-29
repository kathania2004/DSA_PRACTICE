class Solution {
    public int maxLength(List<String> arr) {
        int n = arr.size();
        String temp = "";
        return solve(arr,n,0,temp); //no duplicate found at all
    }
    
    private int solve(List<String> arr,int n ,int index,String temp){
        if(index >= n){
            return temp.length();
        }

        int exclude = solve(arr,n,index + 1,temp);
        int include = 0;
        if(!hasDuplicate(temp,arr.get(index))){
            include = solve(arr,n,index + 1,temp + arr.get(index));
        }
        return Math.max(include,exclude);
    }

    private boolean hasDuplicate(String s1,String s2){
        int[] freq = new int[26]; 
        for(char ch : s1.toCharArray()){
            if(freq[ch - 'a'] > 0){
                return true;
            }
            freq[ch - 'a']++;
        }

        for(char ch : s2.toCharArray()){
            if(freq[ch - 'a'] > 0){
                return true;
            }
            freq[ch - 'a']++;
        }
        return false;
    }
}