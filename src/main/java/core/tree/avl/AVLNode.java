package core.tree.avl;

public class AVLNode {
    int value;
    int height;

    AVLNode left;
    AVLNode right;

    public AVLNode(int value) {
        this.value = value;
        this.height = 1;
    }
}
