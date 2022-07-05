package core;

//task 3.3.12
public class Human {
    private byte age;
    private String name;
    private String secondName;
    private String favoriteSport;

    public Human (){
        age = 0;
        name = "NoName";
        secondName = "NoSecondName";
        favoriteSport = "NoFavoriteSport";
    }
    public Human (byte age, String name, String secondName, String favoriteSport){
        this(age, name, secondName);
        this.favoriteSport = favoriteSport;
    }
    public Human (byte age, String name, String secondName){
        this.age = age;
        this.name = name;
        this.secondName = secondName;
        favoriteSport = "NoFavoriteSport";
    }
}
