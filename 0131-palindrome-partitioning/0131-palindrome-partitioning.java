class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> diary = new ArrayList<>();
        backtrack(s,0,diary,res);
        return res;
        
    }
    static void backtrack(String s,int start,List<String> diary,List<List<String>> res){
        if(start == s.length()){
            res.add(new ArrayList<>(diary));
            return;
        }

        for(int end = start;end < s.length();end++){
            if(isPallindrome(s,start,end)){
                //choice1 add
                diary.add(s.substring(start,end + 1));
                backtrack(s,end + 1,diary,res);
                diary.remove(diary.size() - 1);
            }
        }
    }
    static boolean isPallindrome(String s,int left,int right){
        while(left < right){

            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}