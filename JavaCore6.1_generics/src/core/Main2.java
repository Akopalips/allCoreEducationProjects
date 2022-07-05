package core;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        DynamicArray<Integer> tmp = new DynamicArray<>();
        for (int i = 0; i < 20; i++) {
            tmp.add(i);
        }
        System.out.println(tmp.get(5) + " " + tmp.get(0));
        for (int i = 0; i < 10; i++) {
            tmp.remove(0);
        }
        System.out.println(tmp.get(5) + " " + tmp.get(0));

        for (int i = 0; i < 20; i++) {
            tmp.add(i);
        }
        tmp.remove(3);
        System.out.println(tmp.get(3));

    }

    /*Массивы в Java имеют фиксированную длину.
    Создайте класс DynamicArray, который
    хранит в себе массив
    имеет методы для добавления void add(T el),
    void remove(int index) удаления и извлечения
    T get(int index) из него элементов,
    при переполнении текущего массива, должен создаваться новый, большего размера.

    Для возможности работы с различными классами DynamicArray должен быть дженериком.
    Для решения задачи можно воспользоваться методами из класса java.util.Arrays.

    Требования:
    1. должен быть класс public static class DynamicArray
    2. класс DynamicArray должен иметь методы публичные void add(T el), void remove(int index) и T get(int index)
    3. класс DynamicArray должен иметь публичный конструктор по умолчанию
    3. работа методов должна соответствовать условию
    ------------------------------------------------------------------------------------------------------------------
    в начала массив = 0 длинна = 0
    добавляя элемент увиличиваем массив

    */
    public static class DynamicArray<T> {

        // убрать конструкторы, массив на 10-20 эл-тов
        // массив увеличивать в геометрической прогресии,
        // при удалении использовать System.arraycopy и уменьшения индекса,(2 строки)
        int filling = 0;
        private T[] array = (T[]) new Object[16];

        public void add(T element) {
            if (filling == (array.length)) {
                array = Arrays.copyOf(array, 2 * array.length);
            }
            array[filling++] = element;
        }

        public void remove(int index) {
            if (index < filling) {
                System.arraycopy(array, index + 1, array, index, filling - index - 1);
                if (filling-- == array.length / 2) {
                    array = Arrays.copyOf(array, array.length / 2);
                }
            } else {
                throw (new ArrayIndexOutOfBoundsException());
            }
        }

        public T get(int index) {
            if (index < filling) {
                return array[index];
            } else {
                throw (new ArrayIndexOutOfBoundsException());
            }
        }
    }
}
