package ru.gynga.main;

import java.util.Scanner; 
import ru.gynga.math.Fraction;   
import ru.gynga.math.MathUtils;   
import ru.gynga.String.Name;   
import ru.gynga.String.Secret;

public class Lab3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "Cp866");
        
        System.out.println("=== 1. ТЕСТИРОВАНИЕ КЛАССА FRACTION (Задание 1.4 и 3.1) ===");
        System.out.println("\nВведите данные для Первой Дроби:");
        int num1 = readInteger(scanner, "Введите числитель: ");
        int den1 = readValidDenominator(scanner);
        Fraction f1 = new Fraction(num1, den1);
        
        System.out.println("\nВведите данные для Второй Дроби:");
        int num2 = readInteger(scanner, "Введите числитель: ");
        int den2 = readValidDenominator(scanner);
        Fraction f2 = new Fraction(num2, den2);
        
        System.out.println("\n--- Результаты арифметических операций ---");
        System.out.println("Первая дробь: " + f1);
        System.out.println("Вторая дробь: " + f2);
        System.out.println("Сложение (f1 + f2): " + f1.sum(f2));
        System.out.println("Вычитание (f1 - f2): " + f1.minus(f2));
        System.out.println("Умножение (f1 * f2): " + f1.multiply(f2));
        System.out.println("Деление (f1 / f2): " + f1.div(f2));

        System.out.println("\n=== 2. ТЕСТИРОВАНИЕ КЛАССА NAME (Задание 1.7) ===");
        System.out.print("Введите имя: ");
        String fName = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String lName = scanner.nextLine();
        System.out.print("Введите отчество: ");
        String patronymic = scanner.nextLine();

        Name userName = new Name(fName, lName, patronymic);
        System.out.println("Успешно создано имя: " + userName);

        System.out.println("\nПроверка валидации: Попытка создать абсолютно пустое имя...");
        try {
            Name badName = new Name("", "", "   ");
        } catch (IllegalArgumentException e) {
            System.out.println("Успешно перехвачена ошибка: " + e.getMessage());
        }

        System.out.println("\n=== 3. ТЕСТИРОВАНИЕ СТРУКТУРЫ ДАННЫХ SECRET (Задание 2.2) ===");
        System.out.print("Введите имя первого хранителя секрета: ");
        String keeper1 = scanner.nextLine();
        System.out.print("Введите сам текст секрета: ");
        String secretText = scanner.nextLine();

        Secret secret1 = new Secret(keeper1, secretText);
        System.out.println("Создан объект -> " + secret1); 

        System.out.print("\nКому " + keeper1 + " должен рассказать секрет? Введите имя: ");
        String keeper2 = scanner.nextLine();
        System.out.println("[Лог передачи секрета]:");
        Secret secret2 = new Secret(secret1, keeper2);
        System.out.println("Создан объект -> " + secret2);

        System.out.print("\nКому " + keeper2 + " должен рассказать секрет дальше? Введите имя: ");
        String keeper3 = scanner.nextLine();
        System.out.println("[Лог передачи секрета]:");
        Secret secret3 = new Secret(secret2, keeper3);
        System.out.println("Создан объект -> " + secret3);

        System.out.println("\n--- Анализ полученной цепочки секретов ---");
        System.out.println(keeper2 + " был в цепочке по счету: " + secret2.getSequenceNumber());
        System.out.println("Сколько человек узнали секрет ПОСЛЕ него: " + secret2.getCountAfterMe());
        System.out.println("Кто рассказал секрет ему (на 1 шаг раньше): " + secret2.getKeeperNameAt(-1));
        System.out.println("Разница в символах у третьего хранителя по сравнению с первым: " + secret3.getLengthDifferenceWith(-2));

        System.out.println("\nПопытка первого хранителя (" + keeper1 + ") рассказать этот же секрет кому-то еще...");
        try {
            Secret secret4 = new Secret(secret1, "Коля");
        } catch (RuntimeException e) {
            System.out.println("Защита инкапсуляции сработала! Ошибка: " + e.getMessage());
        }

        System.out.println("\n=== 4. ТЕСТИРОВАНИЕ ДРОБИ КАК ЧИСЛА (Задание 4.2) ===");
        System.out.println("Значение f1 в формате double: " + f1.doubleValue());
        System.out.println("Значение f1 в формате int (целая часть): " + f1.intValue());

        System.out.println("\n=== 5. МЕТОД СЛОЖЕНИЯ ЧИСЕЛ (Задание 5.1) ===");
        Fraction f5_1 = new Fraction(3, 5);
        double sum1 = MathUtils.sumAllNumbers(2, f5_1, 2.3);
        System.out.println("1) 2 + 3/5 + 2.3 = " + sum1);

        Fraction f5_2 = new Fraction(49, 12);
        Fraction f5_3 = new Fraction(3, 2);
        double sum2 = MathUtils.sumAllNumbers(3.6, f5_2, 3, f5_3);
        System.out.println("2) 3.6 + 49/12 + 3 + 3/2 = " + sum2);

        Fraction f5_4 = new Fraction(1, 3);
        double sum3 = MathUtils.sumAllNumbers(f5_4, 1);
        System.out.println("3) 1/3 + 1 = " + sum3);

        System.out.println("\n=== 6. СРАВНЕНИЕ ДРОБЕЙ (Задание 6.1) ===");
        int compareResult = f1.compareTo(f2);
        if (compareResult > 0) {
            System.out.println("Результат: Первая дробь (" + f1 + ") БОЛЬШЕ второй дроби (" + f2 + ")");
        } else if (compareResult < 0) {
            System.out.println("Результат: Первая дробь (" + f1 + ") МЕНЬШЕ второй дроби (" + f2 + ")");
        } else {
            System.out.println("Результат: Дроби равны (" + f1 + " = " + f2 + ")");
        }

        System.out.println("\n=== 7. ВОЗВЕДЕНИЕ ДРОБИ В СТЕПЕНЬ (Задание 7.3) ===");
        System.out.println("Введите новую дробь для возведения в степень:");
        int numPow = readInteger(scanner, "Введите числитель: ");
        int denPow = readValidDenominator(scanner);
        Fraction fPow = new Fraction(numPow, denPow);
        int extent = readInteger(scanner, "Введите целую степень: ");
        System.out.println("Результат: Дробь " + fPow + " в степени " + extent + " = " + fPow.pow(extent));


        // --- ДОБАВЛЕННЫЙ БЛОК ДЛЯ ЗАДАНИЯ 8.3 ---
        System.out.println("\n=== 8. КЛОНИРОВАНИЕ ДРОБИ (Задание 8.3) ===");
        Fraction clonedFraction = f1.clone(); // Вызываем наш метод clone
        System.out.println("Оригинальная дробь f1: " + f1);
        System.out.println("Клонированная дробь: " + clonedFraction);
        System.out.println("Указывают ли ссылки на один объект? " + (f1 == clonedFraction) + " (Так как объект неизменяемый)");
    }

    private static int readInteger(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int value = scanner.nextInt();
                scanner.nextLine(); 
                return value;
            } else {
                System.out.println("Ошибка! Нужно ввести целое число. Попробуйте еще раз.");
                scanner.nextLine(); 
            }
        }
    }

    private static int readValidDenominator(Scanner scanner) {
        while (true) {
            int den = readInteger(scanner, "Введите знаменатель (не 0): ");
            if (den != 0) {
                return den;
            }
            System.out.println("Ошибка! Знаменатель не может быть равен нулю. Попробуйте еще раз.");
        }
    }
}
