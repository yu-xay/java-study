package src;

public class Test {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                System.out.println("x");
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2000; i++) {
                System.out.println(i);
            }
        });
        getThread();

        t2.start();
        t1.start();
    }

    public static void getThread() {
        Thread t = Thread.currentThread();
        System.out.println("运行dosome方法的线程是:" + t);
    }


}
