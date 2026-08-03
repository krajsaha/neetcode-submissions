class Node {

    int val;

    int key;

    Node next;

    Node(int key,int val){

        this.key = key;
        this.val=val;
    }


}

class MyHashMap {
    Node[] nodes;
    int size=1000;
    public MyHashMap() {
         this.nodes = new Node[size];
    }
    
    public void put(int key, int value) {
        int idx = key%size;
        if(nodes[idx]==null){
            nodes[idx] = new Node(key,value);
        }else{

            Node head = nodes[idx];
            // boolean flag=false;

            while(head!=null){

                if(head.key==key){
                    head.val=value;
                    // flag=true;
                    break;
                }
                if(head.next==null){
                head.next=new Node(key,value);
                break;
            }
                head=head.next;
            }

        }
    }
    
    public int get(int key) {
        int idx = key%size;
        Node head = nodes[idx];
        while(head!=null){

            if(head.key==key){
                return head.val;
            }

            head=head.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key%size;
        Node head = nodes[idx];

        if(head==null){
            return;
        }

        if(head.key==key){
            nodes[idx]=head.next;
        }else{
            Node prev=nodes[idx];
            while(head!=null){

            if(head.key==key){
                prev.next=head.next;
                break;
            }
            prev=head;
            head=head.next;
        }

        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */