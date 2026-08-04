class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();
        List<List<String>> fop = new ArrayList<>();

        for(String str : strs) {

            char[] arr = new char[26];

            for(char c : str.toCharArray()){

                arr[c-'a'] = (char) (arr[c-'a']+1);
            }
            String tStr = new String(arr);
            if(!map.containsKey(tStr)){
               map.put(tStr,new ArrayList<>());
            }
             map.get(tStr).add(str);
        }

        for(List<String> op : map.values()){
            fop.add(op);
        }

        return fop;
    }
}
