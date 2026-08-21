class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }

        int maxL= Integer.MAX_VALUE;
        int[] idx = new int[]{0,0};

        HashMap<Character,Integer> map = new HashMap<>();

        for(char c : t.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        int size = map.size();

        int si =0;

        for(int e =0 ; e<s.length();e++){

            if(map.containsKey(s.charAt(e))){
                map.put(s.charAt(e),map.getOrDefault(s.charAt(e),0)-1);
                if(map.get(s.charAt(e))==0){
                    size--;
                }
            }

            while(size==0 && si<=e){

                if(e+1-si<maxL){
                    maxL =(e-si)+1;
                idx[0]=si;
                idx[1]=e;
                }

                if(map.containsKey(s.charAt(si))){
                map.put(s.charAt(si),map.getOrDefault(s.charAt(si),0)+1);
                if(map.get(s.charAt(si))==1){
                    size++;
                }
            }
            si++;
            }
        }

        return maxL== Integer.MAX_VALUE ? "" : s.substring(idx[0],idx[1]+1);
    }
}
