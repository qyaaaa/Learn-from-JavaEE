package javase高级.august26;

import org.junit.Test;

public class StringDemo {

    /**
     * 将一个字符串进行反转：将字符串中指定部分进行反转。比如"abcdefg"反转为"abfedcg"
     */
    //方式1：转换为char[]
    public String reverse(String str,int startIndex,int endIndex){
        if(str != null){
            char[] arr = str.toCharArray();
            for (int x = startIndex,y = endIndex;x < y;x++,y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式2,使用String拼接
    public String reverse1(String str,int startIndex,int endIndex){
        if (str != null){
            //第一部分
            String substring = str.substring(0, startIndex);
            //第二部分
            for (int i = endIndex;i >= startIndex;i--){
                substring += str.charAt(i);
            }
            //第三部分
            substring += str.substring(endIndex + 1);
            return substring;
        }
        return  null;
    }

    //方式3.使用StringBuffer或StringBuilder替换String
    public String reverse2(String str,int startIndex,int endIndex){
        if (str != null){
            StringBuilder builder = new StringBuilder(str.length());
            //第一部分
            builder.append(str.substring(0,startIndex));
            //第二部分
            for (int i =endIndex;i >= startIndex;i--){
                builder.append(str.charAt(i));
            }
            //第三部分
            builder.append(str.substring(endIndex + 1));
            return builder.toString();
        }
        return null;

    }


    @Test
    public void test1(){
        String string = "abcdefg";
        String reverse = reverse1(string, 2, 5);
        System.out.println(reverse);
    }
}
