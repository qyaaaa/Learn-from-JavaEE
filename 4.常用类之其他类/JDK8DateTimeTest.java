package javase高级.august28;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间API的测试
 */
public class JDK8DateTimeTest {
    @Test
    public void test1(){
        //偏移量
        Date date = new Date(2020 - 1900,9 - 1,8);
        System.out.println(date);//Tue Sep 08 00:00:00 GMT+08:00 2020
    }

    /**
     * localDate localTime localDateTime的使用：
     *      说明：1.LocalDateTime相较于LocalDate,LocalTime，使用频率要高
     *           2。类似于Calender
     */
    @Test
    public void test2(){
        //now():获取当前的日期、时间、日期+时间
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();

        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);

        //of():设置指定的年、月、日、时、分、秒。没有偏移量
        LocalDateTime localDateTime = LocalDateTime.of(2020, 10, 1, 11, 20, 20);
        System.out.println(localDateTime);

        //getXxx()：获取相关属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getDayOfYear());

        //体现不可变性
        //withXxx：设置相关的属性
        LocalDateTime localDateTime1 = localDateTime.withDayOfMonth(22);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //不可变性
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.minusDays(6);
        System.out.println(localDateTime3);
    }

    /**
     * Instant的使用：
     * 类似于java.util.Date
     */
    @Test
    public void test3(){
        //now():获取本初子午线对应的标准时间
        Instant now = Instant.now();
        System.out.println(now);

        //添加偏移量
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取1970至今的毫秒数
        long l = now.toEpochMilli();
        System.out.println(l);

        //通过给定的毫秒数，获取Instant实例
        Instant instant = Instant.ofEpochMilli(1598601663128l);
        System.out.println(instant);
    }

    /**
     * DateTimeFormatter:格式化或解析日期、时间
     * 类似于SimpleDateFormat
     */
    @Test
    public void test4(){
        //实例化方式一：预定义的标准格式
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化
        LocalDateTime now = LocalDateTime.now();
        String format = dateTimeFormatter.format(now);
        System.out.println(now);
        System.out.println(format);

        //解析
        TemporalAccessor parse = dateTimeFormatter.parse("2020-08-28T16:10:50.826");
        System.out.println(parse);

        //方法2：本地化相关的方式：
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        //格式化
        String format1 = dateTimeFormatter1.format(now);
        System.out.println(format1);

        //重点：方式三：自定义的格式
        DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String format2 = dateTimeFormatter2.format(LocalDateTime.now());
        System.out.println(format2);

        //解析
        TemporalAccessor parse1 = dateTimeFormatter2.parse("2020-08-28 04:24:18");
        System.out.println(parse1);
    }
}
