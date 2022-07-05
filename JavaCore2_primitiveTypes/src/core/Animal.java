package core;


public class Animal {


    String sound = new String ("<<silence>>");
    protected Hearths hearth;

    protected void voice(final String sound){
        System.out.println(sound);
    }
    public void tmp (){
        voice(sound);
    }
}
