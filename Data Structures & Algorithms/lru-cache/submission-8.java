class Node {
    int val;
    int key;
    Node prev;
    Node next;
    Node(int key,int val){
        this.key=key;
        this.val=val;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", key=" + key +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
class LRUCache {
    Node head;
    Node tail;
    int cap;
    HashMap<Integer,Node> map;

    public LRUCache(int capacity) {
        this.head=new Node(-99,-99);
        this.tail=new Node(-99,-99);
        head.next=tail;
        tail.prev=head;
        this.cap=capacity;
        this.map=new HashMap<>();
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        moveFirst(node);
        return node.val;
    }
    
    void moveFirst(Node node){
        
        if(!(node.prev ==null) && !(node.next ==null)) {
            Node next=node.next;
            Node prev=node.prev;
            next.prev=prev;
            prev.next=next;
            node.next=null;
            node.prev=null;
        }
        
        Node next=head.next;
        head.next=node;
        node.next=next;
        next.prev=node;
        node.prev=head;
    }

    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val=value;
            moveFirst(node);
            map.put(key,node);
        }else {
            add(key, value);
            cap--;
        }
    }
    void remove(Node node){
        Node prev=node.prev;
        Node next=node.next;
        prev.next=next;
        next.prev=prev;
        node.next=null;
        node.prev=null;
    }

    void add(int key,int val){
        if(cap==0){
            Node tbr = tail.prev;
            remove(tbr);
            map.remove(tbr.key);
            cap++;
        }
        
        Node node = new Node(key,val);
        moveFirst(node);
        map.put(key,node);

    }
}