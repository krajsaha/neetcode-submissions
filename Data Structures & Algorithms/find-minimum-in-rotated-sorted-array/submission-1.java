class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int s =0;
        int e =n-1;

        while(s<=e){

            if(nums[s]<=nums[e]){
                return nums[s];
            }

            int mid = s+(e-s)/2;

            int mp = (mid+n-1)%n;
            int mn = (mid+1)%n;

            if(nums[mid]<=nums[mp] && nums[mid]<=nums[mn]){
                return nums[mid];
            }

            if(nums[s]<=nums[mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }

        return -1;
    }
}
