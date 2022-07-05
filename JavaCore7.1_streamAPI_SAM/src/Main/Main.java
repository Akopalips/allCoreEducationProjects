package Main;

import java.util.Objects;
import java.util.function.*;

public class Main {
    public static void main(String[] args ){
        Main mMain = new Main();

        System.out.println(mMain.sqrt().apply(5));

        Consumer<String> tmp = (line) -> System.out.println(line);
        tmp.accept("123");

        System.out.println(Main.getGenerator().cond(10));
        System.out.println(Main.getGenerator().cond(10.2));
        System.out.println(Main.getGenerator().cond(-10));
        System.out.println(Main.getGenerator().cond(5L));
        System.out.println(Main.getGenerator().cond(5f));

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = mMain.ternaryOperator(condition, ifTrue, ifFalse);
        System.out.println(safeStringLength.apply(null));
    }
    /*1 Напишите метод с названием sqrt, который
    возвращает реализацию функционального интерфейса UnaryOperator,
    который принимает целое число(тип int) и
    возвращает его квадрат.
    Метод должен возвращать реализацию интерфейса UnaryOperator.
    */
    public UnaryOperator<Integer> sqrt() {
        return (a) -> a * a;
    }
    /*2 Создайте функциональный интерфейс NumberGenerator, параметризованный таким образом, что
    принимает только наследников класса Number,
    имеющий метод boolean cond(T arg).

    Создайте в методе public static NumberGenerator<? super Number> getGenerator() с помощью лямбда выражения
    реализацию NumberGenerator, которая возвращает true, если число в int эквиваленте больше 0.

    Требования:
    1. Должен быть метод public static NumberGenerator<? super Number> getGenerator()
    2. Соблюдайте код стайл при параметризации.
    3. Имя параметра должно быть "Т"
    4. Метод должен возвращать корректную реализацию
    */
    @FunctionalInterface
    interface NumberGenerator<T extends Number>{
        boolean cond(T arg);
    }
    public static NumberGenerator<? super Number> getGenerator() {
        return (T) -> T.intValue() > 0;
    }

    /*Дан предикат condition и две функции ifTrue и ifFalse.
    Напишите метод ternaryOperator, который из них построит новую функцию,
    возвращающую значение функции ifTrue, если предикат выполнен, и значение ifFalse иначе.


    Пример использования метода
    (можно было все свернуть в одну строчку, но для наглядности все элементы вынесены в отдельные переменные):

    Predicate<Object> condition = Objects::isNull;
    Function<Object, Integer> ifTrue = obj -> 0;
    Function<CharSequence, Integer> ifFalse = CharSequence::length;
    Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);
    Результирующая функция будет для нулевых ссылок на String возвращать 0, а для ненулевых ссылок возвращать длину строки.

    1. Должен быть метод public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition, Function<? super T, ? extends U> ifTrue, Function<? super T, ? extends U> ifFalse)
    2. Метод должен возвращать функцию
    3. Используйте лямбда-выражение
    */
    public <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return (t) -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);

    }

}
