package javase高级.sep1;

import java.util.Objects;

public class Person implements Comparable{
    private String name;
    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

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

    //按照姓名从小到大排序,年龄从小到大排列
    @Override
    public int compareTo(Object o) {
        if (o instanceof Person){
            Person p = (Person)o;
            int compare = this.name.compareTo(p.name);
            if (compare != 0){
                return this.name.compareTo(p.name);
            }else {
                return Integer.compare(this.age,p.age);
            }
        }else {
            throw new RuntimeException("数据类型不一致");
        }
    }
}
