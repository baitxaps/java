package cn.test;

import java.io.Serializable;

public class Person implements Serializable {
    private static final long serialVersionUID = 42L; //修改文件不异常
    private String name;
   // public String name;
    private transient int age; // transient 不被序列化

    public Person() {
        //no instance
    }

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public void eat() {

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
