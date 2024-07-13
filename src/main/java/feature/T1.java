package feature;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class T1 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Person student = new Student();
        justSay(student);


        Person person = new Person();
        justSay(person);



        Class<? extends Person> aClass = student.getClass();
        Method say = aClass.getDeclaredMethod("say");

    }

    private static void justSay(Person person){
        person.say();
    }
}
