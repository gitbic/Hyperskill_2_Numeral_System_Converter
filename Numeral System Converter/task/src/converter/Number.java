package converter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Number {
    private Scanner scanner = new Scanner(System.in);
    private ErrorChecker erCheck = new ErrorChecker();

    private String inputNumberIntegerPart = "";
    private String inputNumberFractionsPart = "";
    private int sourceBase;
    private int newBase;
    private int decimalNumberIntegerPart;
    private double decimalNumberFractionsPart = 0;
    private String resultIntegerPart = "";
    private String resultFractionsPart = "";

    void setInputValue() {
        List<String> listInputValue = new ArrayList<>();

        while (scanner.hasNext()) {
            listInputValue.add(scanner.nextLine());
        }
        erCheck.checkNumberInputValue(listInputValue);

        erCheck.checkBaseValue(listInputValue.get(0));
        erCheck.checkBaseValue(listInputValue.get(2));
        sourceBase = Integer.parseInt(listInputValue.get(0));
        newBase = Integer.parseInt(listInputValue.get(2));

        erCheck.checkNumberValue(listInputValue.get(1).replaceAll("\\.", ""), sourceBase);
        String[] inputNumber = listInputValue.get(1).split("\\.");
        inputNumberIntegerPart = inputNumber[0];
        if (inputNumber.length == 2) {
            inputNumberFractionsPart = inputNumber[1];
        }
    }

    void convertBaseToDecimal() {
        if (sourceBase == 1) {
            decimalNumberIntegerPart = inputNumberIntegerPart.length();
        } else {
            decimalNumberIntegerPart = Integer.parseInt(inputNumberIntegerPart, sourceBase);
            for (int i = 0; i < inputNumberFractionsPart.length(); i++) {
                int num = Integer.parseInt(inputNumberFractionsPart.substring(i, i + 1), sourceBase);
                decimalNumberFractionsPart += num / Math.pow(sourceBase, i + 1);
            }
        }
    }

    void convertDecimalToBase() {
        if (newBase == 1) {
            for (int i = 0; i < decimalNumberIntegerPart; i++) {
                resultIntegerPart += "1";
            }
        } else {
            resultIntegerPart = Integer.toString(decimalNumberIntegerPart, newBase);

            double rest = decimalNumberFractionsPart;
            double num;
            for (int i = 0; i < 5; i++) {
                num = rest * newBase;
                rest = num - (int) num;
                resultFractionsPart += Integer.toString((int) num, newBase);
            }
        }
    }

    void printNewBaseNumber() {
        System.out.println(resultIntegerPart + "." + resultFractionsPart);
    }
}
