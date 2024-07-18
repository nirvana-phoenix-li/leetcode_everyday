package test;

public class Hello {
    volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        System.out.println("outside thread is running");
        Thread.sleep(3000);
        //采用异步多线程方式处理
        Thread thread = new Thread(() -> {
            System.out.println("inner thread is running");

        });
        thread.start();
    }
}