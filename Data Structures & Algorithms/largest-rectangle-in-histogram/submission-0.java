class Node {

    int val;
    int idx;

    Node(int val,int idx){
        this.val=val;
        this.idx=idx;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", idx=" + idx +
                '}';
    }
}

class Solution {

    public ArrayList<Node> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Node> ar = new ArrayList<>();
        for(int a : arr){
            ar.add(new Node(-1,-1));
        }
        Stack<Node> stack = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){

            while(!stack.isEmpty() && arr[i]<=stack.peek().val){
                stack.pop();
            }
            Node val =  stack.isEmpty() ? new Node(-1, arr.length) : stack.peek();
            ar.set(i,val);

            stack.push(new Node(arr[i],i));

        }

        return ar;
    }

    public ArrayList<Node> preGreaterEle(int[] arr) {
        // code here
        ArrayList<Node> ar = new ArrayList<>();
        for(int a : arr){
            ar.add(new Node(-1,-1));
        }
        Stack<Node> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){

            while(!stack.isEmpty() && arr[i]<=stack.peek().val){
                stack.pop();
            }
            Node val =  stack.isEmpty() ? new Node(-1,-1) : stack.peek();
            ar.set(i,val);

            stack.push(new Node(arr[i],i));

        }

        return ar;
    }


    public int largestRectangleArea(int[] heights) {
        ArrayList<Node> nle =nextLargerElement(heights);
        ArrayList<Node> ple =preGreaterEle(heights);

        int ans = -1;

        for(int i=0;i<heights.length;i++){
            ans = Math.max(ans,(nle.get(i).idx   - ple.get(i).idx -1 ) * heights[i]);
        }

        return ans;
    }


}