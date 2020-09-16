package javase高级.sep15;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Stream的中间操作
 */
public class StreamAPITest1 {
    //1-筛选与切片
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        Stream stream = list.stream();
        stream.filter(e -> e.equals(1)).forEach(System.out::println);

        System.out.println();

        //limit(n):截断流，使其元素不超过给定的数量
        list.stream().limit(3).forEach(System.out::println);

        System.out.println();

        //skip（n）：跳过元素，返回一个扔掉了n个元素的流。若流中元素不足n个，则返回一个空流
        list.stream().skip(3).forEach(System.out::println);

        System.out.println();

        //distinct（）-筛选，通过流所生成的元素的hashCode（）和equals（）去除重复元素
        list.add(5);
        list.add(1);
        list.stream().distinct().forEach(System.out::println);
    }

    //2-映射
    @Test
    public void test2(){
        //map(Function f)接收一个函数作为参数，将元素转换成其他形式或提取信息，该元素会被应用到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);//AA,BB,CC,DD

        System.out.println();

        //练习
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToString);
        streamStream.forEach(s ->{
            s.forEach(System.out::println);
        });

        System.out.println();

        //flatMap(Function f)接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有的流练成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamAPITest1::fromStringToString);
        characterStream.forEach(System.out::println);
    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToString(String str){
        ArrayList<Character> list = new ArrayList<>();
        for (Character c: str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    //3-排序
    @Test
    public void test3(){
        //sorted()-自然排序
        List<Integer> list = Arrays.asList(12, 56, 78, 10);
        list.stream().sorted().forEach(System.out::println);


    }
}
