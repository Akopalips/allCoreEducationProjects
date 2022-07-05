package main;

import java.io.*;

public class SerClass {
    public static void main(String[] args) {
        Animal[] zoo = new Animal[]{
                new Animal("Cat"),
                new Animal("Dog"),
                new Animal("kenguru"),
                new Animal("frog"),
                new Animal("test"),
                new Animal("bug")};
        byte[] mess = serializeAnimalArray(zoo);
        Animal[] zoo2 = deserializeAnimalArray(mess);
        for (Animal each :zoo2){
            System.out.println(each);
        }
    }

    static byte[] serializeAnimalArray(Animal[] mess) {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(byteStream)) {
            oos.writeInt(mess.length);
            for (Animal each : mess){
                oos.writeObject(each);
            }
        } catch (IOException skip) {

        }
        return byteStream.toByteArray();
    }

    static Animal[] deserializeAnimalArray(byte[] data) {
        Animal[] result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = ois.readInt();
            result = new Animal[size];
            for (int count = 0; count < size; count++) {
                result[count] = (Animal) ois.readObject();
            }
        } catch (ClassNotFoundException | IOException e) {
            throw(new IllegalArgumentException(e));
        }
        return result;
    }
/*Реализуйте метод, который из переданного массива байт восстановит массив объектов Animal.
Массив байт устроен следующим образом.
Сначала идет число типа int, записанное при помощи ObjectOutputStream.writeInt(size).
Далее подряд записано указанное количество объектов типа Animal, сериализованных при помощи ObjectOutputStream.writeObject(animal).

Если вдруг массив байт не является корректным представлением массива экземпляров Animal,
то метод должен бросить исключение java.lang.IllegalArgumentException.

подать на вход методу разные некорректные данные и посмотрите,
какие исключения будут возникать. Вот их-то и нужно превратить в IllegalArgumentException и выбросить.
Главное не глотать никаких исключений, т.е. не оставлять нигде пустой catch.
*/

}
