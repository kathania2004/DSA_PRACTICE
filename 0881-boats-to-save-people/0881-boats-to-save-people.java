class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int i = 0;
        int j = n - 1;
        int boat = 0;
        Arrays.sort(people);
        while(i <= j){
            if((people[i] + people[j]) > limit){
                boat = boat + 1;
                j--;
            }else if((people[i] + people[j]) <= limit){
                boat++;
                i++;
                j--;
            }else{
                boat++;
            }
        }
        return boat;
    }
}