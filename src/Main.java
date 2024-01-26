import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите выражение в виде A + B :");
        String input = scanner.nextLine();
        try {
            System.out.println("Результат: "+Calculator.calc(input));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}