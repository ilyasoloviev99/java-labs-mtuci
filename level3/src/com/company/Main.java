package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Task1
        Scanner num = new Scanner(System.in);
        int a = num.nextInt();
        int b = num.nextInt();
        int c = num.nextInt();
        System.out.println(solutions(a,b,c));


        //Task2
        Scanner str = new Scanner(System.in);
        String str1 = str.nextLine();
        System.out.println(findZip(str1));

        //Task3
        Scanner num3 = new Scanner(System.in);
        int n3 = num3.nextInt();
        System.out.println(checkPerfect(n3));

        //Task4
        Scanner str4 = new Scanner(System.in);
        String str14 = str4.nextLine();
        System.out.println(flipEndChars(str14));

        //Task5
        Scanner str5 = new Scanner(System.in);
        String str15 = str5.nextLine();
        System.out.println(isValidHexCode(str15));

        //Task6
        Scanner str6 = new Scanner(System.in);
        String str16 = str6.nextLine();
        String[] str26 = str16.split(" ");
        int Array6[] = new int[str26.length];
        for(int i=0; i<str26.length; i++){
            Array6[i] = Integer.parseInt(str26[i]);
        }
        String S6 = str6.nextLine();
        String[] S16 = S6.split(" ");
        int Array16[] = new int[S16.length];
        for(int i=0; i<S16.length; i++){
            Array16[i] = Integer.parseInt(S16[i]);
        }
        System.out.println(same(Array6,Array16));

        //Task7
        Scanner num7 = new Scanner(System.in);
        int n7 = num7.nextInt();
        System.out.println(isKaprekar(n7));

        //Task8
        Scanner str8 = new Scanner(System.in);
        String str18 = str8.nextLine();
        System.out.println(longestZero(str18));

        //Task9
        Scanner num9 = new Scanner(System.in);
        int n9 = num9.nextInt();
        System.out.println(nextPrime(n9));

        //Task10
        Scanner num10 = new Scanner(System.in);
        int a10 = num10.nextInt();
        int b10 = num10.nextInt();
        int c10 = num10.nextInt();
        System.out.println(rightTriangle(a10,b10,c10));
    }
    public static int solutions(int a, int b, int c)
    {
        int r=0;
        double d=Math.pow(b,2)-4*a*c;
        if(d>0)
            r=2;
        else if (d==0)
            r=1;
        return r;
    }
    public static int findZip(String str){
        String[] str1 = str.split("");
        int k=0;
        int c=-1;
        for(int i=2; i<str1.length;i++){
            if((str1[i].equals("p")) && (str1[i-1].equals("i")) && (str1[i-2].equals("z")))
                k++;
            if(k==2) {
                c = i - 2;
                break;
            }
        }
        return c;
    }
    public static boolean checkPerfect(int n){
        boolean c=false;
        int sum=0;
        for(int i = 1; i<n;i++){
            if(n%i==0)
                sum+=i;
        }
        if(sum==n)
            c=true;
        return c;
    }
    public static String flipEndChars(String str)
    {
        String t="";
        String k="";
        String[] str1 = str.split("");
        if(str1.length<2)
            k="Incompatible.";
        else if(str1[0].equals(str1[str1.length-1]))
            k="Two's a pair.";
        else {
            t=str1[0];
            str1[0]=str1[str1.length-1];
            str1[str1.length-1]=t;
            for(int i=0; i<str1.length; i++){
                k+=String.join("",str1[i]);
            }
        }
        return k;
    }
    public static boolean isValidHexCode(String str){
        boolean k=false;
        char[] str1 = str.toCharArray();
        if((str1.length == 7) && (str1[0] == '#')){
            for(int i=1; i<str1.length; i++){
                if((((int)str1[i] >= 48) && ((int)str1[i] <= 57)) ||
                        (((int)str1[i] >= 65) && ((int)str1[i] <= 70)) ||
                        (((int)str1[i] >= 97) && ((int)str1[i] <= 102)))
                    k=true;
                else {
                    k=false;
                    break;
                }
            }
        }
        return k;
    }
    public static boolean same(int[] Array, int[] Array1) {
        boolean r = false;
        LinkedList<Integer> result = new LinkedList<Integer>();
        LinkedList<Integer> result1 = new LinkedList<Integer>();
        result.add(Array[0]);
        result1.add(Array1[0]);
        for(int i = 1; i<Array.length;i++){
            if(result.contains(Array[i])==false)
                result.add(Array[i]);

        }
        for(int i=1;i<Array1.length;i++){
            if(result1.contains(Array1[i])==false)
                result1.add(Array1[i]);
        }
        if(result.size()==result1.size())
            r=true;
        return r;
    }
    public static boolean isKaprekar(int n){
        int k=n*n;
        boolean h=false;
        ArrayList<Integer> result = new ArrayList<Integer>();
        String str = Integer.toString(k);
        String[] str1 = str.split("");
        String Left = new String();
        String Right = new String();
        for(int i=0; i<str1.length/2;i++){
            Left+=str1[i];
        }
        for(int i=str1.length/2;i<str1.length;i++){
            Right+=str1[i];
        }
        if(Left.length()==0)
            Left="0";
        int Right1 = Integer.parseInt(Right);
        int Left1 = Integer.parseInt(Left);
        if(Right1+Left1==n)
            h=true;
        return h;
    }
    public static String longestZero(String str){
        int max=0;
        int k=0;
        String[] str1=str.split("");
        for(int i=0;i<str1.length;i++){
            if(str1[i].equals("0"))
                k++;
            else
            {
                if(k>=max)
                    max=k;
                k=0;
            }
        }
        String result = new String();
        for(int i=0; i<max;i++){
            result+="0";
        }
        return result;
    }
    public static int nextPrime(int n){
        boolean k=true;
        int num=n;
        while(k){
            for(int i=2; i<num;i++){
                if(num%i==0) {
                    num++;
                    break;
                }
                else if(i==num-1)
                    k=false;
            }
        }
        return num;
    }
    public static boolean rightTriangle(int a,int b,int c){
        boolean k = false;
        if((a>b) && (a>c) && (Math.sqrt(b*b+c*c)==Math.sqrt(a*a)))
            k=true;
        else if((b>a) && (b>c) && (Math.sqrt(a*a+c*c)==Math.sqrt(b*b)))
            k=true;
        else if((c>a) && (c>b) && (Math.sqrt(b*b+a*a)==Math.sqrt(c*c)))
            k=true;
        return k;
    }
}
