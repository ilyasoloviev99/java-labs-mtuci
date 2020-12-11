package com.company;

public class player {
    public static int health_points = Person.health_points;
    public static int number = (int) (Math.random() * 20);
    public static String NAME="";

    public static void health(String name) {
        int k = (int) (Math.random() * 20);
        NAME=name;
        boolean y = true;
        if (k == number) {
            health_points -= 10;
            System.out.println("Враг попал в вас. У " + name + " осталось " + health_points + " жизней");
        } else
            System.out.println("Враг не угадал число");
    }
}
