package javase高级.sep4;

import java.io.Serializable;

/**
 * Person需满足以下条件，方可序列化
 * 1.需要实现接口Serializable
 * 2.需要当前类提供一个全局常量serialVersionUID
 * 3.除了当前Person类需要实现Serializable接口之外，还必须保证其内部所有属性也必须是可序列化的（默认情况下基本数据类型，也是可序列化的）
 *
 * 补充：ObjectOutputStream和ObjectInputStream不可序列化static和transient修饰的成员
 */
public class Person implements Serializable {
    public static final long serialVersionUID = 15665165654L;
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
}
