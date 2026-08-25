class Node{

    int val;
    Node prev;
    Node next;
    Node(int val){
        this.val=val;
    }
}
class MyCircularQueue {

    int capacity;
    int totalCap;
    Node head;
    Node tail;

    public MyCircularQueue(int k) {
        
        this.capacity=k;
        this.totalCap=k;
        this.head=new Node(-1);
        this.tail=new Node(-1);
        head.prev=tail;
        tail.prev=head;
        tail.next=head;
        head.next=tail;
    }
    
    public boolean enQueue(int value) {
        if(capacity==0){
            return false;
        }
        Node curr = new Node(value);
        Node tailPrev=tail.prev;
        tailPrev.next=curr;
        tail.prev=curr;
        curr.prev=tailPrev;
        curr.next=tail;
        capacity--;
        return true;
    }
    
    public boolean deQueue() {
        if(capacity==totalCap){
            return false;
        }
        Node curr=head.next;
        curr.next.prev=head;
        head.next=curr.next;
        capacity++;
        return true;
        
    }
    
    public int Front() {
        if(capacity==totalCap){
            return -1;
        }else{
            return head.next.val;
        }
    }
    
    public int Rear() {
        if(capacity==totalCap){
            return -1;
        }else{
            return tail.prev.val;
        }
    }
    
    public boolean isEmpty() {
        if(capacity==totalCap){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean isFull() {
        return capacity==0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */