package core.tree.avl;

public class AVLTree {
    // 특징
    // 0. Binary Search 트리이다.
    // 1. 모든 노드에서 좌 서브 트리와 우 서브 트리의 높이 차가 1보다 크지 않은 채로 유지된다. => 회전으로 균형을 유지하여, 검색시 O(log n) 보장
    AVLNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }


    private AVLNode insertRecursive(AVLNode node, int value) {
        if (node == null) return new AVLNode(value);

        if (value < node.value) node.left = insertRecursive(node.left, value);
        else if (value > node.value) node.right = insertRecursive(node.right, value);
        else return node;


        // 균형 맞추기
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balance = getBalance(node);

        if (balance > 1 && value < node.left.value) return rotateRight(node); // LL
        if (balance < -1 && value > node.right.value) return rotateLeft(node); // RR
        if (balance > 1 && value > node.left.value) { // LR
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && value < node.right.value) { // RL
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return x;
    }

    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }
}
