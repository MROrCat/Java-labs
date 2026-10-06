import java.util.Scanner;

public class Lab1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Лабораторная работа №1 ===");
        
        double x1_1 = 0;
        while (true) {
            System.out.print("\n[Задача 1.1] Введите вещественное число (например, 5,25): ");
            if (scanner.hasNextDouble()) {
                x1_1 = scanner.nextDouble();
                break;
            } else {
                System.out.println("Ошибка! Введено не вещественное число. Попробуйте снова.");
                scanner.next();
            }
        }
        System.out.println("Дробная часть: " + fraction(x1_1));

        int x1_2 = 0;
        while (true) {
            System.out.print("\n[Задача 1.2] Введите целое число (не менее 2 знаков): ");
            if (scanner.hasNextInt()) {
                x1_2 = scanner.nextInt();
                if (Math.abs(x1_2) >= 10) {
                    break;
                } else {
                    System.out.println("Ошибка! В числе должно быть минимум два знака.");
                }
            } else {
                System.out.println("Ошибка! Введено не целое число. Попробуйте снова.");
                scanner.next();
            }
        }
        System.out.println("Сумма двух последних цифр: " + sumLastNums(x1_2));

        char symbol1_3 = ' ';
        while (true) {
            System.out.print("\n[Задача 1.3] Введите ОДИН символ-цифру (от 0 до 9): ");
            String inputStr = scanner.next();
            if (inputStr.length() == 1 && Character.isDigit(inputStr.charAt(0))) {
                symbol1_3 = inputStr.charAt(0);
                break;
            } else {
                System.out.println("Ошибка! Нужно ввести строго ОДИН символ и строго ЦИФРУ.");
            }
        }
        System.out.println("Преобразованное число: " + charToNum(symbol1_3));

        int x1_4 = 0;
        while (true) {
            System.out.print("\n[Задача 1.4] Введите целое число для проверки на положительность: ");
            if (scanner.hasNextInt()) {
                x1_4 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введено не целое число. Попробуйте снова.");
                scanner.next();
            }
        }
        System.out.println("Число положительное? -> " + isPositive(x1_4));

        int x1_5 = 0;
        while (true) {
            System.out.print("\n[Задача 1.5] Введите целое число для проверки на двузначность: ");
            if (scanner.hasNextInt()) {
                x1_5 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введено не целое число. Попробуйте снова.");
                scanner.next();
            }
        }
        System.out.println("Число двузначное? -> " + is2Digits(x1_5));
        // ЗАДАНИЕ 2. УСЛОВИЯ
        System.out.println("\n==========================================");
        System.out.println("=== ПЕРЕХОД К ЗАДАНИЮ 2. УСЛОВИЯ ===");
        System.out.println("==========================================");
        int x2_1 = 0;
        while (true) {
            System.out.print("\n[Задача 2.1] Введите целое число для поиска модуля: ");
            if (scanner.hasNextInt()) {
                x2_1 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Модуль числа: " + abs(x2_1));

        int x2_2 = 0, y2_2 = 0;
        while (true) {
            System.out.print("\n[Задача 2.2] Введите целое число X (делимое): ");
            if (scanner.hasNextInt()) {
                x2_2 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("[Задача 2.2] Введите целое число Y (делитель, можно 0): ");
            if (scanner.hasNextInt()) {
                y2_2 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат безопасного деления: " + safeDiv(x2_2, y2_2));

        int x2_3 = 0;
        while (true) {
            System.out.print("\n[Задача 2.3] Введите целое число для проверки деления на 3 или 5: ");
            if (scanner.hasNextInt()) {
                x2_3 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Делится только на 3 или только на 5? -> " + is35(x2_3));

        int x2_4 = 0, y2_4 = 0;
        while (true) {
            System.out.print("\n[Задача 2.4] Введите первое число для сравнения: ");
            if (scanner.hasNextInt()) {
                x2_4 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("[Задача 2.4] Введите второе число для сравнения: ");
            if (scanner.hasNextInt()) {
                y2_4 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат сравнения: " + makeDecision(x2_4, y2_4));

        int x2_5 = 0, y2_5 = 0, z2_5 = 0;
        while (true) {
            System.out.print("\n[Задача 2.5] Введите первое число: ");
            if (scanner.hasNextInt()) { x2_5 = scanner.nextInt(); break; }
            else { System.out.println("Ошибка!"); scanner.next(); }
        }
        while (true) {
            System.out.print("[Задача 2.5] Введите второе число: ");
            if (scanner.hasNextInt()) { y2_5 = scanner.nextInt(); break; }
            else { System.out.println("Ошибка!"); scanner.next(); }
        }
        while (true) {
            System.out.print("[Задача 2.5] Введите третье число: ");
            if (scanner.hasNextInt()) { z2_5 = scanner.nextInt(); break; }
            else { System.out.println("Ошибка!"); scanner.next(); }
        }
        System.out.println("Максимальное из трех: " + max3(x2_5, y2_5, z2_5));

        System.out.println("\n==========================================");
        System.out.println("=== ПЕРЕХОД К ЗАДАНИЮ 3. ЦИКЛЫ ===");
        System.out.println("==========================================");

        int x3_1 = 0;
        while (true) {
            System.out.print("\n[Задача 3.1] Введите целое положительное число X: ");
            if (scanner.hasNextInt()) {
                x3_1 = scanner.nextInt();
                if (x3_1 >= 0) {
                    break;
                } else {
                    System.out.println("Ошибка! Число должно быть неотрицательным.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат: \"" + listNums(x3_1) + "\"");

        int x3_2 = 0;
        while (true) {
            System.out.print("\n[Задача 3.2] Введите целое положительное число X: ");
            if (scanner.hasNextInt()) {
                x3_2 = scanner.nextInt();
                if (x3_2 >= 0) {
                    break;
                } else {
                    System.out.println("Ошибка! Число должно быть неотрицательным.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат: \"" + reverseListNums(x3_2) + "\"");

        int x3_3 = 0;
        while (true) {
            System.out.print("\n[Задача 3.3] Введите целое положительное число X: ");
            if (scanner.hasNextInt()) {
                x3_3 = scanner.nextInt();
                if (x3_3 >= 0) {
                    break;
                } else {
                    System.out.println("Ошибка! Число должно быть неотрицательным.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат: \"" + chet(x3_3) + "\"");

        int x3_4 = 0, y3_4 = 0;
        while (true) {
            System.out.print("\n[Задача 3.4] Введите основание степени X: ");
            if (scanner.hasNextInt()) {
                x3_4 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("[Задача 3.4] Введите показатель степени Y (>= 0): ");
            if (scanner.hasNextInt()) {
                y3_4 = scanner.nextInt();
                if (y3_4 >= 0) {
                    break;
                } else {
                    System.out.println("Ошибка! Степень должна быть неотрицательной.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат: " + pow(x3_4, y3_4));

        long x3_5 = 0;
        while (true) {
            System.out.print("\n[Задача 3.5] Введите целое число для подсчета знаков: ");
            if (scanner.hasNextLong()) {
                x3_5 = scanner.nextLong();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Результат: " + numLen(x3_5));
        System.out.println("\n==========================================");
        System.out.println("=== ПЕРЕХОД К ЗАДАНИЮ 4. МАССИВЫ ===");
        System.out.println("==========================================");

        int[] demoArr = {1, 2, 3, 4, 2, 2, 5};
        int[] demoArr2 = {1, -2, -7, 4, 2, 2, 5};
        int[] demoArr3 = {1, 2, 3, 4, 5};

        System.out.print("Исходный массив для задач 4.1-4.2: ");
        printArray(demoArr);

        int x4_1 = 0;
        while (true) {
            System.out.print("\n[Задача 4.1] Введите число X для поиска первого вхождения: ");
            if (scanner.hasNextInt()) {
                x4_1 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Индекс первого вхождения: " + findFirst(demoArr, x4_1));

        int x4_2 = 0;
        while (true) {
            System.out.print("\n[Задача 4.2] Введите число X для поиска последнего вхождения: ");
            if (scanner.hasNextInt()) {
                x4_2 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        System.out.println("Индекс последнего вхождения: " + findLast(demoArr, x4_2));

        System.out.print("\n[Задача 4.3] Массив для поиска макс. по модулю: ");
        printArray(demoArr2);
        System.out.println("Наибольшее по модулю значение: " + maxAbs(demoArr2));

        System.out.print("\n[Задача 4.4] Исходный массив: ");
        printArray(demoArr3);
        int x4_4 = 0, pos4_4 = 0;
        while (true) {
            System.out.print("Введите число X для вставки: ");
            if (scanner.hasNextInt()) {
                x4_4 = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("Введите позицию POS (от 0 до " + demoArr3.length + "): ");
            if (scanner.hasNextInt()) {
                pos4_4 = scanner.nextInt();
                if (pos4_4 >= 0 && pos4_4 <= demoArr3.length) {
                    break;
                } else {
                    System.out.println("Ошибка! Позиция вне рамок массива.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        int[] res4_4 = add(demoArr3, x4_4, pos4_4);
        System.out.print("Результат вставки элемента: ");
        printArray(res4_4);

        System.out.print("\n[Задача 4.5] Исходный массив: ");
        printArray(demoArr3);
        int[] insArray = {7, 8, 9};
        System.out.print("Массив для вставки: ");
        printArray(insArray);
        
        int pos4_5 = 0;
        while (true) {
            System.out.print("Введите позицию POS для вставки массива (от 0 до " + demoArr3.length + "): ");
            if (scanner.hasNextInt()) {
                pos4_5 = scanner.nextInt();
                if (pos4_5 >= 0 && pos4_5 <= demoArr3.length) {
                    break;
                } else {
                    System.out.println("Ошибка! Позиция вне рамок массива.");
                }
            } else {
                System.out.println("Ошибка! Введите целое число.");
                scanner.next();
            }
        }
        int[] res4_5 = add(demoArr3, insArray, pos4_5);
        System.out.print("Результат вставки массива: ");
        printArray(res4_5);

        scanner.close();
    }
    // МЕТОДЫ ДЛЯ ЗАДАНИЯ 1
    public static double fraction(double x) {
        return x - (int)x;
    }

    public static int sumLastNums(int x) {
        int absX = Math.abs(x); 
        return (absX % 10) + ((absX / 10) % 10);
    }

    public static int charToNum(char x) {
        return x - '0';
    }

    public static boolean isPositive(int x) {
        return x > 0;
    }

    public static boolean is2Digits(int x) {
        int absX = Math.abs(x);
        return absX >= 10 && absX <= 99;
    }
    // МЕТОДЫ ДЛЯ ЗАДАНИЯ 2
    public static int abs(int x) {
        if (x < 0) {
            return -x; 
        }
        return x;
    }

    public static double safeDiv(int x, int y) {
        if (y == 0) {
            return 0;
        }
        return (double) x / y; 
    }

    public static boolean is35(int x) {
        boolean div3 = (x % 3 == 0);
        boolean div5 = (x % 5 == 0);
        return div3 ^ div5; 
    }

    public static String makeDecision(int x, int y) {
        if (x > y) {
            return x + " > " + y;
        } else if (x < y) {
            return x + " < " + y;
        } else {
            return x + " == " + y;
        }
    }

    public static int max3(int x, int y, int z) {
        int max = x; 
        if (y > max) {
            max = y; 
        }
        if (z > max) {
            max = z; 
        }
        return max;
    }
    // МЕТОДЫ ДЛЯ ЗАДАНИЯ 3
    public static String listNums(int x) {
        String res = "";
        for (int i = 0; i <= x; i++) {
            res += i + " ";
        }
        return res.trim();
    }

    public static String reverseListNums(int x) {
        String res = "";
        for (int i = x; i >= 0; i--) {
            res += i + " ";
        }
        return res.trim();
    }

    public static String chet(int x) {
        String res = "";
        for (int i = 0; i <= x; i += 2) {
            res += i + " ";
        }
        return res.trim();
    }

    public static int pow(int x, int y) {
        int result = 1;
        for (int i = 0; i < y; i++) {
            result *= x;
        }
        return result;
    }

    public static int numLen(long x) {
        long absX = Math.abs(x);
        if (absX == 0) {
            return 1;
        }
        int count = 0;
        while (absX > 0) {
            count++;
            absX /= 10;
        }
        return count;
    }
    // МЕТОДЫ ДЛЯ ЗАДАНИЯ 4
    
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i; 
            }
        }
        return -1; 
    }

    public static int findLast(int[] arr, int x) {
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == x) {
                return i; 
            }
        }
        return -1;
    }

    
    public static int maxAbs(int[] arr) {
        int maxElement = arr[0]; 
        for (int i = 1; i < arr.length; i++) {
            
            if (Math.abs(arr[i]) > Math.abs(maxElement)) {
                maxElement = arr[i]; 
            }
        }
        return maxElement;
    }

    public static int[] add(int[] arr, int x, int pos) {
        int[] result = new int[arr.length + 1]; 
        
        for (int i = 0; i < result.length; i++) {
            if (i < pos) {
                result[i] = arr[i]; 
            } else if (i == pos) {
                result[i] = x;      
            } else {
                result[i] = arr[i - 1]; 
            }
        }
        return result;
    }

    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length]; 
        
        for (int i = 0; i < result.length; i++) {
            if (i < pos) {
                result[i] = arr[i]; 
            } else if (i >= pos && i < pos + ins.length) {
                result[i] = ins[i - pos]; 
            } else {
                result[i] = arr[i - ins.length]; 
            }
        }
        return result;
    }

    private static void printArray(int[] arr) {
        String res = "[";
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] + (i < arr.length - 1 ? "," : "");
        }
        res += "]";
        System.out.println(res);
    }

}