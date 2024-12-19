import java.security.SecureRandom;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PasswordGenerator {
    public static void main(String[] args) {
        // Определяем символы, которые будут использоваться для пароля
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        // Генерируем случайный 8-символьный пароль
        StringBuilder passwordBuilder = new StringBuilder(8);
        for (int i = 0; i < 8; i++) {
            int index = random.nextInt(chars.length());
            passwordBuilder.append(chars.charAt(index));
        }
        String password = passwordBuilder.toString();

        // Выводим символы, использованные в пароле
        Set<Character> uniqueChars = new HashSet<>();
        for (char c : password.toCharArray()) {
            uniqueChars.add(c);
        }

        // Преобразуем множество в массив и сортируем
        char[] usedChars = new char[uniqueChars.size()];
        int i = 0;
        for (char c : uniqueChars) {
            usedChars[i++] = c;
        }
        Arrays.sort(usedChars);

        // Выводим использованные символы
        System.out.println("Использованные символы (в порядке возрастания): " + Arrays.toString(usedChars));

        // Сравнение пароля
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите пароль (или нажмите Enter для выхода): ");
            String inputPassword = scanner.nextLine();

            // Позволяем выйти из программы, если введена пустая строка
            if (inputPassword.isEmpty()) {
                System.out.println("Вы вышли из программы.");
                break;
            }

            // Сравниваем пароли
            int matchCount = 0;
            for (int j = 0; j < password.length() && j < inputPassword.length(); j++) {
                if (password.charAt(j) == inputPassword.charAt(j)) {
                    matchCount++;
                }
            }

            if (inputPassword.equals(password)) {
                System.out.println("Пароль верен!");
                break;
            } else {
                System.out.println("Пароль неверен. Количество совпавших символов: " + matchCount);
            }
        }

        scanner.close();
    }
}
