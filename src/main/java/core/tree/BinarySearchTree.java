package core.tree;

public class BinarySearchTree {
    // 특징
    // 0. 각 노드는 값을 하나씩 가지며, 각 노드의 값은 모두 다르다.
    // 1. 최상위 레벨에 루트 노드가 있고, 각 노드는 최대 2개의 자식 노드를 갖는다.
    // 2. 임의 노드의 값은 자신의 왼쪽 아래에 있는 모든 노드의 값보다 크고, 오른쪽보다는 작다.

    TreeNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    public boolean contains(int value) {
        return containsRecursive(root, value);
    }

    public void inOrderTraversal(TreeNode node) {
        inOrderRecursive(root);
        System.out.println();
    }


    private void inOrderRecursive(TreeNode node) {
        if (node == null) return;
        inOrderRecursive(node.left);
        System.out.println(node.value + " ");
        inOrderRecursive(node.right);
    }

    private boolean containsRecursive(TreeNode node, int value) {
        if (node == null) return false; // C(null, v) = false
        if (value == node.value) return true;
        if (value < node.value) {
            return containsRecursive(node.left, value);  // C(n) = C(n.left, v)
        } else {
            return containsRecursive(node.right, value); // C(n) = C(n.right, v)
        }
    }

    private TreeNode insertRecursive(TreeNode node, int value) {
        if (node == null) return new TreeNode(value);        // I(null, v) = TreeNode(v)
        if (value < node.value) {
            node.left = insertRecursive(node.left, value);   // I(n) : n.left = I(n.left, v)
        } else if (value > node.value) {
            node.right = insertRecursive(node.right, value); // I(n) : n.right = I(n.right, v)
        }
        return node;                                        // left, right 참조되어 있기 때문에 n 자체가 결과
    }
}
