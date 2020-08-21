package converter;

import java.util.List;

class ErrorChecker {

    void checkNumberInputValue(List list) {
        if (list.size() < 3) {
            printError("Input parameters < 3.");
        }
    }

    void checkBaseValue(String str) {
        for (char c : str.toCharArray()) {
            if (c < '0' || c > '9') {
                printError("Base value incorrect.");
            }
        }

        int num = Integer.parseInt(str);
        if (num < 1 || num > 36) {
            printError("Base value contains invalid characters");
        }
    }

    void checkNumberValue(String str, int sourceBase) {
        for (char c : str.toCharArray()) {
            if (c < '0' || (c > '9' && c < 'a') || c > 'z') {
                printError("Number value contains invalid characters");
            }

            if (Integer.parseInt(Character.toString(c), 36) > sourceBase) {
                printError("Input value out of bound sourceBse.");
                return;
            }
        }
    }

    private void printError(String str) {
        System.out.printf("error: %s", str);
        System.exit(0);
    }
}
