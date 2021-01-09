package cn.huse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HuseThread extends Thread {
    public HuseThread() {
        //no instance
    }

    public HuseThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + ":" + i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    public static void threadRun() {
        HuseThread run1 = new HuseThread("ticket");
        HuseThread run2 = new HuseThread("subway");
        HuseThread run3 = new HuseThread("car");
        run1.setDaemon(true); // 标为守护线程，当运行的线程都是守护线程时，java虚拟机退出
        run2.setDaemon(true);
        run3.setDaemon(true);
        run1.start();
//        try {
//            run1.join();// wait for the thread dead;
//        }catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        run2.start();
        run3.start();

        Thread.currentThread().setName("bike");
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
        System.out.println(Thread.currentThread().getName());
    }

    public static void runableTest() {
        Box b = new Box();
        Producer p = new Producer(b);
        Customer c = new Customer(b);//alt +enter
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();

//        SellTicket ticket1 = new SellTicket();
//        Thread t1 = new Thread(ticket1, "window1");
//        Thread t2 = new Thread(ticket1, "window2");
//        Thread t3 = new Thread(ticket1, "window3");
//        t1.start();
//        t2.start();
//        t3.start();

//        HuseRunnable a1 = new HuseRunnable();
//        HuseRunnable a2 = new HuseRunnable();
//        Thread t1 = new Thread(a1,"subway");
//        Thread t2 = new Thread(a2,"airplane");
//
//        t1.start();
//        t2.start();
    }
}

class HuseRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class SellTicket implements Runnable {
    /*
    三条都满足：
    1.是否有多线程环境
    2.是否有共享数据
    3.是否有多条语句操作共享数据
     */
    private int tickets = 100;
    private Object obj = new Object();
    private Lock lock = new ReentrantLock();
    // obj => this, static => className.class
    /*
    thread safe ，如果不需安全，可用=>后替代
    StringBuff ,    => StringBuilder
    Vector,         => ArrayList
    Hashtable,      => HasMap

    also  to use  collections.synchronizedList
     */

    @Override
    public void run() {
        while (true) {
            // List<String> list = Collections.synchronizedList(new ArrayList<>());
            lock.lock();
            // synchronized (obj) {
            if (tickets > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出售第" + tickets + "张票");
                tickets--;
            }
            lock.unlock();
        }
    }
}


// Producer - Customer-----------
class Box {
    private int milk;
private boolean state;
    public synchronized void put(int milk) {
        if(state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.milk = milk;
        System.out.println("sender give the " + this.milk + "  bottles of  milk to the box");
        state = true;
        // wake up
        notifyAll();
    }

    public synchronized void get() {
        if (!state) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("user get the " + this.milk + " bottles of milk from  the box");
        state = false;
        notifyAll();
    }
}


class Producer implements Runnable {
    private Box b;

    public Producer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            b.put(i);
            // System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }
}

class Customer implements Runnable {
    private Box b;
    public Customer(Box b) {
        this.b = b;
    }

    @Override
    public void run() {
        while (true) {
            this.b.get();
        }
    }
}
// Producer - Customer----------- end




