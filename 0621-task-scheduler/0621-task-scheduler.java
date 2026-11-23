class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(char ch : tasks){
            map[ch - 'A']++;
        }
        Arrays.sort(map);
        int maxFreq = map[25];
        int intervals = maxFreq - 1;
        int idleSlots = n * intervals;

        for(int i = 24;i >= 0;i--){
            idleSlots -= Math.min(map[i],intervals);
        }
        if(idleSlots > 0){
            return tasks.length + idleSlots;
        }
        return tasks.length;
    }
}