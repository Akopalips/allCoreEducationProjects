package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)throws NumberFormatException, NullPointerException {
        Scanner sysInputScanner = new Scanner(System.in);
        double sum = 0;
        while (sysInputScanner.hasNext()) {
            if (sysInputScanner.hasNextDouble()){
                sum += Double.parseDouble(sysInputScanner.next());
            }else{
                sysInputScanner.next();
            }
        }
        System.out.printf("%f", sum);
    }
}