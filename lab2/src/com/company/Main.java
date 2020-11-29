package com.company;

import java.io.FileReader;
import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        String slovo="";
        ArrayList<String> mas = new ArrayList<>();//создаю массив для записи данных из таблицы
        try(FileReader reader = new FileReader("file.txt"))//открываем поток
        {
            int c;
            int k=0;
            while((c=reader.read())!=-1){//пока файл не закончился
                if((char)c!='|') {//если файл не равен "|"
                    if((char)c!=',') {//если файл не равен ","
                        if ((char) c == ' ') {//считаем количество пробелов
                            k++;
                            if (k == 1) {//если пробел 1, то добавляем символ
                                slovo += (char) c;
                            }
                        } else {//если это не пробел, то добавляем символ
                            slovo += (char) c;
                            k = 0;//обнуляем счетчик пробелов
                        }
                    }
                }
                else{//если файл равен "|", то добавляем слово в массив для записи данных
                    mas.add(slovo);
                    slovo="";//обнуляем слово
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());//если ошибка
        }
        String[][] tabl = new String[mas.size()/4-1][4];//создаю двумерный массив
        int k=0;
        int c=0;
        slovo="";
        for(int i=4;i< mas.size();i++) {//начинаю перебирать массив данных без заголовков
            if(c==0){//если слово из первого столбца
                for(int j = 2;j<mas.get(i).length();j++){//начинаем перебор слова без символа переноса строки
                    slovo+=mas.get(i).charAt(j);//записываю слово
                }
                tabl[k][c] = slovo;//добавляю слово в двумерный массив
                slovo="";//обнуляю слово
            }
            else{//если слово не из первого столбца
                tabl[k][c] = mas.get(i);//добавляю слово в двумерный массив
            }
            if (c == 3) {//если счётчик находится на последнем столбце
                c = 0;//обнуляем счётчик
                k++;//переходим на новую строку
            }
            else {//если нет, топ просто прибавляем счёчтик столбцов
                c++;
            }
        }
        int max = 0;
        for(int i=0;i<mas.size()/4-1;i++){//нахожу максимальной длины слово из двумерного массива
            for(int j=0;j<4;j++){
                if(tabl[i][j].length()>max)
                    max=tabl[i][j].length();
            }
        }
        slovo="";
        ArrayList<Float> prcon = new ArrayList<>();//создаю arraylist для записи процентов мигрантов от общей численности страны
        for(int i=0;i<mas.size()/4-1;i++){//перебираю двумерный массив, добавляю проценты в arraylist
            for(int j=0;j<tabl[i][3].length()-1;j++)
                slovo+=tabl[i][3].charAt(j);
            prcon.add(Float.parseFloat(slovo));
            slovo="";
        }
        Collections.sort(prcon);//сортирую массив по возрастанию
        slovo="";
        for(int i=prcon.size()-1;i>=0;i--){//начинаю перебирать с конца arraylist
            for(int j=0;j<mas.size()/4-1;j++){//начинаю перебирать двумерный массив по последнему столбцу
                String proverka = Float.toString(prcon.get(i))+" ";//переделываю число из arraylist в String
                if(tabl[j][3].equals(proverka)){//если слово = слову из проверки
                    for(int a=0;a<4;a++){//начинаю перебирать всю строку
                        slovo=tabl[j][a];
                        for(int l=tabl[j][a].length();l<max;l++){//выравниваю слово относительно слова с макс длинной символом
                            slovo+=" ";
                        }
                        System.out.print(slovo);//вывожу слово
                    }
                    System.out.println();//перехожу на новую строку
                }
            }
        }
        slovo="";
        /*/
        for(int i=0;i<mas.size()/4-1;i++){
            for(int j=0;j<4;j++){
                slovo=tabl[i][j];
                for(int l=tabl[i][j].length();l<max;l++){
                    slovo+=" ";
                }
                System.out.print(slovo);
            }
            System.out.println();
        }

         */
        long kolvo=0;
        float procent=0;
        float max1=0;
        float min1=100;
        String contrymax = new String();
        String contrymin = new String();
        slovo="";
        float c1=0;
        long c2=0;
        float p1=0;
        float result=0;
        for(int i=0;i<mas.size()/4-1;i++){//перебираю двумерный массив
            for(int j=0;j<tabl[i][1].length()-1;j++)//смотрю 2 столбец
                slovo+=tabl[i][1].charAt(j);
            kolvo+=Integer.parseInt(slovo);//складываю общее кол-во мигрантов
            slovo="";
            for(int j=0;j<tabl[i][2].length()-1;j++)//смотрю 3 столбец
                slovo+=tabl[i][2].charAt(j);
            if(Float.parseFloat(slovo)>max1) {//нахожу макс процент мигрантов
                max1 = Float.parseFloat(slovo);
                contrymax=tabl[i][0];
            }
            if(Float.parseFloat(slovo)<min1) {//нахожу мин процент мигрантов
                min1 = Float.parseFloat(slovo);
                contrymin=tabl[i][0];
            }
            procent+=Float.parseFloat(slovo);//складываю общий процент мигрантов
            slovo="";
            for (int j = 0; j < tabl[i][1].length() - 1; j++) {//высчитываю общую численность стран
                slovo+=tabl[i][1].charAt(j);
            }
            c2=Long.parseLong(slovo);
            slovo="";
            for (int j = 0; j < tabl[i][3].length() - 1; j++) {
                slovo+=tabl[i][3].charAt(j);
            }
            p1=Float.parseFloat(slovo);
            c1=(c2/p1)*100;
            /*/System.out.println("Численность страны " + tabl[i][0] + ": " + String.format("%.0f", c1));
             */
            result+=c1;
            c1=0;
            p1=0;
            c2=0;
            slovo="";
        }
        System.out.println("Общее количество иммигрантов: "+kolvo);
        System.out.println("Общий процент иммигрантов: "+procent);
        System.out.println("Страна с максимальным процентом иммигрантов: "+contrymax);
        System.out.println("Страна с минимальным процентом иммигрантов: "+contrymin);
        System.out.println("Общая численность стран: "+String.format("%.0f", result));
    }
}
