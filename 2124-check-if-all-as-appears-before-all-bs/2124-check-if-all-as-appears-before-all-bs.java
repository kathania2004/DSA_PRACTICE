class Solution {
    public boolean checkString(String s) {
        int n  =  s.length();
        boolean foundB = false;
        for(int i = 0;i < n;i++){
            if(s.charAt(i) == 'b'){
                foundB = true;
            }
            else if(foundB){
                return false;
            }
        }
        return true;
    }
}