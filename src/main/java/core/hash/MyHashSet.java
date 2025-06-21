package core.hash;

public class MyHashSet {
    // 구조 : 노드(K)로 구성된 배열
    static class Node {
        final int key;
        Node next;

        Node(int key) {
            this.key = key;
        }
    }

    private static final int SIZE = 16;
    private Node[] table = new Node[SIZE];

    private int hash(int key) {
        return Math.abs(Integer.hashCode(key)) % SIZE;
    }

    public void add(int key) {
        int index = hash(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) return; // 중복이면 무시한다.
            curr = curr.next;
        }
        Node newNode = new Node(key);
        newNode.next = table[index];
        table[index] = newNode;
    }

    public boolean contains(int key) {
        int index = hash(key);
        Node curr = table[index];
        while (curr != null) {
            if (curr.key == key) return true;
            curr = curr.next;
        }
        return false;
    }

    public void remove(int key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev != null) table[index] = curr.next;
                else prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}
