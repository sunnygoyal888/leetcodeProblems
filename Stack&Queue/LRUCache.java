// Question link -> https://leetcode.com/problems/lru-cache/

class LRUCache {
    int capacity;
    Node head = new Node(-1,-1);
    Node tail = new Node(-1,-1);
    HashMap<Integer,Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            removeNode(map.get(key));
        }

        if(map.size() == capacity){
            removeNode(tail.prev);
        }
        addNode(new Node(key,value));
    }

    public void removeNode(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addNode(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    class Node{
        int key, value;
        Node next, prev;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }
}
