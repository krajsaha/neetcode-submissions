

class Node {
    int val;
    int key;
    Node prev;
    Node next;
    Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public String toString() {
        return "Node{key=" + key + ", val=" + val + "}";
    }
}

class LRUCache {
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-99, -99);
        this.tail = new Node(-99, -99);
        head.next = tail;
        tail.prev = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addToFront(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.val = value; // Update value
            remove(node);
            addToFront(node);
            return;
        }

        // If at capacity, evict the Least Recently Used item (node right before tail)
        if (map.size() == capacity) {
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }

        Node newNode = new Node(key, value);
        addToFront(newNode);
        map.put(key, newNode);
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        node.next = null;
        node.prev = null;
    }

    private void addToFront(Node node) {
        Node nextNode = head.next;
        head.next = node;
        node.prev = head;
        node.next = nextNode;
        nextNode.prev = node;
    }
}