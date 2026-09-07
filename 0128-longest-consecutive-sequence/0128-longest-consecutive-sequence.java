class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        //add all elements in hashset for occurence
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;
        for(int num : set){

            //start only if num is the begning
            if(!set.contains(num - 1)){
                int current = num;
                int count = 1;
                  //find all consecutive nums
            while(set.contains(current + 1)){
                current++;
                count++;

            }
             longest = Math.max(longest,count);
            }
        }
        return longest;
        
    }
}