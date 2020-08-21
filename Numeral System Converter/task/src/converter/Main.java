package converter;

public class Main {
    public static void main(String[] args) {
        Number number = new Number();

        number.setInputValue();
        number.convertBaseToDecimal();
        number.convertDecimalToBase();
        number.printNewBaseNumber();
    }
}
