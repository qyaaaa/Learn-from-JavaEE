package javase高级.august29;

import java.util.ArrayList;

/**
 * 注解的使用：
 * 1.理解Annotation：
 * ①JDK5.0新增的功能
 * ②Annotation其实就是代码里的特殊标记，这些标记可以在编译，类加载，运行时被读取，，并进行相应的处理
 *   通过使用Annotation，程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息，代码分析工具、
 *   开发工具和部署工具可以通过这些补充信息进行验证或者进行部署。
 * ③在JavaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中遗留
 *   的繁冗代码和XML配置等
 *
 * 2.Annotation的使用示例：
 *  示例一：生成文档相关的注解
 *  示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 * @Override:限定重写父类的方法，该注解只能用于方法
 * @Deprecated:用于表示所修饰的元素（类、方法）已过时
 * @SuppressWarnings:抑制编译器警告
 *  示例三：跟踪代码依赖性，实现替代配置文件功能
 *
 * 3.如何自定义注解：参照@SuppressWarnings定义
 *  ①注解声明为@interface
 *  ②内部定义成员，通常使用value表示
 *  ③可以指定成员的默认值，使用default定义
 *  ④如果自定义注解没有成员，表明是一个标识作用
 *
 *  如果注解有成员，在使用注解时，需要指明成员的值
 *  自定义注解必须配上信息处理流程（使用反射）才有意义
 *  自定义注解通常都会指明两个元注解：Retention、Target
 *
 * 4.Jdk提供的四种元注解
 *  元注解：对现有的注解进行解释说明的注解
 *      Retention:指定是所修饰的Annotation的生命周期：SOURCE\CLASS(默认行为)\RUNTIME
 *                只有声明为RUNTIME生命周期的注解，才能通过反射获取
 *      Target:用于指定被修饰的Annotation能用于修饰那些程序元素
 *
 *      *****出现频率较低******
 *      Documented:表示所修饰的注解在被javadoc解析时，保留下来。
 *      Inherited:被他修饰的Annotation将具有继承性
 *
 * 5.通过反射获取注解信息 --- 到反射内容时系统讲解
 *
 * 6.JDK 8中注解的新特性：可重复注解、类型注解
 *
 * 6.1可重复注解：①在MyAnnotation上声明@Repeatable，成员值位MyAnnotations。class
 *              ③MyAnnotation的Target和Retention等元注解与MyAnnotations相同
 *
 *6.2类型注解：
 *  ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）
 *  ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中
 */
@MyAnnotation(value = "hi")
public class AnnotationTest {
    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int num = 10;

        @SuppressWarnings({"unused","rawtypes"})
        ArrayList list = new ArrayList();
    }
}

class Generic<@MyAnnotation T>{
    public void show()throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10l;
    }
}
