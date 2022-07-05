package core;

public class CatDog {


    public static class Dog {
        public void sayHello() {
            System.out.println("Гав!");
        }

        public void catchCat(Cat aCat) {
            System.out.println("Кошка поймана");
            sayHello();
            aCat.sayHello();
        }
    }


}
