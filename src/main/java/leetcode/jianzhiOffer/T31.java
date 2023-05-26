package leetcode.jianzhiOffer;

import java.util.HashMap;
import java.util.Map;

public class T31 {
    //LRU的实现
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;
    public int size;
    public T31(int capacity) {
        map = new HashMap<>();

        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        size = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        moveTotail(node,node.val);
        return node.val;
    }



    public void put(int key, int value) {
        if (map.containsKey(key)){
            moveTotail(map.get(key),value);
        }else {
            if (map.size() == size){
                Node toDel = head.next;
                delNode(toDel);
                map.remove(toDel.key);
            }
            Node node = new Node(key,value);
            insertToTail(node);
            map.put(key,node);
        }
    }
    private void moveTotail(Node node, int val) {
        delNode(node);
        node.val = val;
        insertToTail(node);
    }
    private void insertToTail(Node node) {
        tail.prev.next =node;
        node.prev =tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void delNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

class Node{
    public int key;
    public int val;
    public Node next;
    public Node prev;

    public Node(int k,int v){
        key = k;
        val = v;
    }
}
