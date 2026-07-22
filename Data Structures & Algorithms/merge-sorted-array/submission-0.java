class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int pos=nums1.length-1;

        while(m>0 && n>0 && pos>=0){

            if(nums1[m-1]>=nums2[n-1]){
                nums1[pos]=nums1[m-1];
                nums1[m-1]=0;
                m--;
                }
                else{
                    nums1[pos]=nums2[n-1];
                nums2[n-1]=0;
                n--;
                }
                pos--;
        }

        while(m>0 && pos>=0){
            nums1[pos]=nums1[m-1];
            m--;
            pos--;
        }
        while(n>0 && pos>=0){
            nums1[pos]=nums2[n-1];
            n--;
            pos--;
        }
        
    }
}