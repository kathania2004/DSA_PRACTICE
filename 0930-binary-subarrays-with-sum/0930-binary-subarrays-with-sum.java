class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            sum = sum + nums[i];

            int req = sum - goal;

            if(map.containsKey(req)){
                count = count + map.get(req);
            }

            map.put(sum,map.getOrDefault(sum,0) + 1);
        }
        return count;
    }
}