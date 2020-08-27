package javase高级.august26;

import org.junit.Test;

public class StringDemo1 {
    /**
     * 获取一个字符串在另一个字符串中出现的次数，
     *      比如：获得"ab"在"abkkcadkabkebfkabkskab"中出现的次数
     */
    //获取subStr在mainStr中出现的次数
    //方法1
    public int getCount(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index;
        if (mainLength >= subLength){
            while((index = mainStr.indexOf(subStr)) != -1){
                count++;
                mainStr = mainStr.substring(index + subStr.length());
            }
            return count;
        }else {
            return 0;
        }
    }

    //方法2
    public int getCount1(String mainStr,String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if (mainLength >= subLength){
            while((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }
            return count;
        }else {
            return 0;
        }
    }

    @Test
    public void test1(){
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount1(mainStr, subStr);
        System.out.println(count);
    }
}
