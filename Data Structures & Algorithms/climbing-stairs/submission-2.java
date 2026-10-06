class Solution {
    int stairs(int n){
        if(n<=0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }

        return stairs(n-1)+stairs(n-2);
    }

    int stairs1(int n,HashMap<Integer,Integer> map){
        if(n<0){
            return 0;
        }
        if(n==0){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(map.containsKey(n)){
            return map.get(n);
        }

        int ans =  stairs1(n-1,map)+stairs1(n-2,map);
        map.put(n,ans);
        return map.get(n);
    }
    public int climbStairs(int n) {
     return stairs1(n,new HashMap<>());   
    }
}
