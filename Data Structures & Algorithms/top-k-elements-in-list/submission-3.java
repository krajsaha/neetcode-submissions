class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();


        int[] fop = new int[k];

        for(int i : nums){

            map.put(i,map.getOrDefault(i,0)+1);
        }
        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        for (int ki =0;ki<=nums.length;ki++){
            op.add(new ArrayList<>());
        }

        for(var entry : map.entrySet()){

            op.get(entry.getValue()).add(entry.getKey());
        }

        int i= nums.length;
        while(k>0 ){

            if(!op.get(i).isEmpty()){
                for (int integer : op.get(i)) {



                    fop[k-1]=integer;
                    k--;
                }
            }
            i--;
        }

        return fop;
    }
}