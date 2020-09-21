package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        //task1
        Scanner n = new Scanner(System.in);
        String str = n.nextLine();
        int a = n.nextInt();
        System.out.println(repeat(str,a));

        //task2
        Scanner n2 = new Scanner(System.in);
        String l2 = n2.nextLine();
        String l12[]=l2.split(" ");
        int[] Array2 = new int[l12.length];
        for(int i=0;i<l12.length;i++)
        {
            Array2[i]=Integer.parseInt(l12[i]);
        }
        System.out.println(differenceMaxMin(Array2));

        //tusk3
        Scanner n3 = new Scanner(System.in);
        String l3 = n3.nextLine();
        String l13[]=l3.split(" ");
        int[] Array3 = new int[l13.length];
        for(int i=0;i<l13.length;i++)
        {
            Array3[i]=Integer.parseInt(l13[i]);
        }
        System.out.println(isAvgWhole(Array3));

        //tusk4
        Scanner l4= new Scanner(System.in);
        String str4=l4.nextLine();
        String str14[]=str4.split(" ");
        int[] Array4=new int[str14.length];
        for(int i=0;i<str14.length;i++){
            Array4[i]=Integer.parseInt(str14[i]);
        }
        int[] Array14=cumulativeSum(Array4);
        for(int i=0;i<Array14.length;i++){
            System.out.print(Array14[i] + " ");
        }
        System.out.println();
        //tusk5
        Scanner str5 = new Scanner(System.in);
        String str15 = str5.nextLine();
        System.out.println(getDecimalPlaces(str15));

        //tusk6
        Scanner num6 = new Scanner(System.in);
        int n6= num6.nextInt();
        System.out.println(Fibonacci(n6));

        //tusk7
        Scanner str7 = new Scanner(System.in);
        String str17 = str7.nextLine();
        System.out.println(isValid(str17));

        //tusk8
        Scanner str8 = new Scanner(System.in);
        String str18 = str8.nextLine();
        String str28 = str8.nextLine();
        System.out.println(isStrangePair(str18,str28));

        //tusk9
        Scanner str9 = new Scanner(System.in);
        String str19 = str9.nextLine();
        String str29 = str9.nextLine();
        String[] str39=str29.split("");
        if(str39[0].equals("-")) {
            System.out.println(isSuffix(str19, str29));
        }
        else{
            System.out.println(isPrefix(str19, str29));
        }

        //tusk10
        Scanner num10 = new Scanner(System.in);
        int n10 = num10.nextInt();
        System.out.println(boxSeq(n10));
    }
    public static String repeat(String str, int a){
        int k=-1;
        char[] Array1=str.toCharArray();
        char[] Array = new char[a*str.length()];
        for(int i=0;i<a*str.length();i++){
            if(i%a==0){
                k++;
            }
            Array[i]=Array1[k];
        }
        /*
        for (int i = 0; i < Array1.length; i++) {
            for (int j = 0; j < a; j++) {
                Array[i*a+j] = Array1[i];
            }
        }*/
        String newString = new String(Array);
        return newString;
    }
    public static int differenceMaxMin(int[] Array){
        int max=Array[0];
        int min=Array[0];
        for(int i=1;i< Array.length;i++){
            if(Array[i]>max)
                max=Array[i];
            else if (Array[i]<min)
                min=Array[i];
        }
        return max-min;
    }
    public static boolean isAvgWhole(int[] Array){
        int sum=0;

        for(int i=0;i<Array.length;i++){
            sum+=Array[i];
        }
        if(sum%Array.length==0)
            return true;
        else
            return false;
    }
    public static int[] cumulativeSum(int[] Array){
        int sum=0;
        for(int i=0;i<Array.length;i++){
            sum+=Array[i];
            Array[i]=sum;
        }
        return Array;
    }
    public static int getDecimalPlaces(String str){
        int k=0;
        String[] str1 = str.split("");
        for(int i=0;i< str1.length;i++){
            if(str1[i].equals(".")){
                k=str1.length-i-1;
            }
        }
        return k;
    }
    public static int Fibonacci(int n)
    {
        int F1=1;
        int F2=1;
        int k=0;
        for (int i = 2; i <= n; i++) {
            k = F1 + F2;
            F1 = F2;
            F2 = k;
        }
        return F2;
    }
    public static boolean isValid(String str){
        char[] str1 = str.toCharArray();
        boolean k=true;
        int y=0;
        if(str1.length==5){
            for(int i=0;i<str1.length;i++){
                y=(int)str1[i];
                if(((y>=65) && (y<=122)) || (y==32))
                    k=false;
            }
        }
        else k=false;
        return k;
    }
    public static boolean isStrangePair(String str1,String str2){
        String[] l1=str1.split("");
        String[] l2=str2.split("");
        String a1=l1[0];
        String b1=l2[0];
        String an=l1[l1.length-1];
        String bn=l2[l2.length-1];
        if((a1.equals(bn))&&(b1.equals(an)))
            return true;
        else
            return false;
    }
    public static boolean isPrefix(String str1,String str2){
        boolean k=true;
        String[] l=str1.split("");
        String[] Prefix=str2.split("");
        for(int i=0;i<Prefix.length-1;i++){
            if(l[i].equals(Prefix[i])==false) {
                k = false;
                break;
            }
        }
        return k;
    }
    public static boolean isSuffix(String str1,String str2){
        boolean k=true;
        String[] l=str1.split("");
        String[] Suffix=str2.split("");
        for(int i =0;i<Suffix.length-1;i++){
            if(l[l.length-Suffix.length+1+i].equals(Suffix[i+1])==false) {
                k = false;
                break;
            }
        }
        return k;
    }
    public static int boxSeq(int n){
        if(n%2==0)
            return n;
        else return n+2;
    }
}
