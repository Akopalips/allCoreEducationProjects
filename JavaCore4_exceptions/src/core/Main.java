package core;

import java.io.*;
import java.nio.Buffer;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) throws Exception {


        @Override
        public void close () throws IOException {

        }
    }
        try(
    meme nene = new meme())

    {

    }
        System.out.println(new

    Object().

    getClass().

    getSuperclass());
    Random rng = new Random();
    int i0 = -rng.nextInt(10);
    int[] list = new int[10];
        System.out.println(list[i0]);
        try

    {
        try (MyShit ms = new MyShit()) {
            throw new Exception();
        } catch (RuntimeException re) {
            System.out.println(re);
        } catch (Exception e) {
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t);
            }
            e.addSuppressed(new Exception());
            for (Throwable t : e.getSuppressed()) {
                System.out.println(t);
            }
        } finally {
            throw new Exception();
        }
    } catch(
    Throwable t)

    {
        System.out.println("-------------------");
        for (Throwable each : t.getSuppressed()) {
            System.out.println(each);
        }
        System.out.println(t.getCause());
    }
}

static class MyShit implements AutoCloseable {

    @Override
    public void close() {
        throw new RuntimeException();
    }
}

                /*

        String path = new String("/home/tuspring/2tmp.py");
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            System.out.println(br.readLine());
            throw new IOException();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            for (StackTraceElement each : e.getStackTrace()) {
                System.out.println(each);
                System.out.println(each.getFileName());
            }
        }



        try {
            try {
                RuntimeException a = new RuntimeException();
                throw a;

            } catch (RuntimeException re) {
                RuntimeException a = new RuntimeException();
                a.initCause(re);
                throw a;
            } finally {
                RuntimeException b = new RuntimeException();
                System.out.println(b.getCause());
                System.out.println(b);
                throw b;
            }
        } catch (RuntimeException re) {
            System.out.println(re.getCause());
            System.out.println(re);
            for (StackTraceElement each : re.getStackTrace()) System.out.println(each);
        }
        */

}


/*
}
    public static void moveRobot(RobotConnectionManager robotConnectionManager, int toX, int toY) {
        boolean flag = false;
        for ( int i = 0; i < 3 ; i++){
            RobotConnection connection = null;
            try{
                connection = robotConnectionManager.getConnection();
                connection.moveRobotTo(toX, toY);
                flag = true;
                break;
            }catch(RobotConnectionException e){
            }finally{
                try{
                    if (connection != null){
                        connection.close();
                    }
                }catch (RobotConnectionException e){
                }
            }
        }
        if (flag == false){
            throw new RobotConnectionException("Connection failed.");
        }
    }
*/