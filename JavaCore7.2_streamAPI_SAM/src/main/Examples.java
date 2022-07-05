package main;

import java.util.stream.Stream;

public class Examples {
    public static void main(String[] args) {
        Examples mMain = new Examples();
        String HARDCODE = "Если в тексте меньше 10 уникальных слов, то выводите сколько есть.\n" +
                "\n" +
                "\n" +
                "Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте, то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.\n" +
                "\n" +
                "Задача имеет красивое решение через стримы без циклов и условных операторов. Попробуйте придумать его.";
        Stream<String> lines = HARDCODE.lines();
        lines.map(line -> line.split(" "))
                .forEach(System.out::println);

    }


}
