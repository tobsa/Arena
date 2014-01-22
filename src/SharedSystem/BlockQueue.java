package SharedSystem;

import GameSystem.Move;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BlockQueue {
    private List<Move> list = new ArrayList();
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private static BlockQueue instance = null;
    
    private BlockQueue() {}
    
    public static BlockQueue getInstance() {
        if(instance == null)
            instance = new BlockQueue();
        
        return instance;
    }
    
    public void add(Move value) {
        lock.lock();
        try {
            if(list.isEmpty()) {
                list.add(value);
                condition.signal();
            }
        } finally {
            lock.unlock();
        }
    }
    
    public Move take() throws InterruptedException {
        lock.lock();
        try {
            while(list.isEmpty())
                condition.await();
            
            return list.remove(0);
        } finally {
            lock.unlock();
        }
    }
    
    public void clear() {
        lock.lock();
        try {
            list.clear();
        } finally {
            lock.unlock();
        }
    }
}
