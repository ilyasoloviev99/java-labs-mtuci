package com.company;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        String str1 = str.nextLine();
        int[] mas = encrypt(str1);

        for(int i = 0; i < mas.length; ++i) {
            System.out.print(mas[i] + " ");
        }

        System.out.println();
        String str2 = str.nextLine();
        String[] mas1 = str2.split(" ");
        int[] massiv = new int[mas1.length];

        for(int i = 0; i < massiv.length; ++i) {
            massiv[i] = Integer.parseInt(mas1[i]);
        }

        System.out.println(decrypt(massiv));
        System.out.println();
        Scanner str222 = new Scanner(System.in);
        String str12 = str222.nextLine();
        String str22 = str222.nextLine();
        String str32 = str222.nextLine();
        System.out.println(canMove(str12, str22, str32));
        Scanner str3 = new Scanner(System.in);
        String str13 = str3.nextLine();
        String str23 = str3.nextLine();
        System.out.println(canComplete(str13, str23));
        Scanner s4 = new Scanner(System.in);
        String str4 = s4.nextLine();
        String[] str14 = str4.split(" ");
        int[] mas4 = new int[str14.length];

        for(int i = 0; i < mas4.length; ++i) {
            mas4[i] = Integer.parseInt(str14[i]);
        }

        System.out.println(sumDigProd(mas4));
        Scanner str5 = new Scanner(System.in);
        String str15 = str5.nextLine();
        String[] S5 = str15.split(" ");
        String[] result5 = sameVowelGroup(S5);

        for(int i = 0; i < result5.length; ++i) {
            System.out.print(result5[i] + " ");
        }

        System.out.println();
        Scanner num6 = new Scanner(System.in);
        long n6 = num6.nextLong();
        System.out.println(validateCard(n6));
        Scanner num7 = new Scanner(System.in);
        int n7 = num7.nextInt();
        System.out.println(numToEng(n7));
        System.out.println(numToRUS(n7));
        Scanner str8 = new Scanner(System.in);
        String S8 = str8.nextLine();
        System.out.println(getSha256Hash(S8));
        Scanner str9 = new Scanner(System.in);
        String S9 = str9.nextLine();
        System.out.println(correctTitle(S9));
        Scanner num10 = new Scanner(System.in);
        int n10 = num10.nextInt();
        hexLattice(n10);
    }

    public static int[] encrypt(String str) {
        char[] mas = str.toCharArray();//переводим строку в массив char
        int[] massiv = new int[mas.length];//создаём массив инт для записи результата
        massiv[0] = mas[0];//первый символ равен символьному коду буквы

        for(int i = 1; i < mas.length; ++i) {//начиная со второго элемента, вычитаем различия между символами
            massiv[i] = mas[i] - mas[i - 1];
        }

        return massiv;
    }

    public static String decrypt(int[] mas) {
        String result = Character.toString((char)mas[0]);//переводим строку в массив char, добавляем первый элемент
        int k = mas[1] + mas[0];//складываю различия первого и второго элемента
        result = result + (char)k;//добавляю второй элемент

        for(int i = 2; i < mas.length; ++i) {//начиная с 3 элемента складываю различия
            k += mas[i];
            result = result + (char)k;//добавляю в результат
        }

        return result;
    }

    public static boolean canMove(String str1, String str2, String str3) {
        boolean result = false;
        String[] position1 = str2.split("");//создаю массив string записываю положение фигуры
        String[] position2 = str3.split("");//создаю массив string записываю целевую позицию
        HashMap<String, String> map = new HashMap();//создаю словарь, чтобы перевести буквы в цифры (шахматная доска 8 на 8)
        map.put("A", "1");
        map.put("B", "2");
        map.put("C", "3");
        map.put("D", "4");
        map.put("E", "5");
        map.put("F", "6");
        map.put("G", "7");
        map.put("H", "8");
        position1[0] = (String)map.get(position1[0]);//изменяю буквы на цифры
        position2[0] = (String)map.get(position2[0]);//изменяю буквы на цифры
        int x1 = Integer.parseInt(position1[0]);//перевожу цифры в Int
        int x2 = Integer.parseInt(position2[0]);//перевожу цифры в Int
        int y1 = Integer.parseInt(position1[1]);//перевожу цифры в Int
        int y2 = Integer.parseInt(position2[1]);//перевожу цифры в Int
        if (str1.equals("Rook") && (x1 == x2 || y1 == y2)) {//дальше показываю как ходят фигуры
            result = true;
        } else if (str1.equals("Bishop") && Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            result = true;
        } else if (str1.equals("King") && Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) {
            result = true;
        } else if (str1.equals("Pawn")) {
            if (y1 == 2) {
                if (x1 == x2 && y2 - y1 <= 2) {
                    result = true;
                }
            } else if (x1 == x2 && y2 - y1 == 1) {
                result = true;
            }
        } else if (str1.equals("Knight")) {
            if (Math.abs(y1 - y2) == 2 && Math.abs(x1 - x2) == 1) {
                result = true;
            } else if (Math.abs(y1 - y2) == 1 && Math.abs(x1 - x2) == 2) {
                result = true;
            }
        } else if (str1.equals("Queen")) {
            if (x1 != x2 && y1 != y2) {
                if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
                    result = true;
                }
            } else {
                result = true;
            }
        }

        return result;
    }

    public static boolean canComplete(String str1, String str2) {
        String[] S1 = str1.split("");// перевожу слов в массив строк
        String[] S2 = str2.split("");// перевожу слов в массив строк
        boolean result = true;//объявляю результат
        ArrayList<Integer> mas = new ArrayList();

        int i;
        for(i = 0; i < S1.length; ++i) {
            result = false;

            for(int j = 0; j < S2.length; ++j) {
                if (S1[i].equals(S2[j])) {//сравниваю буквы в словах, если находятся одинаковые буквы, то допавляется номер
                    mas.add(j);//элемента, и буква заменяется пробелом, чтобы избежать повторов
                    S2[j] = " ";
                    result = true;
                    break;
                }
            }

            if (!result) {//если буквы не нашлось, то возвращаем false
                return result;
            }
        }

        for(i = 0; i < mas.size() - 1; ++i) {//дальше проверяем чтобы все индексы шли по возрастанию
            if ((Integer)mas.get(i) > (Integer)mas.get(i + 1)) {
                result = false;
            }
        }

        return result;
    }

    public static int sumDigProd(int[] mas) {
        int sum = 0;

        for(int i = 0; i < mas.length; ++i) {//складываю все числа в сумму
            sum += mas[i];
        }

        String result = Integer.toString(sum);//перевожу сумму в строку, чтобы узнать

        for(int proiz = 1; result.length() > 1; proiz = 1) {//проверяю длину числа
            for(int i = 0; i < result.length(); ++i) {
                int c = Character.getNumericValue(result.charAt(i));//записываю произведение цифр
                proiz *= c;
            }

            result = Integer.toString(proiz);//обновляю число
        }

        sum = Integer.parseInt(result);//перевожу число в тип int
        return sum;
    }

    public static String[] sameVowelGroup(String[] S) {
        String[] S1 = new String[S.length];
        ArrayList<String> mas = new ArrayList();
        String glas = "";

        int k;
        for(k = 0; k < S.length; ++k) {
            for(int j = 0; j < S[k].length(); ++j) {
                if (S[k].charAt(j) == 'a' || S[k].charAt(j) == 'e' || S[k].charAt(j) == 'i' || S[k].charAt(j) == 'o' || S[k].charAt(j) == 'u' || S[k].charAt(j) == 'y') {
                    glas = glas + S[k].charAt(j);//создаю из слов, массив строк из их гласных
                }
            }

            S1[k] = S[k];
            S[k] = glas;
            glas = "";
        }

        k = 0;
        int y = 0;

        int i;
        for(i = 0; i < S.length; ++i) {//проверяю, чтобы слово было не пустое
            if (S[i].length() == 0) {
                S[i] = "ggggg";
            }
        }

        mas.add(S1[0]);//записываю первое слово в array

        int j;
        for(i = 1; i < S.length; ++i) {//сравниваю все гласные в словах
            for(j = 0; j < S[i].length(); ++j) {
                for(int c = 0; c < S[0].length(); ++c) {
                    if (S[i].charAt(j) == S[0].charAt(c)) {
                        ++k;
                    }
                }

                if (k == 0) {
                    y = -1;
                }

                k = 0;
            }

            if (y == 0) {//если все гласные одникавые, добавляем в array
                mas.add(S1[i]);
            }

            y = 0;
        }

        String[] result = new String[mas.size()];

        for(j = 0; j < mas.size(); ++j) {
            result[j] = (String)mas.get(j);
        }

        return result;
    }

    public static boolean validateCard(long n) {
        boolean otvet = false;
        String str = Long.toString(n);//перевожу число в строку
        String[] S = str.split("");//затем в массив строк
        int k = Integer.parseInt(S[S.length - 1]);//записываем последнее число
        String[] S1 = new String[S.length - 1];
        int c = 0;

        for(int i = S.length - 2; i >= 0; --i) {//удаляем последнюю цифру, переворачиваем число
            S1[c] = S[i];
            ++c;
        }

        int[] result = new int[S1.length];

        int proiz;
        for(proiz = 0; proiz < S1.length; ++proiz) {
            result[proiz] = Integer.parseInt(S1[proiz]);//переводим в массив int каждую цифру числа
        }

        int sum;
        int j;
        for(sum = 0; sum < result.length; sum += 2) {//удваиваем значеия в нечётной позиции
            proiz = result[sum] * 2;
            String slovo = Integer.toString(proiz);//если число состоит из несколько цифр, то складываем цифры
            if (slovo.length() == 2) {
                proiz = 0;

                for(j = 0; j < 2; ++j) {
                    proiz += Character.getNumericValue(slovo.charAt(j));
                }
            }

            result[sum] = proiz;
        }

        sum = 0;

        for(j = 0; j < result.length; ++j) {
            sum += result[j];//складываю все числа
        }

        String o = Integer.toString(sum);
        String[] h = o.split("");
        c = Integer.parseInt(h[h.length - 1]);//записываем последнее число из суммы
        if (10 - c == k) {
            otvet = true;
        }

        return otvet;
    }

    public static String numToEng(int n) {
        String number = Integer.toString(n);
        String otvet = new String();
        String hundred = "hundred";
        String[] edin = new String[]{"zero", "one", "two", "tree", "four", "five", "six", "seven", "eight", "nine"};//массив единиц
        if (number.length() == 1) {//если число состоит из 1 цифры, то добавляем из массива единиц
            otvet = edin[n];
        }

        String[] desyt = new String[]{"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};//массив от 10 до 19
        String[] d2 = new String[]{"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};//массив десятков
        if (number.length() == 2) {//елси число состоит из 2 цифр
            if (number.charAt(0) == '1') {//если первая единица
                otvet = desyt[n % 10];//добавляем из массива от 10 до 19
            } else if (number.charAt(0) != '1' && number.charAt(1) != '0') {//если первая цифра не 1 и не 0
                otvet = d2[n / 10 - 2] + " " + edin[n % 10];//добавляем из массива десятков + массива единиц
            } else {
                otvet = d2[n / 10 - 2];//если вторая цифра 0 и первая не 1, то добавляем из массива десятков
            }
        }

        if (number.length() == 3) {//елси число состоит из 3 цифр
            otvet = edin[n / 100] + " " + hundred;//добавляем сотни
            if (number.charAt(1) == '1') {//все тоже что и со числом из 2 цифр
                otvet = otvet + " " + desyt[n % 100 % 10];
            } else if (number.charAt(1) != '1' && number.charAt(2) != '0' && number.charAt(1) != '0') {
                otvet = otvet + " " + d2[n / 10 % 10 - 2] + " " + edin[n % 100 % 10];
            } else if (number.charAt(1) != '0' && number.charAt(2) == '0') {
                otvet = otvet + " " + d2[n / 10 % 10 - 2];
            } else if (number.charAt(1) == '0' && number.charAt(2) != '0') {
                otvet = otvet + " " + edin[n % 100 % 10];
            }
        }

        return otvet;
    }

    public static String numToRUS(int n) {//алгоритм такой эе как и с англ. числа, только добавили массив сотен
        String number = Integer.toString(n);
        String otvet = new String();
        String[] hundred = new String[]{"сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        String[] edin = new String[]{"ноль", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        if (number.length() == 1) {
            otvet = edin[n];
        }

        String[] desyt = new String[]{"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
        String[] d2 = new String[]{"двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
        if (number.length() == 2) {
            if (number.charAt(0) == '1') {
                otvet = desyt[n % 10];
            } else if (number.charAt(0) != '1' && number.charAt(1) != '0') {
                otvet = d2[n / 10 - 2] + " " + edin[n % 10];
            } else {
                otvet = d2[n / 10 - 2];
            }
        }

        if (number.length() == 3) {
            otvet = hundred[n / 100 - 1];
            if (number.charAt(1) == '1') {
                otvet = otvet + " " + desyt[n % 100 % 10];
            } else if (number.charAt(1) != '1' && number.charAt(2) != '0' && number.charAt(1) != '0') {
                otvet = otvet + " " + d2[n / 10 % 10 - 2] + " " + edin[n % 100 % 10];
            } else if (number.charAt(1) != '0' && number.charAt(2) == '0') {
                otvet = otvet + " " + d2[n / 10 % 10 - 2];
            } else if (number.charAt(1) == '0' && number.charAt(2) != '0') {
                otvet = otvet + " " + edin[n % 100 % 10];
            }
        }

        return otvet;
    }

    public static String getSha256Hash(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));// конвертирую строку в байты
            StringBuffer hexString = new StringBuffer();

            for(int i = 0; i < hash.length; ++i) {
                String hex = Integer.toHexString(255 & hash[i]);//хешируем байты
                if (hex.length() == 1) {
                    hexString.append('0');
                }

                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception var6) {
            throw new RuntimeException(var6);
        }
    }

    public static String correctTitle(String S) {
        S = S.toLowerCase();//переводим слова в строке в строчный тип
        char[] text = S.toCharArray();//переводим строку в массив char
        String slovo = "";
        String result = "";

        for(int i = 0; i < text.length; ++i) {//перебираем массив char
            if (text[i] >= 'a' && text[i] <= 'z') {//если символ, это буква, то собираем слово
                slovo = slovo + text[i];
            } else {
                if (!slovo.equals("")) {//если слово не пустое и не равно избранным словам
                    if (!slovo.equals("and") && !slovo.equals("the") && !slovo.equals("of") && !slovo.equals("in")) {
                        int k = slovo.charAt(0) - 32;//то, слово начинается с заглавной буквы
                        char[] l = slovo.toCharArray();
                        l[0] = (char)k;
                        result = result + String.valueOf(l);//добавляем слово в резульатат
                    } else {
                        result = result + slovo;
                    }

                    slovo = "";
                }

                result = result + text[i];
            }
        }

        return result;
    }

    public static void hexLattice(int n) {
        int k = 1;
        int m = 1 + 6 * (k * (k - 1) / 2);//реализовать алгорит с интернета
        boolean prov = false;

        for(String var4 = ""; m <= n; ++k) {
            m = 1 + 6 * (k * (k - 1) / 2);
            if (m == n) {
                prov = true;
            }
        }

        if (!prov) {
            System.out.println("Invalid");
        } else {
            System.out.println(true);
        }

    }
}
