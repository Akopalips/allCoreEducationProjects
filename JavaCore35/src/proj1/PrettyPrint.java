package proj1;

import java.util.ArrayList;

public class PrettyPrint {
    public static void printArrayOfIntAsTable(int cols, ArrayList inputArray) {
        int rows = inputArray.size() / cols + (inputArray.size() % cols > 0 ? 1 : 0);

        for (int iterator = 0; iterator < inputArray.size(); iterator++) {
            System.out.printf("%s" + ( (iterator + 1) % cols > 0 ? " " : "\n"), inputArray.get(iterator).toString());
        }
    }
}
