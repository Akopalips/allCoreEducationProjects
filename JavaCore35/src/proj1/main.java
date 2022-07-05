package proj1;

import java.util.ArrayList;


public class main {
    public static void main(String[] args) {
        // найти все простые числа до int
        ArrayList allPrimeNum = main.primeNumbers();
        System.out.println(allPrimeNum.size());
        PrettyPrint.printArrayOfIntAsTable(10, allPrimeNum);
    }

    static ArrayList primeNumbers() {
        ArrayList result = new ArrayList();
        boolean isPrime;
        System.out.println("begins");
        for (int iterator = 2; iterator <= 1000000; iterator++) {
            isPrime = true;
            for (Object each : result) {
                int intEach = (int) each;
                if (iterator % intEach == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime == true){
                result.add(iterator);
            }
        }
        System.out.println("ends");
        result.add(0, 1);
        return result;
    }


    protected static int testRecursion(int a) {
        if (a == 1) {
            return 1;
        } else {
            if (a > 0) {
                return (a * testRecursion(a - 1));
            } else {
                return 0;
            }
        }
    }

    protected final void exampleWithRecursion() {
        /*
        main a = new main();
        a.exampleWithRecursion();
        * */

        int a = 1, b;
        do {
            b = main.testRecursion(a);
            System.out.println(b);
            a += 1;
        }
        while (b > 0);
    }
}
