package core.async.lock.synchro;

import java.util.ArrayList;
import java.util.List;

public class SafeList {
    private List<String> list = new ArrayList<>();

    public void add(String item) {
        synchronized (list) {
            list.add(item);
        }
    }

    public List<String> getSnapshot() { // 원본이 훼손되지 않는 매서드
        synchronized (list) { // synchronized 파라미터 : 락을 걸 객체
            return new ArrayList<>(list);
        }
    }
}
