package core;

public final class Cat extends Animal {
    final
    int count = 0;
    String name ;
    final Hearths hearth = Hearths.four_chambered;
    static boolean skin = true;

    public void sayHello() {
        System.out.println("Мяу!");
    }

    @Override
    public void voice(String sound) {
        System.out.printf("The cat %s say %s\n", name, sound);
    }
    public  Cat (String name){
        this.name = name;
    }

}
