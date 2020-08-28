package javase高级.august28;

import org.junit.Test;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1.System类中currentTimeMillis（）
 * 2.java.util.Date 和 java.sql.Date
 * 3.simpleDateFormat
 * 4.Calendar
 */
public class DateTimeTest1 {
    /**
     * SimpleDateFormat的使用：SimpleDateFormat对日期Date类的格式化和解析
     *
     * 1.两个操作：
     * 1。1格式化：日期 -->字符串
     * 1.2解析：格式化的逆过程， 字符串 -->日期
     *
     * 2.SimpleDateFormat的实例化
     */
    @Test
    public void test1() throws ParseException {
        //实例化SimpleDateFormat:使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();

        //格式化：日期 -->字符串
        Date date = new Date();
        System.out.println(date);

        String format = sdf.format(date);
        System.out.println(format);

        //解析：字符串 -->日期
        String str = "20-8-28 下午2:18";
        try {
            Date date1 = sdf.parse(str);
            System.out.println(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //按照指定的方式格式化：调用带参的构造器
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = sdf1.format(date);
        System.out.println(format1);

        //解析:要求字符串必须符合SimpleDateFormat识别的格式（通过构造器参数体现）
        Date date1 = sdf1.parse("2020-08-28 02:28:48");
        System.out.println(date1);
    }

    /**
     * 练习1：字符串"2020-09-08"转换为java.sql.Date
     */
    @Test
    public void test2() throws ParseException {
        String info = "2020-09-08";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(info);
        System.out.println(date);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);

    }

    /**
     * Calender日历类使用：
     */
    @Test
    public void test3(){
        //1.实例化
        //方式1：创建其子类（GregorianCalendar）的对象
        //方式2：调用其静态方法getInstance()
        Calendar calendar = Calendar.getInstance();

        //2.常用方法
        //get（）
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //set（）
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add（）
        calendar.add(Calendar.DAY_OF_MONTH,3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime（）:日历类 -->Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime（）:Date -->日历类
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }
}
