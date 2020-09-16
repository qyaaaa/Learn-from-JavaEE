package javase高级.sep15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 1.Stream关注的是对数据的运算，与cpu相关
 *   集合关注的是对数据的存储，与内存相关
 *
 * 2.①Stream 自己不会存储元素
 *   ②Stream 不会改变源对象，相反，他们会返回一个持有结果的新Stream
 *   ③Stream 操作是延迟执行的。这意味着它们会等到需要结果的时候才执行
 *
 * 3.Stream执行流程
 *  ①Stream的实例化
 *  ②一系列的中间操作（过滤、映射、...........）
 *  ③终止操作
 *
 * 4.说明：
 * 4.1一个中间操作链，对数据源的数据进行处理
 * 4.2一旦执行终止操作，就执行中间操作链，并产生结果。之后，不会再被使用
 *
 * 测试Stream的实例化
 */
public class StreamAPITest {

    //创建Stream方式1:通过集合
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(1,"zjh");
        list.add(2,"my");

        //返回一个顺序流
        Stream stream = list.stream();

        //返回一个并行流
        Stream parallelStream = list.parallelStream();
    }

    //创建Stream方式2:通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4};
        IntStream stream = Arrays.stream(arr);


    }

    //创建Stream方式3:通过Stream的of（）
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);

    }

    //创建Stream方式4:创建无限流(了解)
    @Test
    public void test4(){
        //迭代
        //遍历前十个偶数
        Stream.iterate(0,t -> t + 2).limit(10).forEach(System.out::println);

        //生成
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }
}
