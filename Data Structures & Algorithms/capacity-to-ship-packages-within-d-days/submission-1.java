class Solution {

    // long getHours(int[] piles,int x){

    //     int temp = 0;
    //     long ans=1;
    //     for(int i : piles){



    //         if(temp+i>x){
    //             ans+=1;
    //             temp=i;
    //         }else {
    //             temp+=i;
    //         }
    //     }
    //     return ans;
    // }

    long getHours(int[] piles,int x){

        int ans=1;

        int capacity=x;

        for(int i : piles){
            if(i<=capacity){
                capacity=capacity-i;
            }else{
                ans+=1;
                capacity=x-i;
            }
        }
        return ans;
    }

    public int shipWithinDays(int[] weights, int days) {
        int range = Integer.MIN_VALUE;
        int max=0;
        for(int i: weights){

            range = Math.max(i,range);
            max+=i;
        }

        int s=range;
        int e=max;
        int ans=Integer.MAX_VALUE;

        while(s<=e){

            int mid = s+(e-s)/2;

            long time=getHours(weights,mid);
            if(time>days){
                s=mid+1;
            }else{
                ans=Math.min(ans,mid);
                e=mid-1;
            }
        }

        return ans;

    }
}

