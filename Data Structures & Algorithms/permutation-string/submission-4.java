class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c : s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);

        }

        int s=0;
        int size=map.size();
        for(int e=0;e<s2.length();e++){

            if(map.containsKey(s2.charAt(e))){
                map.put(s2.charAt(e),map.getOrDefault(s2.charAt(e),0)-1);
                if(map.get(s2.charAt(e))==0){
                    size--;
                }
            }
            while((e-s)+1>s1.length()){
                if(map.containsKey(s2.charAt(s))){
                    map.put(s2.charAt(s),map.getOrDefault(s2.charAt(s),0)+1);
                    if(map.get(s2.charAt(s))==1){
                        size++;
                    }
                }


                s++;
            }

            if(size==0){
                return true;
            }


        }

        return false;
    }
}