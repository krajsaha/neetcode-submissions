class Solution {
    char getMax(Map<Character,Integer> map){
        char maxC='-';
        int maxN=-1;
        //  map.forEach((key, value) -> {
        //     if(value>maxN){
        //         maxN=value;
        //         maxC=key;
        //     }
        // });

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
    if(entry.getValue()>maxN){
                maxN=entry.getValue();
                maxC=entry.getKey();
            }
}

        return maxC;
    }
    public int characterReplacement(String s, int k) {
        Map<Character,Integer> map = new HashMap<>();
        int si=0;
        

        int ans=0;

        for(int e=0;e<s.length();e++){

            map.put(s.charAt(e),map.getOrDefault(s.charAt(e),0)+1);

            char mx=getMax(map);
            if((e+1-si)-map.get(mx)<=k){
                ans = Math.max(ans,e+1-si);
            }

            while((e+1-si)-map.get(mx)>k){
                map.put(s.charAt(si),map.getOrDefault(s.charAt(si),0)-1);
                if(mx==s.charAt(si)){
                    mx=getMax(map);
                }
                si++;
            }
        }

    return ans;
    }
}
