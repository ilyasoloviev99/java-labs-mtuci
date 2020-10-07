package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //Task1
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        int k = num.nextInt();
        Scanner S1 = new Scanner(System.in);
        String str = S1.nextLine();
        redactor(n,k,str);

        //Task2
        Scanner num2 = new Scanner(System.in);
        String str2 = num2.nextLine();
        System.out.println(split(str2));

        //Task3
        Scanner str3 = new Scanner(System.in);
        String S3 = str3.nextLine();
        toCamelCasetoSnakeCase(S3);

        //Task4
        Scanner num4 = new Scanner(System.in);
        String s4 = num4.nextLine();
        String[] str4 = s4.split(" ");
        float []Array4 = new float[str4.length];
        for(int i=0;i<Array4.length;i++){
            Array4[i]=Float.parseFloat(str4[i]);
        }
        System.out.println(overTime(Array4));

        //Task5
        Scanner str5 = new Scanner(System.in);
        String S15 = str5.nextLine();
        String S25 = str5.nextLine();
        System.out.println(BMI(S15,S25));

        //Task6
        Scanner n6 = new Scanner(System.in);
        int num6 = n6.nextInt();
        System.out.println(bugger(num6));

        //Task7
        Scanner S7 = new Scanner(System.in);
        String str7 = S7.nextLine();
        System.out.println(toStarShorthand(str7));

        //Task8
        Scanner str8 = new Scanner(System.in);
        String S18 = str8.nextLine();
        String S28 = str8.nextLine();
        System.out.println(doesRhyme(S18,S28));

        //Task9
        Scanner n9 = new Scanner(System.in);
        double num19 = n9.nextDouble();
        double num29 = n9.nextDouble();
        System.out.println(trouble(num19,num29));


        //Task10
        Scanner str10 = new Scanner(System.in);
        String S110 = str10.nextLine();
        char c10 = str10.next().charAt(0);
        System.out.println(countUniqueBooks(S110,c10));
    }
    public static void redactor(int n, int k, String str){
        String[] S = str.split(" ");
        String slovo = S[0];
        int m = 0;
        for(int i=1;i<n;i++){
            String str1 = slovo+ " " +S[i];
            for(int j=0;j<str1.length();j++){
                if(str1.charAt(j)!=' ')
                    m++;
            }
            if(m<=k){
                slovo=str1;
            }
            else{
                System.out.println(slovo);
                slovo = S[i];
            }
            if(i==n-1)
                System.out.println(slovo);
            m=0;
        }
    }
    public static ArrayList<String> split(String str){
        String[] S = str.split("");
        int a=0;
        int b=0;
        ArrayList<String> R= new ArrayList<String>();
        String result = new String();
        for(int i=0;i<S.length;i++){
            if(S[i].equals("(")) {
                a++;
                result+=S[i];
            }
            else {
                b++;
                result+=S[i];
            }
            if(a==b){
                result = "\"" + result + "\"";
                R.add(result);
                result="";
            }
        }
        return R;
    }
    public static void toCamelCasetoSnakeCase(String S){
        char []str = S.toCharArray();
        int k=0;
        for(int i=0;i< str.length;i++){
            if(str[i]=='_') {
                k++;
            }
        }
        if(k==0)
            System.out.println(toSnakeCase(S));
        else System.out.println(toCamelCase(S));
    }
    public static String toCamelCase(String S){
        char []str = S.toCharArray();
        String result = new String();
        int k;
        for(int i=0;i< str.length;i++){
            if(str[i]!='_')
                result+=str[i];
            else {
                k = (int) str[i + 1];
                str[i+1]=(char)(k-32);
            }
        }
        return result;
    }
    public static String toSnakeCase(String S){
        char []str = S.toCharArray();
        String result = new String();
        int k;
        for(int i=0; i< str.length;i++)
        {
            if((int)str[i]>=65 && (int)str[i]<=90){
                k=(int) str[i];
                result+= "_" + (char)(k+32);
            }
            else
                result+=str[i];
        }
        return result;
    }
    public static String overTime(float[] Array){
        float a = Array[0];
        float b = Array[1];
        float sum = Array[2];
        float k=Array[3];
        float itog=0;
        if(b>=17){
            itog=(17-a)*sum+(b-17)*sum*k;
        }
        else itog=(b-a)*sum;
        String str = String.format("%.2f%n", itog);
        str = "$" + str;
        String[] str1 = str.split("");
        String result = new String();
        for(int i=0;i<str1.length;i++){
            if(str1[i].equals(","))
                str1[i]=".";
            result+=str1[i];
        }
        return result;
    }
    public static String BMI(String S1, String S2){
        String[] weith = S1.split(" ");
        String[] height = S2.split(" ");
        double result;
        double W=Double.parseDouble(weith[0]);
        if(weith[1].equals("pounds"))
            W=W/2.205;
        double H=Double.parseDouble(height[0]);
        if(height[1].equals("inches"))
            H = H/39.3701;
        result = W/(H*H);
        String itog = String.format("%.1f",result);
        String itog1 = new String();
        if(result<18.5)
            itog1=" Underweight";
        else if (result>=18.5 && result<25)
            itog1=" Normal weight";
        else if (result>=25)
            itog1=" Overweight";
        itog=itog+itog1;
        itog1="";
        String[] str = itog.split("");
        for(int i=0;i< str.length; i++){
            if(str[i].equals(","))
                str[i]=".";
            itog1+=str[i];
        }
        return itog1;
    }
    public static int bugger(int n){
        ArrayList<Integer> mas = new ArrayList<Integer>();
        while (n!=0){
            mas.add(0,n % 10);
            n = n / 10;
        }
        int result = 1;
        int c=0;
        boolean m=true;
        int k;
        if(mas.size()==1)
            return 0;
        while(m==true){
            k=1;
            for(int i=0;i<mas.size();i++){
                k=k*mas.get(i);
            }
            mas.clear();
            if(k/10==0){
                m=false;
            }
            else result++;
            c=k;
            while(c!=0){
                mas.add(0,c%10);
                c=c/10;
            }
        }
        return result;
    }
    public static String toStarShorthand(String S) {
        String[] str = S.split("");
        String result = new String();
        String r = str[0];
        int k = 1;
        for(int i=1; i<str.length;i++) {
            if(r.equals(str[i])){
                k++;
            }
            else{
                if(k==1) {
                    result += r;
                    r=str[i];
                }
                else{
                    result += r + "*" + k;
                    r=str[i];
                    k=1;
                }
            }
        }
        if(k==1){
            result+=r;
        }
        else
            result += r + "*" + k;

        return result;
    }
    public static boolean doesRhyme(String S1,String S2)
    {
        boolean otvet = true;
        String[] result1 = S1.split(" ");
        String str1 = result1[result1.length-1];
        String[] result2 = S2.split(" ");
        String str2 = result2[result2.length-1];
        char[] glas = {'a','e','o','u'};
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        String r1 = new String("");
        String r2 = new String("");
        for(int i=0;i< str1.length();i++){
            for(int j=0;j< glas.length;j++){
                if(str1.charAt(i)==glas[j]){
                    r1+=glas[j];
                    break;
                }
            }
        }
        for(int i=0;i< str2.length();i++){
            for(int j=0;j< glas.length;j++){
                if(str2.charAt(i)==glas[j]){
                    r2+=glas[j];
                    break;
                }
            }
        }
        if(r1.length()!=r2.length())
            otvet=false;
        else{
            for(int i=0;i<r1.length();i++){
                if(r1.charAt(i)!=r2.charAt(i)) {
                    otvet = false;
                    break;
                }
            }
        }
        return otvet;
    }
    public static boolean trouble(double num1, double num2) {
        boolean result = false;
        ArrayList<Integer> mas1 = new ArrayList<Integer>();
        ArrayList<Integer> mas2 = new ArrayList<Integer>();
        String[] str1 = Double.toString(num1).split("");
        String[] str2 = Double.toString(num2).split("");
        int k=0;
        for(int i=0;i<str1.length;i++){
            for(int j=0;j<str1.length;j++){
                if(str1[i].equals(str1[j]))
                    k++;
            }
            if(k==3){
                mas1.add(Integer.parseInt(str1[i]));
            }
            k=0;
        }
        for(int i=0;i<str2.length;i++){
            for(int j=0;j<str2.length;j++){
                if(str2[i].equals(str2[j]))
                    k++;
            }
            if(k==2){
                mas2.add(Integer.parseInt(str2[i]));
            }
            k=0;
        }
        for(int i=0;i< mas1.size();i++){
            for(int j=0;j<mas2.size();j++){
                if(mas1.get(i)==mas1.get(j)) {
                    result = true;
                    break;
                }
            }
            if(result==true)
                break;
        }
        return result;
    }
    public static int countUniqueBooks(String str,char S){
        ArrayList<Character> mas = new ArrayList<Character>();
        ArrayList<String> slova = new ArrayList<String>();
        String result = new String();
        char[] str1 = str.toCharArray();
        for(int i=1;i< str1.length;i++){
            if(str1[i]!=S)
                result+=str1[i];
            else{
                slova.add(result);
                result="";
            }
        }
        result="";
        for(int i=0;i<slova.size();i+=2){
            result+=slova.get(i);
        }
        int k=0;
        for(int i=0;i<result.length();i++){
            k= mas.indexOf(result.charAt(i));
            if(k==-1)
                mas.add(result.charAt(i));
        }
        return mas.size();
    }
}
