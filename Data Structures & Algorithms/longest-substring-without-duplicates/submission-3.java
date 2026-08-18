class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        int si=0;
        int e=0;
        int ans=0;
        while(e<s.length()){

            while(map.containsKey(s.charAt(e))){
                int size = map.get(s.charAt(si))-1;
                if(size==0){
                    map.remove(s.charAt(si));
                }else{
                    map.put(s.charAt(si),size);
                }
                si++;
            }
            map.put(s.charAt(e),map.getOrDefault(s.charAt(e),0)+1);
            ans=Math.max(ans,map.size());
            e++;
        }

        return ans;
    }
}
