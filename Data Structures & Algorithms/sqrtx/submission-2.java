class Solution {
    public int mySqrt(int x) {
     
     int s=0;
     int e=x;
     int fans=-1;

     while(s<=e){

        int mid = s+(e-s)/2;

        long ans=(long)mid*mid;
        if(ans==x){
            return mid;
        }else if(ans>x){
            e=mid-1;
        }else{
            s=mid+1;
            fans = Math.max(fans,mid);
        }
     }
     return fans;
    }
}