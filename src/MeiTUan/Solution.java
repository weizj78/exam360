package MeiTUan;
import java.util.*;
public class Solution {
    /**
     * lru design
     * @param operators int整型二维数组 the ops
     * @param k int整型 the k
     * @return int整型一维数组
     */
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;
    private int length;

    public void init(int k) {
        map = new HashMap<>();
        length = 0;
    }


    public void set(int key, int value, int k) {
        Node node = new Node();
        node.key = key;
        node.val = value;
        map.put(key, node);
        if (length == 0) {
            head = node;
            tail = node;
        } else if (length+1 <= k) {
            tail.next = node;
            node.previous = tail;
            tail = tail.next;
        } else if (length+1 > k) {
            length--;
            tail.next = node;
            node.previous = tail;
            tail = tail.next;
            map.remove(head.key);
            head = head.next;
            head.previous = null;
        }
        length++;
    }

    public int get(int key){
        Node node = map.get(key);
        if(node==null){
            return -1;
        }else{
            moveto(node);
        }
        return node.val;
    }

    public void moveto(Node node){
        if(node == tail) return;
        else if(node == head){
            head = head.next;
            head.previous = null;
        }else{
            node.next.previous = node.previous;
            node.previous.next = node.next;
        }
        tail.next = node;
        node.previous = tail;
        tail = tail.next;
        tail.next= null;
    }

    public int[] LRU(int[][] operators, int k) {
        init(k);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            switch (operators[i][0]) {
                case 1:
                    set(operators[i][1], operators[i][2], k);
                    break;
                case 2:
                    list.add(get(operators[i][1]));
                    break;
            }
        }
        int []a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }
    static class Node{
        int key;
        int val;
        Node next;
        Node previous;
    }
}
