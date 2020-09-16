package javase高级.sep15.exer;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional类：为了在程序中避免出现空指针异常而创建的
 *
 * 常用的方法： ofNullable（T t）
 *            orElse（T t）
 */
public class OptionalTest {

    //Optional.of(T t):创建一个Optional的实例，t必须非空3(p-684)
    @Test
    public void test1(){
        Girl girl = new Girl();
        //of（T t）保证t是非空的
        Optional<Girl> girl1 = Optional.of(girl);

    }

    //Optional.empty(T):创建一个空的Optional的实例
    //Optional。ofNullable（T t）：t可以为null
    @Test
    public void test2(){
        Girl girl = new Girl();
        Optional<Girl> girl1 = Optional.ofNullable(girl);
        System.out.println(girl1);

        Girl girl2 = girl1.orElse(new Girl("赵丽颖"));
        System.out.println(girl2);
    }

    //优化之前
    public String getGirlName(Boy boy){
        return boy.getGirl().getName();
    }

    @Test
    public void test3(){
        Boy boy = new Boy();
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    //优化以后的getGirlName（）
    public String getGirlName1(Boy boy){
        if (boy != null){
            Girl girl = boy.getGirl();
            if (girl != null){
                return girl.getName();
            }
        }
        return null;
    }

    @Test
    public void test4(){
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName1(boy);
        System.out.println(girlName);
    }

    //使用Optional类的getGirlName（）：
    public String getGirlName2(Boy boy){

        Optional<Boy> boy1 = Optional.ofNullable(boy);

        Boy boy2 = boy1.orElse(new Boy(new Girl("迪丽热巴")));
        Girl girl = boy2.getGirl();

        Optional<Girl> girl1 = Optional.ofNullable(girl);
        Girl girl2 = girl1.orElse(new Girl("古力娜扎"));

        return girl2.getName();
    }

    @Test
    public void test5(){
        Boy boy = null;
        boy = new Boy();
        String girlName = getGirlName2(boy);
        System.out.println(girlName);

    }
}
