import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 * 线程安全有限阻塞队列
 * @author jiangzhenyue
 * @date 2021年09月13日 14:56
 */
public class BoundedBlockingQueue {
    private final LinkedList<Integer> queue = new LinkedList<>();
    private ReentrantLock lock = new ReentrantLock();
    // 判断是否为空
    private Condition empty = lock.newCondition();
    // 判断是否为满
    private Condition full = lock.newCondition();
    // 队列中元素个数
    private Integer size = 0;
    // 队列大小
    private Integer cap = null;

    /*
     * 功能描述：
     * 构造方法初始化队列，其中capacity代表队列长度上限
     * @author jiangzhenyue
     * @date 2021/9/13 15:57
     * @param capacity
     * @return null
    */
    public BoundedBlockingQueue(int capacity){
        if(lock.tryLock()){
            try {
                if (cap==null){
                    cap = capacity;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    /*
     * 功能描述：
     * 在队首增加一个element. 如果队列满，调用线程被阻塞直到队列非满
     * @author jiangzhenyue
     * @date 2021/9/13 15:57
     * @param element
    */
    public void enqueue(int element) throws InterruptedException{
        lock.lock();
        try{
            while(size >= cap){
                full.await();
            }
            // 队列在队首添加
            queue.offerFirst(element);
            size++;
            empty.signal();
        } finally {
            lock.unlock();
        }
    }

    /*
     * 功能描述：
     * 返回队尾元素并从队列中将其删除. 如果队列为空，调用线程被阻塞直到队列非空
     * @author jiangzhenyue
     * @date 2021/9/13 15:57
     * @return int
    */
    public int dequeue() throws InterruptedException {
        lock.lock();
        try {
            while (size == 0) {
                empty.await();
            }
            int res = queue.pollLast();
            size--;
            full.signal();
            return res;
        } finally {
            lock.unlock();
        }
    }

    /*
     * 功能描述：
     * 返回当前队列元素个数
     * @author jiangzhenyue
     * @date 2021/9/13 15:57
     * @return int
    */
    public int size(){
        lock.lock();
        try{
            return this.size;
        } finally {
            lock.unlock();
        }
    }
}
