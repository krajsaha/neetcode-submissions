class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character,Integer> map = new HashMap<>();

        for(char c : s1.toCharArray()) {

            map.put(c,map.getOrDefault(c,0)+1);
        }

        int ws=0;
        int we=0;
        int count=map.size();
        while(we<s2.length()) {
            char temp = s2.charAt(we);

            if(map.containsKey(temp)) {

                map.put(temp,map.getOrDefault(temp,0)-1);

                if(map.get(temp)==0) {
                    count--;
                }
            }

            while(count==0) {

                    if(we-ws+1==s1.length()) {
                        return true;
                    }
        char temp2 = s2.charAt(ws);
            if(map.containsKey(temp2)) {

                if(map.get(temp2)==0){
                count++;
               }
                 map.put(temp2,map.getOrDefault(temp2,0)+1);
            }
                ws++;
            }
            we++;
        }

        return false;
    }
}
