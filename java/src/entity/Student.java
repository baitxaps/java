package entity;

public class Student extends Person {
    public Student() {
        //no instance
    }
    public  Student(String name, int age ) {
        super(name,age);
    }

    @Override
    public void eat() {
        super.eat();
    }

    public void setAge(int age) {
        if (age>0) {
            super.setAge(age);
        }
    }

    public void show() {
        System.out.println("name: "+getName() + " age: " + getAge());
    }



}
