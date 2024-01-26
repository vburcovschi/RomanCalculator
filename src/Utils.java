public class Utils {
    protected static String[] parseInput(String input) {
        String[] parsedInput = input.split(" ");
        if (parsedInput.length != 3) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }
        return parsedInput;
    }

    protected static void validateOperands(String[] operands) {
        boolean isArabicNum1 = checkArabicNumbers(operands[0]);
        boolean isArabicNum2 = checkArabicNumbers(operands[2]);
        if (operands[1].length() != 1) {
            throw new IllegalArgumentException("Неверный формат ввода");
        }
        if (isArabicNum1 != isArabicNum2) {
            throw new IllegalArgumentException("Числа должны быть одного типа");
        }
        int num1;
        int num2;
        if (isArabicNum1) {
            num1 = Integer.parseInt(operands[0]);
            if (num1 > 10) throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            num2 = Integer.parseInt(operands[2]);
            if (num2 > 10) throw new IllegalArgumentException("Числа должны быть от 1 до 10");
        } else {
            num1 = RomanToArabic(operands[0]);
            num2 = RomanToArabic(operands[2]);
            if ((num1 < num2) && (operands[1].equals("-"))) {
                throw new IllegalArgumentException("Результат не может быть отрицательным в римской системе счисления");
            }
        }
        if (num2 == 0 && operands[1].equals("/")) {
            throw new ArithmeticException("Деление на ноль");
        }
        if (num1 < num2 && operands[1].equals("/")) {
            throw new IllegalArgumentException("Результат меньше единицы");
        }
    }

    protected static boolean checkArabicNumbers(String operand) {
        return operand.matches("[0-9]+");
    }

    protected static int RomanToArabic(String operand) {
        int result = 0;
        int previousValue = 0;

        for (int i = operand.length() - 1; i >= 0; i--) {
            int currentValue = RomanNumeral.valueOf(String.valueOf(operand.charAt(i))).getValue();

            if (currentValue < previousValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            previousValue = currentValue;
        }
        return result;
    }

    protected static String arabicToRoman(int number) {
        if (number <= 0 || number >= 4000) {
            throw new IllegalArgumentException("Числи выходид за пределы исчисления (1 to 3999)");
        }

        StringBuilder roman = new StringBuilder();

        for (RomanNumeral numeral : RomanNumeral.values()) {
            while (number >= numeral.getValue()) {
                roman.append(numeral.name());
                number -= numeral.getValue();
            }
        }
        return roman.toString();
    }

}
