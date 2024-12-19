import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        // Разворот строки
        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println("Обратная строка: " + reversed);

        scanner.close();
    }
}
