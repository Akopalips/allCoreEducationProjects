package main;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice7_2_12 {
    /*Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов, и в конце выводящую 10 наиболее часто встречающихся слов.

Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например, в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово. Выводите слова в нижнем регистре.

Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.

Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.


        текст
        приводится в нижний регистр
        удаляются знаки пунктуации
        подсчет дубликатов

        сортировка по частоте появления в тексте
        сортировка по символам строки
    * */
    public static void main(String[] args) throws IOException {
        Practice7_2_12 mMain = new Practice7_2_12();
        //"Lorem\n. ipsum\n. dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim."
        String HARDCODE = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed sodales consectetur purus at faucibus. Donec mi quam, tempor vel ipsum non, faucibus suscipit massa. Morbi lacinia velit blandit tincidunt efficitur. Vestibulum eget metus imperdiet sapien laoreet faucibus. Nunc eget vehicula mauris, ac auctor lorem. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer vel odio nec mi tempor dignissim.\n";

        String encoding = "UTF-8";


        ArrayList<Integer> arli = new ArrayList();
        arli.add(1);
        arli.add(12);
        arli.add(123);
        ArrayList<Integer> rali = (ArrayList<Integer>) arli.clone();
        Collections.unmodifiableList(arli).stream()
                .peek(rali::add)
                .forEach(System.out::println);
        System.out.println(rali);


        //mMain.show10MostFrequencyWords(new ByteArrayInputStream(HARDCODE.getBytes(encoding)), encoding);

    }

    public void show10MostFrequencyWords(InputStream input, String encoding) throws IOException {

        new BufferedReader(new InputStreamReader(System.in, "UTF-8")).lines()
                .flatMap(line -> Arrays.stream(line
                        .toLowerCase()
                        .replaceAll("[^a-zа-я0-9 ]", " ")
                        .split(" ")))
                .filter(word -> word.length() > 0)
                .collect(Collectors.toMap(String::toString, s -> 1, Integer::sum))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .limit(10).map(Map.Entry::getKey)
                .forEach(System.out::println);
//                .sorted(Map.Entry.comparingByKey())
//                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
    }
}