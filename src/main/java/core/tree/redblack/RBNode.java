package core.tree.redblack;

public class RBNode {
    int value;
    boolean isRed;

    RBNode left;
    RBNode right;
    RBNode parent;

    public RBNode(int value) {
        this.value = value;
        this.isRed = true;
    }
}
