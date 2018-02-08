#java -jar proguard\proguard-base-6.0.jar @L01.2.pro

-injars       target/L01.2.jar
-outjars      target/L01.2-out.jar

-printmapping pgmapout.map
-dontwarn

-keep public class ru.otus.l0111.Main {public static void main(java.lang.String[]);}