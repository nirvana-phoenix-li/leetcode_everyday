package reflect;

public class RedPerson extends Person {

    public RedPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public RedPerson() {
    }

    @Override
    public void sayHello() {
        System.out.println("red, my name is " + name + " and I am " + age + " years old.");
    }
}
