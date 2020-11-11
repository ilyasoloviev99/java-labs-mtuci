package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //task1
        Scanner num = new Scanner(System.in);
        int n = num.nextInt();
        System.out.println(bell(n));

        //task2
        Scanner str2 = new Scanner(System.in);
        String S2 = str2.nextLine();
        System.out.println(translateSentence(S2));

        //task3
        Scanner S3 = new Scanner(System.in);
        String str3 = S3.nextLine();
        System.out.println(validColor(str3));

        //task4
        Scanner S4 = new Scanner(System.in);
        String str4 = S4.nextLine();
        String str14 = S4.nextLine();
        String[] S14 = str14.split(" ");
        System.out.println(stripUrlParams(str4,S14));

        //task5
        Scanner str5 = new Scanner(System.in);
        String S5 = str5.nextLine();
        getHashTags(S5);

        //task6
        Scanner num6 = new Scanner(System.in);
        int n6 = num6.nextInt();
        System.out.println(ulam(n6));

        //task7
        Scanner str7 = new Scanner(System.in);
        String S7 = str7.nextLine();
        System.out.println(longestNonrepeatingSubstring(S7));

        //task8
        Scanner num8 = new Scanner(System.in);
        int N8 = num8.nextInt();
        System.out.println(convertToRoman(N8));

        //task9
        Scanner str9 = new Scanner(System.in);
        String S9 = str9.nextLine();
        System.out.println(formula(S9));

        //task10
        Scanner num10 = new Scanner(System.in);
        int n10 = num10.nextInt();
        System.out.println(palindromedescendant(n10));
    }
    public static int bell(int n){
        int[] s = new int[n + 1];
        int prev = 1;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                int t = s[j];
                s[j] = prev + j * s[j];
                prev = t;
            }
            prev = 0;
        }
        int result = prev;
        for(int i = 0; i <= n; i++)
            result += s[i];
        return result;
    }
    public static String translateWord(String S){
        char[] m = S.toCharArray();//разбиваем на массив char
        char[] glas = {'A','a','E','e','I','i','O','o','U','u','Y','y'};
        String start = ""; //берёт первые буквы слова
        String result = "";
        if(S.length()==0)// если слово пустое
            return result;
        int k=0; // счётчик для проверки гласной
        int c=-1;// счётчик для определения начала слова
        for(int i=0;i<glas.length;i++){   // проверяем на гласную
            if(glas[i]==m[0])
                k++;
        }
        if(k==0){  // если первая буква равна согласной
            for(int i=0;i<m.length;i++){
                for(int j=0;j<glas.length;j++) {   // проверяем на гласную
                    if (glas[j] == m[i]) {
                        c = i; // индекс, где находится первая гласная
                        break;
                    }
                }
                if(c!=-1){ //если мы нашли первую гласную
                    break;
                }
                start+=m[i];//добавляем все согласные перед первой гласной
            }
            for(int i=c;i<m.length;i++){
                result+=m[i];//добавляем все слово после буквой(буквы)
            }
            result+=start+"ay";//собираем всё слово
        }
        else{//если первая буква гласная
            result+=S+"yay";//собераем всё слово
        }
        return result;
    }
    public static String translateSentence(String S){
        char[] str = S.toCharArray();//разбиваем строку на массив char
        String slovo = "";//слово в предложении
        String result="";//конечное предложение
        for(int i=0;i<str.length;i++){//перебираем всё пердложение
            if(((int)str[i]>=65 &&(int)str[i]<=90)||((int)str[i]>=97 &&(int)str[i]<=122)){//если равно букве
                slovo+=str[i];//собераем всё слово
            }
            else{//если не букве
                slovo=translateWord(slovo);// слово изменяем на свинский латинский
                result+=slovo+str[i];//добавляем слово в конечное предложение
                slovo="";//обнуляем слово
            }
        }
        return result;
    }
    public static boolean validColor(String str){
        char[] S = str.toCharArray();//переделываем строку в массив char
        boolean result = true;//объявляем результат
        String slovo="";//записаем тип(rgb или rgba)
        int c=0;
        String format = "";//записываем всё что есть в скобках
        while(S[c]!='('){//записываем тип и счётчик, откуда нам надо записывать всё, что есть в скобках
            slovo+=S[c];
            c++;
        }
        for(int i=c+1;i<S.length-1;i++){//записываем всё, что есть в скобках
            format+=S[i];
        }
        char l='k';
        c=0;
        String[] f = format.split(",");//избавляем от запятых, добавляем все числа в массив строк
        if(slovo.equals("rgb")){//если тип равен rgb
            if(f.length!=3) {//проверяем на длину
                result = false;
            }
            for(int i = 0;i<f.length;i++){
                if(f[i].length()==0) {//проверяем на пустые цифры
                    result = false;
                    break;
                }
                for(int j=0;j<f[i].length();j++){//проверяем, что там находяться только цифры
                    l=f[i].charAt(j);
                    if(!((int)l>=48 && (int)l<=57)){
                        result = false;
                        break;
                    }
                }
                if(result==false)
                    break;
                c=Integer.parseInt(f[i]);//переводим число в целочисленный тип
                if(c>255){//проверка, на то, что число не больше 255
                    result=false;
                    break;
                }
            }
        }
        float h=0;
        if(slovo.equals("rgba")) {
            if (f.length != 4) {//проверяем на длину
                result = false;
            }
            for (int i = 0; i < f.length; i++) {
                if (f[i].length() == 0) {//проверяем на пустые цифры
                    result = false;
                    break;
                }
            }
            for (int i = 0; i < f.length - 1; i++) {
                for(int j=0;j<f[i].length();j++){//проверяем, что там находяться только цифры(кроме последнего числа)
                    l=f[i].charAt(j);
                    if(!((int)l>=48 && (int)l<=57)){
                        result = false;
                        break;
                    }
                }
                if(result==false)
                    break;
                c = Integer.parseInt(f[i]);//переводим число в целочисленный тип
                if ((c > 255)&&(c<0)) {//проверка, на то, что число не больше 255
                    result = false;
                    break;
                }
            }
            if(f[f.length-1].charAt(0)=='.'){//если первый символ последнего числа равен точке
                result = false;
            }
            for (int j = 0; j < f[f.length - 1].length(); j++) {//проверяем последнее число
                l=f[f.length-1].charAt(j);
                if((((int)l>=48 && (int)l<=57))||l=='.'){
                    if (l=='.') {
                        c++;
                    }
                } else {
                    result = false;
                    break;
                }
                if (c > 1) {//проверяем количество точек(если больше одной точки)
                    result = false;
                    break;
                }
            }
            if(result==true) {
                h = Float.parseFloat(f[f.length - 1]);//переводим последнее число в тип float
                if ((h > 1) && (h < 0)) {//проверяем диапазон числа
                    result = false;
                }
            }
        }
        return result;
    }
    public static String stripUrlParams(String str,String[] S1){
        char[] S = str.toCharArray();//переделывем строку в массив char
        String result = "";
        for(int i=0;i<S.length-2;i++) {//добавляем символы в результат до вопросительного знака
            result += S[i];
            if (S[i] == 'c' && S[i + 1] == 'o' && S[i + 2] == 'm') {
                result += S[i + 1];
                result += S[i + 2];
                break;
            }
        }
        if(result.length()!=str.length()) {//если длина результата не равна истинной строки
            result+=str.charAt(result.length());//добавляем вопросительный знак
            String p = "";//создаём строку и отделяем все что после вопросительного знака
            for (int i = result.length() ; i < str.length(); i++) {
                p += str.charAt(i);
            }
            String[] param = p.split("&");//создаём массив строк и отделяем параметры
            HashMap<String, String> map = new HashMap<>();//создаю словарь для записи параметров
            for (int i = 0; i < param.length; i++) {//отделяю ключ и значение, добавляю в словарь
                String[] k = param[i].split("=");
                map.put(k[0], k[1]);
            }
            if(S1.length!=0){//если необязательный мавссив не пустой, то удаляю элементы по ключу
                for(int i=0;i< S1.length;i++){
                    map.remove(S1[i]);
                }
            }
            ArrayList<HashMap.Entry> entries = new ArrayList<>(map.entrySet());//создаём Arraylist и добавляем
            for(int i=0;i<entries.size();i++){//весь словарь в результат
                if(i==entries.size()-1)//если последнее значение, то амперсант не нужен
                    result+=entries.get(i);
                else
                    result+=entries.get(i) + "&";
            }
        }
        return result;
    }
    public static void getHashTags(String S){
        String slovo="";
        ArrayList<String> mas = new ArrayList<String>();//создаём arraylist
        for(int i=0;i<S.length();i++){//добавляем слова в arraylist
            if(Character.isLetter(S.charAt(i))){//если символ это буква, то собераем слово
                slovo+=S.charAt(i);
            }
            else{//если нет, то добавляем слово в arraylist и обнуляем слово
                mas.add(slovo);
                slovo="";
            }
        }
        if(slovo.length()!=0)//если слово осталось не пустым, то также добавляем
            mas.add(slovo);
        slovo="";
        boolean sorted = false;//сортировка пузырьком по длине слова
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < mas.size()-1; i++) {
                if (mas.get(i).length() < mas.get(i + 1).length()) {
                    slovo = mas.get(i);
                    mas.set(i, mas.get(i + 1));
                    mas.set(i + 1, slovo);
                    sorted = false;
                }
            }
        }
        slovo="";
        for(int i=0;i< mas.size();i++){//делаем все буквы в слове строчными и добавляем #
            slovo= "#" + mas.get(i).toLowerCase();
            mas.set(i, slovo);
        }
        if(mas.size()<=3){//елси длина меньше 3, то просто выводим массив
            System.out.println(mas);
        }
        else{//если нет, то выводим первые 3 элемента
            for(int i=0;i<3;i++){
                System.out.print(mas.get(i)+" ");
            }
        }
        System.out.println();
    }
    public static int ulam(int n){
        int c = 3;//счетчик чисел
        int k=0;
        ArrayList<Integer> mas = new ArrayList<>();//массив для записи последовательности
        mas.add(1);
        mas.add(2);
        if(n==1)//если 1
            return 1;
        if(n==2)//если 2
            return 2;
        while(mas.size()!=n){//пока размер массива не равен введённому числу
            for(int i=0;i< mas.size();i++){//перебираем все варианты
                for(int j=0;j< mas.size();j++){
                    if(mas.get(i)!=mas.get(j) && mas.get(i)+mas.get(j)==c){//если элементы разные и равны счетчику
                        k++;//прибавляем счетчик
                    }
                }
            }
            if(k==2)//если счётчик равен 2(то есть одна пара(1,2;2,1))
                mas.add(c);//добавляем в массив
            k=0;//обнуляем счетчик
            c++;//прибавляем счетчик чисел
        }
        return(mas.get(mas.size()-1));//возвращаем последний элемент последовательности
    }
    public static String longestNonrepeatingSubstring(String S){
        String[] str = S.split("");//разбиваем слово на массив строк
        String posled=str[0];//строка для сборки последовательности
        String max = "";//строка максимальной последовательности
        for(int i=1;i<str.length;i++) {//перебираем слово, сравниваем с последовательностью
            if (posled.indexOf(str[i]) != -1) {//если буква есть в последовательности
                if (posled.length() > max.length())//сравниваем с максимальной последовательностью
                    max = posled;//если больше изменяем её
                posled = str[i];//последовательность равна текущей букве
            } else {//если совпадений не нашлось, то к последовательности прибавляем букву
                posled += str[i];
            }
        }
        if(posled.length() > max.length()){//проверяем последнюю последовательность
            max = posled;
        }
        return max;
    }
    public static String convertToRoman(int N) {
        int[]    numbers = { 1000,900,500,400,100,90,50,40,10,9,5,4,1};//массив цифр
        String[] letters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};//массив римских цифр
        String roman = "";//ответ
        for (int i = 0; i < numbers.length; i++) {//перебираем массив цифр
            while (N >= numbers[i]) {//если больше и равно текущему числу в массиве, то добавляем римскую цифру в ответ
                roman += letters[i];
                N -= numbers[i];//вычитаем цифру
            }
        }
        return roman;
    }
    public static boolean formula(String S){
        boolean otvet = true;
        ArrayList<String> viraj = new ArrayList<>();//записываю выражения
        ArrayList<Float> result = new ArrayList<>();//записываю вычисления выражений
        String[] str = S.split("=");//перевожу строку в массив строк, спличу по =
        float k1 = 0;
        float k2 = 0;
        for(int i=0;i< str.length;i++){
            String[] S1 = str[i].split(" ");//спличу выражение

            for(int j=0;j< S1.length;j++){//если выражения не равны пустой строке, то добавляю в массив выражений
                if(!S1[j].equals(" ") && S1[j].length()!=0){
                    viraj.add(S1[j]);
                }
            }
            if(viraj.size()!=1){//проверяю количество элементов в выражении, если их 3
                k1=Float.parseFloat(viraj.get(0));//перевожу 1 число в тип float
                k2=Float.parseFloat(viraj.get(2));//перевожу 2 число в тип float
                if(viraj.get(1).equals("+")) {//смотря от знака, выполняем операцию, добавляю в result
                    k1 = k1 + k2;
                    result.add(k1);
                }
                if(viraj.get(1).equals("*")) {
                    k1 = k1 * k2;
                    result.add(k1);
                }
                if(viraj.get(1).equals("-")) {
                    k1 = k1 - k2;
                    result.add(k1);
                }
                if(viraj.get(1).equals("/")) {
                    k1 = k1 / k2;
                    result.add(k1);
                }
            }
            else{//если 1 элемент, то перевожу в тип float
                result.add(Float.parseFloat(viraj.get(0)));
            }
            viraj.clear();//чистим массив выражений
        }
        for(int i=0;i< result.size();i++){//перебираю результат, если числа не равны, то ответ = false
            for(int j=0;j< result.size();j++){
                if(result.get(i) - result.get(j)!=0) {
                    otvet=false;
                    break;
                }
            }
        }
        return otvet;
    }
    public static boolean palindromedescendant(int n){
        boolean result = false;
        String num = Integer.toString(n);//переводим число в строку
        String N = "";//новое число
        String n1="";//левая половина
        String n2="";//правая половина
        int k=0;//переменная для сложения соседних чисел
        while(num.length()>=2){//пока длина числа = 2
            for(int i=0;i<num.length()/2;i++){//записываем левую половину
                n1+=num.charAt(i);
            }
            for(int j=num.length()-1;j>=num.length()/2;j--){//записываем правую половину
                n2+=num.charAt(j);
            }
            if(n1.equals(n2)){//если правая и левая половины равны, результат true, выходим
                result = true;
                break;
            }
            else{//если не равны
                for(int i=1;i<num.length();i+=2){//складываем соседние числа, записываем в новое число
                    k=Character.getNumericValue(num.charAt(i))+Character.getNumericValue(num.charAt(i-1));
                    N+=Integer.toString(k);
                }
                num=N;//обновляем число
                N="";//новое число становится пустым
            }
            n1="";//правая половина становится пустой
            n2="";//левая половина становится пустой
        }
        System.out.println(num);
        return result;
    }
}