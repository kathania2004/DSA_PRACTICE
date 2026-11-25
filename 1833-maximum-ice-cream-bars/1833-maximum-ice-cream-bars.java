class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = costs.length;
        Arrays.sort(costs);
        int maxIce = 0;
        for(int i = 0 ; i < n;i++){
            if(coins == 0){
                return maxIce ;
            }else if(costs[i] <= coins){
        
                maxIce += 1;
                coins = coins - costs[i]; 
            }
        } 
        return maxIce; 
    }
}