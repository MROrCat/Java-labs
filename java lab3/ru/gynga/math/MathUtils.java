package ru.gynga.math;

public class MathUtils {
    // Статический метод сложения любых типов чисел (Задание 5.1)
    // Благодаря полиморфизму он принимает и стандартные числа, и нашу Fraction
    public static double sumAllNumbers(Number... numbers) {
        double total = 0.0;
        for (Number num : numbers) {
            total += num.doubleValue(); // Вызывает doubleValue() у каждого переданного числа
        }
        return total;
    }
}
