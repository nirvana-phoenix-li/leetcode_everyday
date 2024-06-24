package designMode;

public class SingletonDoubleCheckLazy {
    private volatile static SingletonDoubleCheckLazy singleton;

    public SingletonDoubleCheckLazy() {
        System.out.println(Thread.currentThread().getName() + "--------------------------");
    }


    public static SingletonDoubleCheckLazy getInstance() {
        if (singleton == null) {
            synchronized (SingletonDoubleCheckLazy.class) {
                if (singleton == null) {
                    singleton = new SingletonDoubleCheckLazy();
                }
            }
        }
        return singleton;
    }
}
