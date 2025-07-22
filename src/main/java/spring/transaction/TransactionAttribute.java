package spring.transaction;

public class TransactionAttribute {
    private Propagation propagation;

    public TransactionAttribute(Propagation propagation) {
        this.propagation = propagation;
    }

    public Propagation getPropagation() {
        return propagation;
    }
}
