package javase高级.sep11.exer;

import java.io.Serializable;

public class Creature<String> implements Serializable {
    private char gender;
    public double weight;

    private  void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西");
    }


}
