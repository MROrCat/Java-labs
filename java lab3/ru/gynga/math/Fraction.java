package ru.gynga.math;

// Добавляем интерфейс Cloneable в самый верх класса (Задание 8.3)
public final class Fraction extends Number implements Comparable<Fraction>, Cloneable {
    private final int numerator;   
    private final int denominator; 

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    // --- Реализация методов класса Number (Задание 4.2) ---
    @Override
    public int intValue() { return numerator / denominator; }

    @Override
    public long longValue() { return (long) numerator / denominator; }

    @Override
    public float floatValue() { return (float) numerator / denominator; }

    @Override
    public double doubleValue() { return (double) numerator / denominator; }

    // --- Реализация интерфейса Comparable (Задание 6.1) ---
    @Override
    public int compareTo(Fraction other) {
        long left = (long) this.numerator * other.denominator;
        long right = (long) other.numerator * this.denominator;
        return Long.compare(left, right);
    }

    // --- Реализация интерфейса Cloneable (Задание 8.3) ---
    @Override
    public Fraction clone() {
        // Объект неизменяемый (Immutable), поэтому оптимизируем и возвращаем сам этот же объект
        return this;
    }

    // --- Математические методы и метод toString() ---
    public int getNumerator() { return numerator; }
    public int getDenominator() { return denominator; }

    public Fraction sum(Fraction other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }
    public Fraction sum(int value) { return this.sum(new Fraction(value, 1)); }

    public Fraction minus(Fraction other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }
    public Fraction minus(int value) { return this.minus(new Fraction(value, 1)); }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }
    public Fraction multiply(int value) { return this.multiply(new Fraction(value, 1)); }

    public Fraction div(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }
    public Fraction div(int value) { return this.div(new Fraction(value, 1)); }

    // Метод возведения в степень (Задание 7.3)
    public Fraction pow(int extent) {
        if (extent == 0) return new Fraction(1, 1);
        int num = (int) Math.pow(this.numerator, Math.abs(extent));
        int den = (int) Math.pow(this.denominator, Math.abs(extent));
        if (extent < 0) return new Fraction(den, num);
        return new Fraction(num, den);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}
