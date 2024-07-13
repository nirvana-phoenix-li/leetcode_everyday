package reflect;

public class BullPerson extends Person {

    public BullPerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public BullPerson() {
    }
    @Override
    public void sayHello() {
        System.out.println("blue, my name is " + name + " and I am " + age + " years old.");
    }
}
