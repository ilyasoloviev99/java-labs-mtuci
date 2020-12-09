package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class URLDEPTH {
    public static String result = "";
    public static ArrayList<String> URLresult = new ArrayList<>();
    public static ArrayList<String> URLSTREAM(ArrayList<String> Streamurl, int depth){//для вывода url
        for(int i=1;i<depth;i++){//пока счётчик не равен глубине
            for(int j=0;j<Streamurl.size();j++){//перебираем arraylist
                String[] y = Streamurl.get(j).split(" ");//сплитим строку на url и глубину
                int depthy = Integer.parseInt(y[1]);
                if(depthy==i)//если глубина равна счётчику глуюины
                    URLdepth(y[0],depthy,Streamurl);//вызываем функцию
            }
        }
        return Streamurl;
    }
    public static ArrayList<String> URLSTREAM1(String url, int depth){
        ArrayList<String> Null = new ArrayList<>();
        URLdepth(url,depth,Null);
        return Null;
    }
    public static void URLdepth(String url, int depth,ArrayList<String> Streamurl) {
        ArrayList<Integer> D = new ArrayList<>();//list для подсчёта глуюины
        ArrayList<String> URLdepthhash = new ArrayList<>();//list для подсчёта url
        try {
            URL http = new URL(url);//подключаемся к ссылке
            BufferedReader in = new BufferedReader(//считываем текст с ссылки
                    new InputStreamReader(
                            http.openStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                result += inputLine;
            in.close();
        } catch (IOException e) {//если ошибка выводим
            System.out.println("java Crawler " + url + " " + depth);
        }
        String str1 = "";
        String aPattern = "<(a)\\b[^>]*>";//создаем паттерн "a ..."
        Pattern REGEX = Pattern.compile(aPattern);
        Matcher matcher = REGEX.matcher(result);
        while (matcher.find()) {
            str1 += " " + matcher.group();//добавляем итог в строку
        }
        String httpPattern = "href=\\\"(.*?)\\\"";//создаем паттерн "a href=..."
        Pattern REGEX1 = Pattern.compile(httpPattern);
        Matcher matcher1 = REGEX1.matcher(str1);
        result = "";
        while (matcher1.find()) {
            if (matcher1.group().length() <= 6) {//если выражение меньше 6 ->следующее выражение
                continue;
            } else {
                if (matcher1.group().substring(6, 7).equals("/") && matcher1.group().substring(7, 8).equals("/")) {//проверяем на
                    //если начинается с "//", то добавляем http и дальше listы
                    URLdepthhash.add("http:" + matcher1.group().substring(6, matcher1.group().length() - 1));
                    D.add(depth + 1);
                } else if (matcher1.group().substring(6, 7).equals("h"))//если нет, до дабовляем в listы
                    URLdepthhash.add(matcher1.group().substring(6, matcher1.group().length() - 1));
                D.add(depth + 1);
            }
        }

        for(int i=0;i<URLdepthhash.size();i++){
            Streamurl.add(URLdepthhash.get(i)+" " + D.get(i));//элементы arraylistов с одинаковым индексом дабавляются в итоговый arraylist
        }
        URLdepthhash.clear();
        D.clear();
    }


}
