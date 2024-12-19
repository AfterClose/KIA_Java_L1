import java.util.Random;
import java.util.Scanner;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число от 1 до 20: ");
        int count = scanner.nextInt();

        // Проверка, чтобы число было в заданном диапазоне
        if (count < 1 || count > 20) {
            System.out.println("Число должно быть от 1 до 20!");
        } else {
            Random random = new Random();
            System.out.println("Случайные числа:");

            for (int i = 0; i < count; i++) {
                int randomNumber = random.nextInt(1999) - 999; // Генерация числа от -999 до 999
                System.out.print(randomNumber + " ");
            }
            System.out.println(); // Перевод строки после вывода чисел
        }

        scanner.close();
    }
}
