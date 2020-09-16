package javase高级.sep15;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * 测试Stream的终止操作
 */
public class StreamTest {
    //1-匹配与查找（p-680）
    @Test
    public void test1(){
        //allMath(Predicate p)-检查是否匹配所有的元素
        //。。。。。。。。。
    }

    //2-归约（p-681）
    @Test
    public void test2(){
        //reduce（T identity，BinaryOperator）-可以将流中元素反复结合起来，得到一个值，返回Optional<T>
        //1到10的和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        //reduce(BinaryOperator)-可以将流中元素反复结合起来，得到一个值，返回Optional<T>
    }

    //3-收集（p-682）
    @Test
    public void test3(){
        //collect(Collector c)-将流转换为其他形式，接受一个Collector接口的实现，用于给Stream
    }
}
