package core.async.lock.reentrant;

public class ResourceManager {
    public void safeTransfer(Resource r1, Resource r2) {

        // 락 획득 순서를 강제 통일
        Resource first = r1.getName().compareTo(r2.getName()) < 0 ? r1 : r2;
        Resource second = (first == r1) ? r2 : r1;

        first.getLock().lock();
        second.getLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " safely transferring from " + first.getName() + " to " + second.getName());
        } finally {
            second.getLock().unlock();
            first.getLock().unlock();
        }
    }

}
