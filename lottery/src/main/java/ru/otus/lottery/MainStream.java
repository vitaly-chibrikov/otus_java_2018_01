package ru.otus.lottery;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;

/*
https://github.com/vitaly-chibrikov/otus_java_2018_01

удалите строку .map(line -> line.substring(0, line.indexOf("@")))
пишите параметром запуска файл source.csv
запускайте
*/

public class MainStream {
    public static void main(String[] args) throws IOException {
        String salt = "Дмитрий Шевченко\u200BСЧАСТЬЕ ДЛЯ ВСЕХ, ДАРОМ, И ПУСТЬ НИКТО НЕ УЙДЁТ\uFEFF ОБИЖЕННЫЙ!\n" +
                "\n" +
                "Olesya Belichenko\u200Bлед тронулся господа присяжные заседатели, командовать\uFEFF парадом буду Я\n" +
                "\n" +
                "Сергей Ирюпин\u200Bto be or not to\uFEFF be\n" +
                "\n" +
                "alleextube\u200BDo what you\uFEFF ought, and come what may!\n" +
                "\n" +
                "Torino Scale\u200Bскажи как няня - где же\uFEFF кружка\n" +
                "\n" +
                "\n" +
                "Dennys0n\u200Boblady\uFEFF oblada life goes on\n" +
                "\n" +
                "Hunan Abrahamyan\u200Bпот вам\uFEFF армянские символы էտեճ";

        Files.lines(Paths.get(args[0]))
                .map(String::trim)
                .map(line -> line.substring(0, line.indexOf("@")))
                .map(line -> line + "\t" + salt)
                .sorted(Comparator.comparingLong(String::hashCode))
                .map(line -> line.hashCode() + "\t" + line.replace(salt, ""))
                .forEach(System.out::println);
    }
}
