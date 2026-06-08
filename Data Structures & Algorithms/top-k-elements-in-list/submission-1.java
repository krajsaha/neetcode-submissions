class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());

        Map<Integer,Integer> map = new HashMap<>();

        for(int i : nums) {

            map.put(i,map.getOrDefault(i,0)+1);
        }

         for(Map.Entry<Integer,Integer> entry : map.entrySet()) {
            
            pq.add(entry);
            
            
            
        }
        int[] op = new int[k];
        
        while(k>0){
            op[k-1]=pq.poll().getKey();
            k--;
        }
        return op;
    }
}
