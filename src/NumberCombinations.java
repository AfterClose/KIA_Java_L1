import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberCombinations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрашиваем количество чисел от 2 до 6
        int count;
        do {
            System.out.print("Введите количество целых чисел (от 2 до 6): ");
            count = scanner.nextInt();
        } while (count < 2 || count > 6);

        // Запрашиваем у пользователя целые числа
        List<Integer> numbers = new ArrayList<>();
        System.out.println("Введите " + count + " целых чисел:");
        for (int i = 0; i < count; i++) {
            numbers.add(scanner.nextInt());
        }

        // Подсчитываем суммы и произведения
        int sum = calculateSum(numbers);
        int product = calculateProduct(numbers);

        // Выводим результаты
        System.out.println("Сумма: " + sum);
        System.out.println("Произведение: " + product);

        scanner.close();
    }

    // Метод для подсчета суммы
    private static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Метод для подсчета произведения
    private static int calculateProduct(List<Integer> numbers) {
        int product = 1;
        for (int number : numbers) {
            product *= number;
        }
        return product;
    }

}
