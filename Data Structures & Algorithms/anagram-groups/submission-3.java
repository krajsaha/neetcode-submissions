class Solution {
    String getAnagram(String s) {
        char[] anagram = new char[26];

        for(int i =0;i<s.length();i++) {
            anagram[s.charAt(i)-'a']++;
        }

        return new String(anagram);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
         List<List<String>> outPut = new ArrayList<>();

        for(String s : strs) {

            String ana = getAnagram(s);

            if(!map.containsKey(ana)){
                map.put(ana,new ArrayList<>());
                
            }

            map.get(ana).add(s);

        }
        for(List<String> value : map.values()) {
            outPut.add(value);
        }
        return outPut;
    }
}
