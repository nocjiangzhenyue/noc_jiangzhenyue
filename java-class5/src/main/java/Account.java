import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 * 账户类，实现两个帐户之间的转账
 * @author jiangzhenyue
 * @date 2021年09月13日 14:55
 */
public class Account {
    private final String name;

    public Account(String name) {
        this.name = name;
    }

    private int balance;
    final Lock lock = new ReentrantLock();

    // 转账方法
    // 是线程安全的，因为确保了操作的两个对象都加了锁才会进行转账操作，并且确保了锁的释放
    // 但是有可能会出现转账失败的情况
    // 转账方法不应该写死？
    void transfer(Account tar, int amt) {
        while (true) {
            if (this.lock.tryLock()) {
                try {
                    if (tar.lock.tryLock()) {
                        try {
                            this.balance -= amt;
                            tar.balance += amt;
                            System.out.println(this.name+":"+this.balance);
                            System.out.println(tar.name +":"+tar.balance);
                        } finally {
                            tar.lock.unlock();
                        }
                    }
                } finally {
                    this.lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args) {
        Account account1 = new Account("帐户1");
        Account account2 = new Account("帐户2");
        Thread t1 = new Thread((() -> account1.transfer(account2, 100)));
        Thread t2 = new Thread((() -> account2.transfer(account1, 100)));
        t1.start();
        t2.start();
    }
}

