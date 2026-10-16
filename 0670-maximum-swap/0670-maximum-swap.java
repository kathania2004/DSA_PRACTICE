class Solution {
    public int maximumSwap(int num) {
        char[] arr = String.valueOf(num).toCharArray();

        int[] last = new int[10];

        //store the last occurence

        for(int i = 0;i < arr.length;i++){
            last[arr[i] - '0'] = i;
        }

        //find the first position that can be improved
        for(int i = 0;i < arr.length;i++){
            for(int digit = 9;digit > arr[i] - '0';digit--){

                if(last[digit] > i){
                    char temp = arr[i];
                    arr[i] = arr[last[digit]];
                    arr[last[digit]] = temp;

                    return Integer.parseInt(new String(arr));
                }
            }
        }
        return num;
    }
}