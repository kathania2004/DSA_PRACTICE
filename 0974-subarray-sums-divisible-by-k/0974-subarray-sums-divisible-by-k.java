class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        int count = 0;
        int sum = 0;
        int rem = 0;
        int res = 0;
        for(int i = 0;i < nums.length;i++){
            sum = sum + nums[i] ;
            rem = sum % k;
            
            //for negative remainder
            if(rem < 0){
                rem = rem + k;
            }

            res = res + map.getOrDefault(rem, 0);
            count = count + 1;
            map.put(rem,map.getOrDefault(rem, 0) + 1);
            
        }
        return res;
    }
}