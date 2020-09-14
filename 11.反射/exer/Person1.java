package javase高级.sep11.exer;

@MyAnnotation(value = "hi")
public class Person1 extends Creature<String> implements Comparable<String>, MyInterface {
    @Override
    public int compareTo(String o) {
        return 0;
    }

    @Override
    public void info() {
        System.out.println("人");
    }

    private String name;
    int age;

    public int id;

    public Person1(){}

    @MyAnnotation(value = "abc")
    private Person1(String name){
        this.name = name;
    }

    Person1(String name, int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是" + nation);
        return nation;
    }

    public String display(String interests)throws Exception{
        return interests;
    }

    @Override
    public String toString() {
        return "Person1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    private static void showDesc(){
        System.out.println("可爱的人");
    }

}
