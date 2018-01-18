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
        String salt = "Иван Волков\u200BI'll\uFEFF be back)\n" +
                "\n" +
                "\n" +
                "Владимир Лиханов\u200B42\uFEFF\n" +
                "\n" +
                "Ярослав Калашник\u200B))) ну ок, допустим\uFEFF\n" +
                "\n" +
                "Senior Tomato\u200BThe Gods will be\uFEFF with us\n" +
                "\n" +
                "Бари Хафизуллин\u200Byou shall\uFEFF not pass";

        Files.lines(Paths.get(args[0]))
                .map(line -> line.replace("\"", ""))
                .map(line -> line.substring(0, line.indexOf("@")))
                .map(line -> line + "\t" + salt)
                .sorted(Comparator.comparingLong(String::hashCode))
                .map(line -> line.hashCode() + "\t" + line.replace(salt, ""))
                .forEach(System.out::println);
    }
}
