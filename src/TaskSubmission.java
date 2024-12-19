import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskSubmission {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос информации у пользователя
        System.out.print("Введите фамилию разработчика: ");
        String developerSurname = scanner.nextLine();

        System.out.print("Введите дату и время получения задания (yyyy-MM-dd HH:mm): ");
        String startDateStr = scanner.nextLine();

        System.out.print("Введите дату и время сдачи задания (yyyy-MM-dd HH:mm): ");
        String endDateStr = scanner.nextLine();

        // Форматирование и вывод в табличном виде
        System.out.printf("%-20s %-30s %-30s%n", "Фамилия разработчика", "Дата и время получения задания", "Дата и время сдачи задания");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-20s %-30s %-30s%n", developerSurname, startDateStr, endDateStr);

        scanner.close();
    }
}
