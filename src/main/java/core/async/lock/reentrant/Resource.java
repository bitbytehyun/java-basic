package core.async.lock.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class Resource {
    private final String name;
    private final ReentrantLock lock = new ReentrantLock();

    public Resource(String name) {
        this.name = name;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public String getName() {
        return name;
    }
}
