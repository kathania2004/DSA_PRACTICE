class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int m = nums1.length;
        int n = nums2.length;
        int[] ans = array(nums1,nums2);
        int len = ans.length;
        
        if(len % 2 == 0){
            return (ans[len/2] + ans[len/2 - 1]) / 2.0;
        }else{
            return ans[len / 2];
        }
    }
     static int[] array(int[] nums1,int[] nums2){
        int k = 0;
        int j = 0;
        int m = nums1.length;
        int n = nums2.length;
        int index = 0;
        int[] res = new int[m + n];
        int i = 0;
        while(k < m && j < n){
            if(nums1[k] < nums2[j]){
                res[index] = nums1[k];
                k++;
                index++;
            }else{
                res[index] = nums2[j];
                j++;
                index++;
            }
        }
        while(k < m){
            res[index++] = nums1[k++];
        }
        while(j < n){
            res[index++] = nums2[j++];
        }
       return res;
    }
}