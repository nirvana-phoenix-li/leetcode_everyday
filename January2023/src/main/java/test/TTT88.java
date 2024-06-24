package test;

import designMode.SingletonDoubleCheckLazy;

public class TTT88 {
    public static void main(String[] args) {
//        try {
//            Class<?> aClass = Class.forName("designMode.SingletonDoubleCheckLazy");
//            Object o = aClass.newInstance();
//            System.out.println(o instanceof SingletonDoubleCheckLazy);
//            SingletonDoubleCheckLazy single = (SingletonDoubleCheckLazy) o;
//            System.out.println(single == SingletonDoubleCheckLazy.getInstance());
//
//
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }

        try {
            Class<?> aClass = Class.forName("designMode.SingletonEnum");
            Object o = aClass.newInstance();
            System.out.println(o instanceof SingletonDoubleCheckLazy);
            SingletonDoubleCheckLazy single = (SingletonDoubleCheckLazy) o;
            System.out.println(single == SingletonDoubleCheckLazy.getInstance());



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
