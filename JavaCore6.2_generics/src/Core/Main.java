package Core;

import java.io.Reader;
import java.io.StringReader;
import java.util.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.HashSet;

import static java.lang.String.valueOf;


/*#3
программа прочитает из System.in
последовательность целых чисел, разделенных пробелами
удалит из них все числа, стоящие на четных позициях
выведет получившуюся последовательность в обратном порядке в System.out.

Все числа int. Позиции нумеруются с нуля.

Пример ввода: 1 2 3 4 5 6 7 8 9 10
Пример вывода: 10 8 6 4 2
 */
public class Main {

    static class Tmp{
        int tmp;
        public Tmp(int t){
            tmp = t;
        }
        public int hashCode(){
            return tmp % 5;
        }
        public String toString(){
            return valueOf(tmp);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Tmp tmp1 = (Tmp) o;
            return tmp == tmp1.tmp;
        }
    }
    public static void main(String[] args) {

        HashMap <Tmp, Integer> tmp = new HashMap<>(2, 1F) ;
        tmp.put(null, null);
        tmp.put(null, null);
        for (int i = 0; i < 20; i++){
            tmp.put(new Tmp(i % 5), i);
            System.out.println(tmp);
        }

        /*#3
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while (scanner.hasNext()) {
            scanner.nextInt();
            if (scanner.hasNext()) {
                stack.push(scanner.nextInt());
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        */
        /*#1

        Set<Integer>
                set1 = new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3})),
                set2 = new HashSet<>(Arrays.asList(new Integer[]{2, 3, 4})),
                set3 = new HashSet<>(set2);
        set3.remove(2);

        System.out.println(symmetricDifference(set1, set2));
        System.out.println(set1);
        System.out.println(set2);
        System.out.println(set3);
        */
        /*#2
        Reader reader = new StringReader(
                "Алексей 3000\n" +
                        "Дмитрий 9000\n" +
                        "Антон 3000\n" +
                        "Алексей 7000\n" +
                        "Антон 8000");
        getSalesMap(reader);

         */
    }


    /*#1
    Реализуйте метод symmetricDifference,
    вычисляющий симметрическую разность двух множеств.
    должен возвращать результат в виде нового множества.
    Изменять переданные в него множества не допускается.

    Пример ввода: [1, 2, 3} и {0, 1, 2]
    Пример вывода: [0, 3]
     */
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {//1
        Set<T> symmetrical = new LinkedHashSet<>(set1), different = new LinkedHashSet<>(set1);
        different.addAll(set2);
        symmetrical.retainAll(set2);
        different.removeAll(symmetrical);
        return different;
    }

    /*#2
    Магазину нужно сохранять информацию о продажах для каждого сотрудника.
    Напишите метод Map getSalesMap(Reader reader) который принимает Reader содержащий строки вида:

    Алексей 3000
    Дмитрий 9000
    Антон 3000
    Алексей 7000
    Антон 8000

    Метод должен получить все строки из Reader
    заполнить и вернуть карту где
        ключом будет имя сотрудника,
        значением сумма всех его продаж.

    Пример ввода:
    Алексей 3000
    Дмитрий 9000
    Антон 3000
    Алексей 7000
    Антон 8000

    Пример вывода:
    {Алексей=[10000], Дмитрий=[9000], Антон=[11000]}
     */
    public static Map <String, Long> getSalesMap(Reader reader) {//2
        Scanner scanner = new Scanner(reader);
        Map<String, Long> map = new HashMap<>();
        String employeeName;
        Long saleValue;

        while (scanner.hasNext()) {
            employeeName = scanner.next();
            saleValue = scanner.nextLong();
            map.merge(employeeName, saleValue, Long::sum);
        }
        System.out.println(map);
        return map;
    }

    public static class Thing <T extends Iterable>{
        public static <T> T thing (T t){
            return t;
        }
    }
}
