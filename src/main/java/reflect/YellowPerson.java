package reflect;

public class YellowPerson extends Person {

    public YellowPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public YellowPerson() {
    }

    @Override
    public void sayHello() {
        System.out.println("Yellow, my name is " + name + " and I am " + age + " years old.");
    }
}
