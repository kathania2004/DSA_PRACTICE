class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] % 2 != 0){
                count++;
            }

            res = res + map.getOrDefault(count - k,0);

            map.put(count,map.getOrDefault(count,0) + 1);
        }
        return res;
    }
}