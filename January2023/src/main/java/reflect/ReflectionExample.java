package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void getClassInformation(Class<?> clazz) {
        System.out.println("Class name: " + clazz.getName());

        Field[] fields = clazz.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            System.out.println(field.getType().getSimpleName() + " " + field.getName());
        }

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println(method.getReturnType().getSimpleName() + " " + method.getName());
        }
    }

    public static void invokeMethod(Object object, String methodName) throws Exception {
        Method method = object.getClass().getDeclaredMethod(methodName);
        method.invoke(object);
    }

    public static void invokeMethod(Class object, String methodName) throws Exception {
        Method method = Class.class.getDeclaredMethod(methodName);
        method.invoke(object);
    }

    public static void main(String[] args) throws Exception {
        // Create an instance of the Person class
//        Person person = new BullPerson("Alice", 30);

        String className = "reflect.YellowPerson";
        Object person = null;
        try {
            // 使用Class.forName方法加载类
            Class<?> personClass = Class.forName(className);

            // 实例化对象
            person = personClass.newInstance();

            // 打印Class对象的名称
            System.out.println("Class name: " + personClass.getName());

            // 可以使用Class对象进行其他反射操作，比如获取类的方法和字段等
            // 这里仅打印示例，不进行其他操作
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error creating instance of class: " + className);
        }


        // Get class information using reflection
        getClassInformation(Person.class);

        // Invoke the "sayHello" method using reflection
//        invokeMethod(person, "sayHello");
        invokeMethod(person, "sayHello");
    }

    private Object getClass(String className) {
        Object person = null;
        try {
            // 使用Class.forName方法加载类
            Class<?> personClass = Class.forName(className);

            // 实例化对象
            person = personClass.newInstance();

            // 打印Class对象的名称
            System.out.println("Class name: " + personClass.getName());

            // 可以使用Class对象进行其他反射操作，比如获取类的方法和字段等
            // 这里仅打印示例，不进行其他操作
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + className);
        } catch (InstantiationException | IllegalAccessException e) {
            System.out.println("Error creating instance of class: " + className);
        }
        return person;
    }
}
