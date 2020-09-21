package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner num = new Scanner(System.in);

        //task1
        int a= num.nextInt();
        int b= num.nextInt();
        System.out.println(remainder(a,b));

        //task2
        int a2= num.nextInt();
        int h2= num.nextInt();
        System.out.println(triArea(a2,h2));

        //task3
        int a3= num.nextInt();
        int b3= num.nextInt();
        int c3= num.nextInt();
        System.out.println(animals(a3,b3,c3));

        //task4
        float prob = num.nextFloat();
        float price = num.nextFloat();
        float pay = num.nextFloat();
        System.out.println(profitableGamble(prob,price,pay));

        //task5
        int N5 = num.nextInt();
        int a5 = num.nextInt();
        int b5 = num.nextInt();
        operation(N5, a5, b5);

        //task6
        char i = num.next().charAt(0);
        System.out.println(ctoa(i));

        //task7
        int i7 = num.nextInt();
        System.out.println(addUpTo(i7));

        //task8
        int a8 = num.nextInt();
        int b8 = num.nextInt();
        System.out.println(nextEdge(a8,b8));

        //task9
        Scanner str = new Scanner(System.in);
        String l = str.nextLine();
        String l1[]=l.split(" ");
        int[] Array = new int[l1.length];
        for(int j=0;j<l1.length;j++)
        {
            Array[j]=Integer.parseInt(l1[j]);
        }
        System.out.println(sumOfCubes(Array));

        //task10
        int a10 = num.nextInt();
        int b10 = num.nextInt();
        int c10 = num.nextInt();
        System.out.println(abcmath(a10,b10,c10));
    }
    public static int remainder(int a,int b){
        if(b==0){
            Scanner num = new Scanner(System.in);
            System.out.print("На ноль делить нельзя, введите новую вторую переменную: ");
            b= num.nextInt();
        }
        int c=a%b;
        return c;
    }
    public static int triArea(int a,int b){
        int c=Math.abs(a*b/2);
        return c;
    }
    public static int animals(int a,int b,int c){
        int d = 2*a + 4*b + 4*c;
        return d;
    }
    public static boolean profitableGamble(float prob, float price, float pay){
        if(prob*price-pay>0){
            return true;
        }
        else return false;
    }
    public static void operation(int N, int a, int b) {
        if (N - (a + b) == 0) {
            System.out.println("added");
        } else if (N - (a - b) == 0) {
            System.out.println("subtracted");
        } else if (N - a * b == 0) {
            System.out.println("multiplied");
        } else if (N - a / b == 0) {
            System.out.println("divided");
        } else {
            System.out.println("none");
        }

    }
    public static int ctoa(char i)
    {
        int k=(int) i;
        return k;
    }
    public static int addUpTo(int i)
    {
        int sum=0;
        int k=1;
        while (k<=i)
        {
            sum+=k;
            k++;
        }
        return sum;
    }
    public static int  nextEdge(int a, int b)
    {
        int c = a+b-1;
        return c;
    }
    public static int sumOfCubes(int[] Array)
    {
        int k=0;
        for(int i=0;i<Array.length;i++){
            k+=Math.pow(Array[i],3);
        }
        return k;
    }
    public static boolean abcmath(int a, int b, int c)
    {
        double s = a*Math.pow(2,b);
        if(s%c==0)
            return true;
        else
            return false;
    }
}
