class Solution {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for(int i = 0 ;i < n;i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr,(a,b) -> ("" + b + a).compareTo(""+ a + b));
        if(arr[0] == 0){
            return "0";
        }
        String s = "";
        for(int num : arr){
            s += String.valueOf(num);
        }
        return s;
        
    }
}