package com.company;
import java.net.URLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static HashMap<String, Integer> URLdepthhash = new HashMap<>();
    private static HashMap<String, Integer> proverka = new HashMap<>();
    public Main() {
    }

    public static void main(String[] args) {
        Scanner u = new Scanner(System.in);
        System.out.print("URL-адрес: ");
        String url = u.nextLine();
        System.out.print("Максимальная глубина поски: ");
        int depth = u.nextInt();
        URLdepthhash.put(url,0);
        URLDepth(url,0);
        for (Map.Entry entry : URLdepthhash.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    public static void URLDepth(String url,int depth){
        String content = null;
        URLConnection connection = null;

        try {
            connection = new URL(url).openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            scanner.useDelimiter("\\Z");
            content = scanner.next();
            scanner.close();
            String aPattern = "<(a)\\b[^>]*>";
            Pattern REGEX = Pattern.compile(aPattern);
            Matcher matcher = REGEX.matcher(content);
            String result = "";
            while (matcher.find()) {
                result += " " + matcher.group();
            }
            String httpPattern = "href=\\\"(.*?)\\\"";
            int k = 1;
            Pattern REGEX1 = Pattern.compile(httpPattern);
            Matcher matcher1 = REGEX1.matcher(result);
            while (matcher1.find()) {
                if (matcher1.group().length() <= 6) {
                    continue;
                } else {
                    if (matcher1.group().substring(6, 7).equals("/") && matcher1.group().substring(7, 8).equals("/")) {
                        URLdepthhash.put("http:" + matcher1.group().substring(6, matcher1.group().length() - 1),  depth+1);
                    } else if (matcher1.group().substring(6, 7).equals("h"))
                        URLdepthhash.put(matcher1.group().substring(6, matcher1.group().length() - 1), depth+1);
                }
                proverka.put(url,depth);
            }
            proverka.put(url,depth);
            for(Iterator<Map.Entry<String, Integer>> it = proverka.entrySet().iterator(); it.hasNext(); ) {
                Map.Entry<String, Integer> entry = it.next();
                if(entry.getKey().equals(url)) {
                    it.remove();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}



