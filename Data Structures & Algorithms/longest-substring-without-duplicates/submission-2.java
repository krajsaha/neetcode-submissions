class Solution {
    public int lengthOfLongestSubstring(String str) {
        if(str.length()==0){
            return 0;
        }

        Set<Character> set = new HashSet<>();

        int s=0;
        int e=0;
        int maxLen = 0;

        while(e<str.length()){
            if(!set.contains(str.charAt(e))){
                set.add(str.charAt(e));
            }else{

                maxLen=Math.max(maxLen,(e-s));
                while(str.charAt(s)!=str.charAt(e)){
                    set.remove(str.charAt(s));
                    s+=1;
                }
                set.remove(str.charAt(s));
                set.add(str.charAt(e));
                s+=1;
            }

            e+=1;
        }
        maxLen=Math.max(maxLen,(e-s));
        return maxLen;
    }
}