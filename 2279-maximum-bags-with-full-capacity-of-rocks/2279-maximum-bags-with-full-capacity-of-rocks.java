class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int[] req = new int[n];

        for(int i = 0;i < n;i++){
            int diff = capacity[i] - rocks[i];
            req[i] = diff;
        }
        Arrays.sort(req);
        int noOfBags = 0;
        for(int i = 0;i < n;i++){
            if(req[i] == 0){
                noOfBags += 1; 
            }else{
                if(additionalRocks > 0 && req[i] <= additionalRocks){
                    additionalRocks -= req[i];
                    noOfBags += 1;
                }else{
                    break;
                }
            }
        }
        return noOfBags;
    }
}