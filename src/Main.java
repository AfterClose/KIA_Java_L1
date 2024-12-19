import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество целых чисел n: ");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Введите " + n + " целых чисел:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Вызов каждого метода для выполнения задания
        printEvenAndOdd(numbers);
        printMaxAndMin(numbers);
        printDivisibleBy3Or9(numbers);
        printDivisibleBy5And7(numbers);
        printThreeDigitUnique(numbers);
        printPrimeNumbers(numbers);
        printSortedNumbers(numbers);
        printFrequencyDescending(numbers);
        printLuckyNumbers(numbers);
        printPalindromes(numbers);
        printHalfSumNeighbors(numbers);

        scanner.close();
    }

    // 1. Четные и нечетные числа
    private static void printEvenAndOdd(int[] numbers) {
        System.out.println("Четные и нечетные числа:");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " (четное) ");
            } else {
                System.out.print(num + " (нечетное) ");
            }
        }
        System.out.println();
    }

    // 2. Наибольшее и наименьшее число
    private static void printMaxAndMin(int[] numbers) {
        int max = Arrays.stream(numbers).max().orElse(Integer.MIN_VALUE);
        int min = Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
        System.out.println("Наибольшее: " + max + ", Наименьшее: " + min);
    }

    // 3. Числа, которые делятся на 3 или на 9
    private static void printDivisibleBy3Or9(int[] numbers) {
        System.out.println("Числа, которые делятся на 3 или на 9:");
        for (int num : numbers) {
            if (num % 3 == 0 || num % 9 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // 4. Числа, которые делятся на 5 и на 7
    private static void printDivisibleBy5And7(int[] numbers) {
        System.out.println("Числа, которые делятся на 5 и на 7:");
        for (int num : numbers) {
            if (num % 5 == 0 && num % 7 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // 5. Все трехзначные числа без одинаковых цифр
    private static void printThreeDigitUnique(int[] numbers) {
        System.out.println("Трехзначные числа без одинаковых цифр:");
        for (int num : numbers) {
            if (num >= 100 && num <= 999 && hasDistinctDigits(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // 6. Простые числа
    private static void printPrimeNumbers(int[] numbers) {
        System.out.println("Простые числа:");
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // 7. Отсортированные числа
    private static void printSortedNumbers(int[] numbers) {
        int[] sortedAsc = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(sortedAsc);
        System.out.println("Числа в порядке возрастания: " + Arrays.toString(sortedAsc));

        Integer[] sortedDesc = Arrays.stream(sortedAsc).boxed().toArray(Integer[]::new);
        Arrays.sort(sortedDesc, Collections.reverseOrder());
        System.out.println("Числа в порядке убывания: " + Arrays.toString(sortedDesc));
    }

    // 8. Частота чисел
    private static void printFrequencyDescending(int[] numbers) {
        System.out.println("Числа в порядке убывания частоты встречаемости:");
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : numbers) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        frequencyMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.print(entry.getKey() + " "));
        System.out.println();
    }

    // 9. «Счастливые» числа (например, 1-9)
    private static void printLuckyNumbers(int[] numbers) {
        System.out.println("Счастливые числа (1-9):");
        for (int num : numbers) {
            if (num >= 1 && num <= 9) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // 10. Числа-палиндромы
    private static void printPalindromes(int[] numbers) {
        System.out.println("Числа-палиндромы:");
        for (int num : numbers) {
            if (isPalindrome(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }

    // 11. Элементы, которые равны полусумме соседних элементов
    private static void printHalfSumNeighbors(int[] numbers) {
        System.out.println("Элементы, которые равны полусумме соседних элементов:");
        for (int i = 1; i < numbers.length - 1; i++) {
            if (numbers[i] == (numbers[i - 1] + numbers[i + 1]) / 2) {
                System.out.print(numbers[i] + " ");
            }
        }
        System.out.println();
    }

    // Вспомогательные функции
    private static boolean hasDistinctDigits(int num) {
        String digits = Integer.toString(num);
        Set<Character> digitSet = new HashSet<>();
        for (char digit : digits.toCharArray()) {
            if (!digitSet.add(digit)) {
                return false; // Duplicate found
            }
        }
        return true;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static boolean isPalindrome(int num) {
        String str = Integer.toString(num);
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
