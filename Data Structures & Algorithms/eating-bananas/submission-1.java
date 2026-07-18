class Solution {

    long getHours(int[] piles,int x){

        long ans=0;

        for(int i : piles){
            long temp=0;

            if(i%x==0){
                temp = i/x;
            }else{
                temp=(i/x)+1;
            }

            ans+=temp;
        }
        return ans;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int range = Integer.MIN_VALUE;
        for(int i: piles){

            range = Math.max(i,range);
        }

        int s=1;
        int e=range;
        int ans=Integer.MAX_VALUE;

        while(s<=e){

            int mid = s+(e-s)/2;

            long time=getHours(piles,mid);
            if(time>h){
                s=mid+1;
            }else{
                ans=Math.min(ans,mid);
                e=mid-1;
            }
        }

        return ans;

    }
}

