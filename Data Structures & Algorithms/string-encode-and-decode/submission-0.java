class Solution {

    public String encode(List<String> strs) {

        StringBuilder op = new StringBuilder();

            if(strs.size()==0){
                return op.toString();
            }

            for(String str : strs){
                op.append(str.length());
                op.append("#");
                op.append(str);
            }

            return op.toString();
    }

    public List<String> decode(String str) {

        if(str==""){
            return new ArrayList<>();
        }

        ArrayList<String> op = new ArrayList();

        int sidx=0;
        int lidx=0;

        while(sidx<str.length()){

            if(str.charAt(sidx)=='#'){
                int len = Integer.valueOf(str.substring(lidx,sidx));
                op.add(str.substring(sidx+1,sidx+len+1));
                lidx=sidx+len+1;
                sidx=lidx;
            }
            sidx++;
        }
        return op;
    }
}
