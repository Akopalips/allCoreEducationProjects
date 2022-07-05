package enumExampl;

public class main {
    public static void main (String []args){
        System.out.println(myEnum.valueOf("orange"));
        System.out.println(myEnum.values());
        for ( myEnum one : myEnum.values()){
            System.out.println(String.format("%s %s", one.ordinal(), one.name()));
        }
    }
}
