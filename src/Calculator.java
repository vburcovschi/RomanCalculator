public class Calculator {
    protected static String calc(String input) {
        String[] operands = Utils.parseInput(input);
        Utils.validateOperands(operands);
        if (Utils.checkArabicNumbers(operands[0]) && Utils.checkArabicNumbers(operands[2])) {
            return doOperation(operands[1].toCharArray()[0], Integer.parseInt(operands[0]),Integer.parseInt(operands[2]));
        } else {
            return Utils.arabicToRoman(Integer.parseInt(doOperation(operands[1].toCharArray()[0], Utils.RomanToArabic(operands[0]), Utils.RomanToArabic(operands[2]))));
        }
    }

    private static String doOperation(char operation, int num1, int num2) {
        Integer result = switch (operation) {
            case '+' -> num1 + num2;
            case '-' -> num1 - num2;
            case '*' -> num1 * num2;
            case '/' -> num1 / num2;
            default -> 0;
        };
        return result.toString();
    }
}
