class Solution {
     public int climbStairs1(int n,HashMap<Integer,Integer> map) {
        if(n<1){
            return 0;
        }
        if(n==1){
            return 1;
        }

        if(n==2){
            return 2;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        int nop=climbStairs1(n-1,map)+climbStairs1(n-2,map);
        map.put(n,nop);
        return nop;
    }
    public int climbStairs(int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        return climbStairs1(n,map);
            }
}
