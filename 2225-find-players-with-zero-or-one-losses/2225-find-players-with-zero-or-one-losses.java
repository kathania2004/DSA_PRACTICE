class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        int n = matches.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            int loser = matches[i][1];

            map.put(loser,map.getOrDefault(loser,0) + 1);
        }
        List<Integer> notLost = new ArrayList<>();
        List<Integer> lostOnce = new ArrayList<>();

        //Find players with zero or one loss

        for(int i = 0;i < n;i++){
            int winner = matches[i][0];
            int loser = matches[i][1];

            if(!map.containsKey(winner)){
                notLost.add(winner);

                //mark winner to not add duplicates

                map.put(winner,2);
            }
            if(map.get(loser) == 1){
                lostOnce.add(loser);
            }

        }
        Collections.sort(notLost);
        Collections.sort(lostOnce);

        List<List<Integer>> result = new ArrayList<>();
        result.add(notLost);
        result.add(lostOnce);
        return result;
    }

}