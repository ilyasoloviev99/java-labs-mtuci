package com.company;
import javax.print.attribute.standard.MediaSize;
import java.util.Random;
public class enemy {
    public static int health_points = Person.health_points;
    public static int number = (int) (Math.random() * 20);
    public static String NAME="";

    public static void health(int k,String name) {
        NAME=name;
        boolean y = true;
        if (k == number) {
            health_points -= 10;
            System.out.println("Вы угадали, теперь у врага с именем " + name + " " + health_points + " жизней");
        } else if (k > number)
            System.out.println("Вы не угадали. Число, что вы пытаетесь угадать меньше.");
        else System.out.println("Вы не угадали. Число, что вы пытаетесь угадать больше.");
    }
}

