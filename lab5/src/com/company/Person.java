package com.company;

import java.util.Scanner;

public class Person {
    public static int health_points = 100;
    public static String getname(){
        Scanner name = new Scanner(System.in);
        System.out.print("Введите имя игрока: ");
        String n = name.nextLine();
        String person_name = n;
        return person_name;
    }
}
