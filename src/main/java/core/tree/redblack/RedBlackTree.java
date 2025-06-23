package core.tree.redblack;

public class RedBlackTree {
    // 특징
    // 1. 이진 검색 트리이다.
    // 2. 색상 조정으로 트리 균형을 잡는다.
        // - 모든 노드는 Red or Black
        // - 루트는 Black
        // - Red 자식은 모두 Black
        // - 모든 경로에서 Black 수는 동일
        // - 새 노드는 항상 Red

    private RBNode root;

    public void insert(int value) {
        RBNode newNode = new RBNode(value);
        root = bstInsert(root, newNode);
        fixViolation(newNode);
    }

    private RBNode bstInsert(RBNode root, RBNode node) {
        if (root == null) return node;
        if (node.value < root.value) {
            root.left = bstInsert(root.left, node);
            root.left.parent = root;
        } else if (node.value > root.value) {
            root.right = bstInsert(root.right, node);
            root.right.parent = root;
        }
        return root;
    }

    private void fixViolation(RBNode node) {
        while (node != root && node.parent.isRed) {
            RBNode parent = node.parent;
            RBNode grandparent = parent.parent;
            // 끼야아아아아악
        }
    }
}
