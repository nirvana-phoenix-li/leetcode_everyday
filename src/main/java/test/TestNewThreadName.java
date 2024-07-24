package test;

public class TestNewThreadName {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            try {
                System.out.println("thread1 start");
                test();
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "threadName");

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " start");
                test();

                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "threadName");

        thread1.start();
        thread2.start();
        System.out.println();

    }

    private static void test() {
        System.out.println("Innnnnnnner");
    }
}
