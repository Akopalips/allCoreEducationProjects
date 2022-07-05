package core;

import java.util.Objects;
import java.util.Optional;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        Main core = new Main();

        /*
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println("" +i + s+ mustAlsoBeTrue + mustBeTrue);//i + s + mustBeTrue, mustAlsoBeTrue

         */
        /*
        Integer [] array = new Integer[]{1,2,5,8,6,7,2,9,20};
        Main2.DynamicArray <Integer> tmp = new Main2.DynamicArray<Integer>(array);
        tmp.add(50);
        for ( int each = 0; each < array.length + 1; each++){
            System.out.print(tmp.get(each) + " ");
        }
        System.out.println();
        tmp.remove(9);
        System.out.println(tmp.get(8));
        for ( int each = 0; each < array.length; each++){
            System.out.print(tmp.get(each) + " ");
        }*/


    }

    public class Testing<T>{

        <T> Testing <T> getter (){
            return new Testing<T>();
        }
    }




//возвращает пустой параметризованный объект типа Box,


    /*Реализуйте generic-класс Pair, похожий на Optional, но
    содержащий пару элементов разных типов и не запрещающий элементам принимать значение null.

    Реализуйте методы getFirst(), getSecond(), equals() и hashCode(),
    а также статический фабричный метод of(). Конструктор должен быть закрытым (private).
    * */
    public static class Pair<T, R> {

        private final T value1;
        private final R value2;

        private Pair(T input1, R input2) {
            this.value1 = input1;
            this.value2 = input2;
        }

        public static <T, R> Pair<T, R> of(T input1, R input2) {
            return new Pair <> (input1, input2);
        }

        public T getFirst(){
            return this.value1;
        }

        public R getSecond(){
            return this.value2;
        }

        public boolean equals(Object obj) {

            if (this == obj) {
                return true;
            } else if (!(obj instanceof Pair)) {
                return false;
            } else {
                Pair <?, ?> other = (Pair) obj;
                return (Objects.equals(this.value1, other.value1) & (Objects.equals(this.value2, other.value2)));
            }
        }

        public int hashCode() {
            return Objects.hashCode(this.value1) + Objects.hashCode(this.value2);
        }
    }

}