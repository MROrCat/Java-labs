package ru.gynga.math;

// Статический импорт для коротких имён методов
import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

public class PowerService {
    
    // Метод принимает две строки, переводит в числа и возводит в степень
    public static double calculatePower(String xStr, String yStr) {
        int x = parseInt(xStr);
        int y = parseInt(yStr);
        return pow(x, y);
    }
}
