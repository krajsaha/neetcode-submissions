class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int s =0;
        int e =n-1;

        while(s<=e){

            if(nums[s]<=nums[e]){
                return s;
            }

            int mid = s+(e-s)/2;

            int mp = (mid+n-1)%n;
            int mn = (mid+1)%n;

            if(nums[mid]<=nums[mp] && nums[mid]<=nums[mn]){
                return mid;
            }

            if(nums[s]<=nums[mid]){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }

        return -1;
    }
    int bSearch(int[] nums,int s,int e,int t){

        while(s<=e){

            int mid = s+(e-s)/2;

            if(nums[mid]==t){
                return mid;
            }else if(nums[mid]<t){
                s=mid+1;
            }else{
                e=mid-1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int min = findMin(nums);

        if(target>=nums[min] && target<=nums[nums.length-1]){
            return bSearch(nums,min,nums.length-1,target);
        }else{
            return bSearch(nums,0,min-1,target);
        }
    }
}
