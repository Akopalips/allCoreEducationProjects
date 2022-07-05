package main;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Core {

    static void recursiveFileList(File fele) {
        recursiveFileList(fele, 0);
    }

    static void recursiveFileList(String filePath) {
        recursiveFileList(new File(filePath), 0);
    }

    private static void printNSpaces(int value) {
        for (int count = 0; count < value; count++) {
            System.out.print(' ');
        }
    }

    private static void recursiveFileList(File fele, int spaces) {
        if (fele.isFile()) {
            printNSpaces(spaces);
            System.out.println("Файл " + fele.getName() + " весит " + fele.length());
        } else {
            printNSpaces(spaces);
            try {
                System.out.println("Папка " + fele.getName() + ", путь " + fele.getCanonicalPath());
            } catch (IOException IOe) {
            }
            for (File each : fele.listFiles()) {
                try {
                    recursiveFileList(each, spaces + 1);
                } catch (NullPointerException npe) {
                }
            }
        }
    }

    private static void playWithFilesystem(String testFile) throws IOException {
        File myFile = new File(testFile, "tmp.tmp");
        myFile.createNewFile();
        System.out.println("Название файла: " + myFile.getName());
        System.out.println("Расположение файла: " + myFile.getCanonicalPath());
        System.out.println(myFile.exists() ? "Файл существует" : "Такого файла нет");
        System.out.println("Величина в байтах: " + myFile.length());
        System.out.println((new SimpleDateFormat("hh:mm:ss.SSSS")).format(new Date(myFile.lastModified())));
    }

    private static void fileInputStreamExample(String testFile) {
        try (FileInputStream myFIS = new FileInputStream(testFile + "/tmp.tmp")) {
            int size = myFIS.available();
            byte b[] = new byte[size / 2];
            myFIS.read(b);
            for (byte each : b) {
                System.out.print((char) each);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fileReaderExample(String testFile, Charset charset) {//java.nio.charsets.StandardCharsets.UTF_16
        int symbol;
        try (FileReader fr = new FileReader(testFile, charset)) {
            while ((symbol = fr.read()) > 0) {
                System.out.print((char) symbol);
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private static void fileWriterExample(String testFile, Charset cs, String append) {
        try (FileWriter fw = new FileWriter(testFile, cs, true)) {
            fw.write(append);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void consolePlay() {
        Console myC = System.console();
        char[] passwd;
        System.out.println("Enter your password below:");
        if ((passwd = myC.readPassword()) != null) {
            System.out.println(passwd);
        }
    }

    static class testSerializable implements Serializable {

    }

    private static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] mess = inputStream.readAllBytes();

        for (byte each : mess) {
            if (each % 2 == 0) {
                outputStream.write(each);
            }
        }
    }

    private static void printAll(InputStream is) throws IOException {
        for (byte each : is.readAllBytes()) {
            System.out.println(each);
        }
    }

    static private int sumOfStream(InputStream inputStream) throws IOException {

        byte[] fromStream = inputStream.readAllBytes();
        int result = 0;
        for (byte each : fromStream) {
            result += each;
        }
        return result;
    }

    static private int sumOfStream2(InputStream inputStream) throws IOException {
        int sum = 0;
        while (inputStream.available() > 0){
            sum += inputStream.read();
        }
        return sum;
    }

    public static class SerializableDemo implements Serializable{
        private int aNum = 10;
        protected String aStr = "Kappa";
        char aChar = '0';
        public Object aThing = new Object();
        transient boolean shit = true;
        public int getANum(){
            return aNum;
        }

        @Override
        public String toString() {
            return "SerializableDemo{" +
                    "aNum=" + aNum +
                    ", aStr='" + aStr + '\'' +
                    ", aChar=" + aChar +
                    ", aThing=" + aThing +
                    ", shit=" + shit +
                    '}';
        }
    }

    public static void serializableDemoDone(Path path) throws IOException, ClassNotFoundException{

        SerializableDemo theDemo = new SerializableDemo();
        try(ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))){
            oos.writeObject(theDemo);
        }
        Object objOut;
        try(ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))){
            objOut = ois.readObject();
        }
        System.out.println(objOut);
    }

    public static void javaCreatesFile ( int way) throws IOException{
        switch (way){
            case (1):{
                Runtime.getRuntime().exec("touch /home/tuspring/killme.tmp");
                break;
            }
            case (2):{
                FileWriter javaFileIO = new FileWriter("/home/tuspring/javaIOCreatesThisFile.tmp");
                break;
            }
            case (3):{
                Path javaFileNIO = Paths.get("/home/tuspring/javaNIOCreatesThisFile.tmp");
                java.nio.file.Files.createFile(javaFileNIO);
                break;
            }
        }
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        InputStreamReader tmp = new InputStreamReader(inputStream, charset);
        int inputByte = 0;
        StringBuilder mess = new StringBuilder();
        while ( (inputByte = tmp.read()) != -1){
            mess.append((char)inputByte);
        }
        return mess.toString();
    }


    public static void lsWithDirectoryStream(Path path) throws IOException{
        try (DirectoryStream<Path> ds = Files.newDirectoryStream(path)){
            for (Path child : ds){
                System.out.println(child.getFileName());
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String testFile = "/home/tuspring/tmp.tmp";
        String testDir = "/home/tuspring/";
        Path testPathFile = Paths.get(testFile);
        Path testPathDir = Paths.get(testDir);
        String mess = "testoviy test";
        Charset cs = StandardCharsets.UTF_8;

        lsWithDirectoryStream(testPathDir);
        throw NegativeArraySizeException


    }
}
