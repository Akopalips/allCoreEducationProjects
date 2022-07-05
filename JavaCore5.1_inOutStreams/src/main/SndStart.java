package main;

import java.io.*;
import java.nio.charset.*;

public class SndStart {
    static void createInputStreamWithNums() throws IOException {
        InputStream is = new ByteArrayInputStream(new byte[]{1, 2, 3});
        System.out.println(is.read());
    }

    static void createOutputStreamWithNums() throws IOException {
        OutputStream os = new ByteArrayOutputStream();
        os.write(new byte[]{1, 2, 3});
        os.flush();

    }

    static int sumOfStream(InputStream inputStream) throws IOException {
        int sum = 0;
        while (inputStream.available() > 0) {
            sum += (byte)inputStream.read();
        }
        return sum;
    }

    public static void print(InputStream inputStream, OutputStream outputStream) throws IOException {
        int tmp;
        while (inputStream.available() > 0){
            tmp = inputStream.read();
            if (tmp % 2 == 0){
                outputStream.write(tmp);
            }
        }
        outputStream.flush();
    }

    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        Reader tmp = new InputStreamReader(inputStream, charset);
        StringBuilder mess = new StringBuilder();
        while ( tmp.ready()){
            mess.append(tmp.read());
        }
        return mess.toString();
    }

    public static void main(String[] args) throws IOException, NumberFormatException, NullPointerException {
        System.out.printf("%f", (double)0);
    }


}
