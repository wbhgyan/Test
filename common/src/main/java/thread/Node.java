package thread;


import java.util.LinkedList;

public class Node {

    private Integer value;
    private Node next;
    private  int size;

    Node(Integer value) {
        this.value = value;
    }


    public static void main(String[] args) {

        //4>5>6
        Node node1 = new Node(4);
        node1.put(5).put(6);

        //4>6>7>9
        Node node2 = new Node(4);
        node2.put(6).put(7).put(9);
        System.out.println(node1.index(0));
        Node node3 = add(node1, node2);
    }

    public static Node add(Node node1, Node node2) {
        //TODO node3=node1+node2;
        int m=node1.size,n=node2.size;
        Node node3 =null;
        for(int i=0;(m-i)>0&&(n-i)>0;i++){
            node3 = new Node(node1.index(m).value+ node2.index(n).value);
            System.out.println(node3);
        }
        return node3;
    }

    Node put(int value) {
        Node node = new Node(value);
        this.next = node;
        this.size++;
        return node;
    }


    Node index(int index) {
        Node node = this;
        for (int i = 0; i <=index; i++) {
            if(index==i) return node;
            node = node.next;
        }
        return node;

    }

    @Override
    public String toString() {
        return this.value+"";
    }
}
