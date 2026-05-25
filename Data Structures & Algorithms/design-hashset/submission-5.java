class Node {

    int val;
    boolean deleted = true;
    Node(){};
    Node(int val,boolean deleted){
        this.val=val;
        this.deleted = deleted;
    }
}
class MyHashSet {
    ArrayList<Node> arr;

    public MyHashSet() {
        this.arr = new ArrayList<>();
    }
    
    public void add(int key) {
        while(arr.size()<=key){
            arr.add(new Node());
        }
            arr.get(key).val=key;
            arr.get(key).deleted=false;
        
    }
    
    public void remove(int key) {
        if(arr.size()>key){
            arr.get(key).deleted=true;
        }
        
        
    }
    
    public boolean contains(int key) {
        
        if(arr.size()<=key){
            return false;
        }
        return !arr.get(key).deleted;
    }
}
