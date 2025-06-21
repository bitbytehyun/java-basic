package core.hash;

import java.util.Objects;

public class MyHashMap {
    // 구조 : 노드(K,V)로 구성된 배열
    public static class Node {
        final String key;
        String value;
        Node next;

        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int TABLE_SIZE = 16;
    private Node[] table = new Node[TABLE_SIZE];

    private int hash(String key) {
        return Math.abs(Objects.hashCode(key)) % TABLE_SIZE;
    }

    public void put(String key, String value) {
        int index = hash(key);
        Node head = table[index];
        // 이미 존재하는 key 이라면, 덮어쓰기
        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.key.equals(key)) {
                curr.value = value;
                return;
            }
        }
        // 없는 key 이라면, 배열에 삽입
        Node newNode = new Node(key, value);
        newNode.next = head;
        table[index] = newNode;
    }

    public String get(String key) {
        int index = hash(key);
        Node curr = table[index];

        while (curr != null) {
            if (curr.key.equals(key)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        Node curr = table[index];
        Node prev = null;

        while (curr != null) {
            if (curr.key.equals(key)) {
                if (prev == null) {
                    table[index] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

}
