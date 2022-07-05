package main;


import java.util.*;
import java.util.function.BiConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Main mMain = new Main();

//        System.out.println(null == null);
//
//        int jinx = 19;
//        IntStream pseudoRandomStreamObject = pseudoRandomStream(jinx).limit(15).peek(System.out::println);
//        mMain.findMinMax(
//                pseudoRandomStreamObject.boxed(),
//                (Integer o1, Integer o2) -> o1.compareTo(o2 + 1),
//                (Integer out1, Integer out2) -> System.out.println(out1 + " " + out2));//19 984


    }


    /*
        Берется какое-то начальное неотрицательное число (оно будет передаваться в ваш метод проверяющей системой).
        Первый элемент последовательности устанавливается равным этому числу.
        Следующие элементы вычисляются по рекуррентной формуле Rn+1=mid(Rn2),
        где mid — это функция, выделяющая второй, третий и четвертый разряд переданного числа. Например, mid(123456)=345.

        Пример ввода: 13
        Пример вывода: 13, 16, 25, 62, 384, 745, 502, 200, 0, ... (дальше бесконечное количество нулей)

        сложение двух стримов, из одного элемента seed и из последовательности, основанной на n
    */
    public static IntStream pseudoRandomStream(int seed) {
        return IntStream.iterate(seed, n -> n * n / 10 % 1000);
    }

    /*
        Напишите метод, находящий в стриме минимальный и максимальный элементы
        в соответствии c порядком, заданным Comparator'ом.

        Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:

                minMaxConsumer.accept(min, max);
        Если стрим не содержит элементов, то вызовите:

                minMaxConsumer.accept(null, null);

        Создай стрим из листа без инициализации полей
                */
    public <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> streamAsList = (List<T>) stream.sorted(order).toList();
        if (streamAsList.isEmpty()) {
            minMaxConsumer.accept(null, null);
        } else {
            minMaxConsumer.accept(streamAsList.get(0), streamAsList.get(streamAsList.size() - 1));
        }

//        T min = null;
//        T max = null;
//        for (T thing : stream.toList()) {
//            if (min == null || order.compare(min, thing) > 0) {
//                min = thing;
//            }
//            if (max == null || order.compare(max, thing) < 0) {
//                max = thing;
//            }
//        }
//        stream.close();
//        minMaxConsumer.accept(min, max);
    }

/*
    1. Что такое метод референс?
    2. Что такое «анонимные классы»?
    3. Можно ли создать анонимный класс от String?
    4. Расскажите про Comparator и Comparable?
    5. ForEach vs ForEachOrdered

    2.11 - Создай стрим из листа без инициализации полей
    2.12 - сделай до 1 очень длинной строки
    без метода main
    Комментарии по практическим задачам отсутствуют.
*/
}
