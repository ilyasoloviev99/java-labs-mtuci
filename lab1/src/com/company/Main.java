package com.company;
import java.util.Random;
import java.util.Scanner;
class TWO extends Thread
{
    @Override
    public void run()
    {
        while (true){
            if(Main.result%2==0)
                System.out.println(Main.result*2+"-2 поток");
            try {
                // Приостанавливаем поток
                sleep(1000);
            }catch(InterruptedException e){}
        }
    }
}
class THREE extends Thread
{
    @Override
    public void run()
    {
        while (true){
            if(Main.result%2!=0)
                System.out.println(Main.result*Main.result*Main.result+"-3 поток");
            try {
                // Приостанавливаем поток
                sleep(1000);
            }catch(InterruptedException e){}
        }
    }
}
public class Main
{
    public static int result;
    public static void main(String[] args)
    {
        TWO two = new TWO (); // Создание потока
        final Random random = new Random();
        result=random.nextInt(1000);
        THREE three = new THREE();
        three.start();
        boolean c =true;
        two.start(); // Запуск потока
        while (c){
            Scanner keyboard = new Scanner(System.in);
            result=random.nextInt(1000);
            System.out.println(result+"-1 поток");
            try {
                // Приостанавливаем поток
                Thread.sleep(1000);
            }catch(InterruptedException e){}

        }

    }
}
