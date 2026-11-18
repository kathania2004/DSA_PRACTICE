class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int low = 0;
        int result = -1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int high = 0;high < n;high++){
            int fruit = fruits[high];
            map.put(fruit,map.getOrDefault(fruit,0) + 1);
            while(map.size() > 2){
                int intLow = fruits[low];
                map.put(intLow,map.get(intLow) - 1);
                if(map.get(intLow) == 0){
                    map.remove(intLow);
                }
                low++;
            }
            int len = high - low  + 1;
            result = Math.max(result,len);
        }
        return result;
    }
}