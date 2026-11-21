class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;i < n;i++){
            int num = arr[i];
            map.put(num,map.getOrDefault(num,0) +1);
        }
        HashSet<Integer> set = new HashSet<>();
        for(int freq : map.values()){
            if(set.contains(freq)){
                return false;
            }
            set.add(freq);
        }
        return true;
    }
}