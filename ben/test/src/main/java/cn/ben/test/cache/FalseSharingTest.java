package cn.ben.test.cache;

public class FalseSharingTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            Benchmark();
        }
    }

    public static void Benchmark() throws InterruptedException {
        int size = Runtime.getRuntime().availableProcessors();
        SharingLong[] shares = new SharingLong[size];
        for (int i = 0; i < size; i++) {
            shares[i] = new SharingLong();
        }
        Thread[] threads = new Thread[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new LightThread(shares, i);
        }

        for (Thread t : threads) {
            t.start();
        }
        long start = System.currentTimeMillis();
        for (Thread t : threads) {
            t.join();
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}

class SharingLong {
    //去掉volatile 性能提升
    volatile long v;
    //注释此行性能降低
    long p0,p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
}

class LightThread extends Thread {
    SharingLong[] shares;
    int index;

    LightThread(SharingLong[] shares, int index) {
        this.shares = shares;
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000000; i++) {
            shares[index].v++;
        }
    }
}