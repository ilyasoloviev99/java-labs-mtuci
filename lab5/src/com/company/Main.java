package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        boolean result=true;
        boolean count = true;
        String name1 = Person.getname();
        String name = Person.getname();
        while (result) {
            if(count==true) {
                System.out.println("Введите число от 1 до 20: ");
                int k = (int) (Math.random() * 20);
                /*/int k = t.nextInt();

                 */
                enemy.health(k, name);
            }
            else if(count==false)
                player.health(name1);
            if(enemy.health_points==0){
                System.out.println(player.NAME + " победил");
                result=false;
            }
            else if(player.health_points==0) {
                System.out.println(enemy.NAME + " победил");
                result=false;
            }
            count=!count;
        }
    }
}
