public class Fraction {
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

    public Fraction sum(Fraction other) {
        int num = this.numerator * other.denominator + other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction sum(int value) {
        return this.sum(new Fraction(value, 1));
    }

    public Fraction minus(Fraction other) {
        int num = this.numerator * other.denominator - other.numerator * this.denominator;
        int den = this.denominator * other.denominator;
        return new Fraction(num, den);
    }

    public Fraction minus(int value) {
        return this.minus(new Fraction(value, 1));
    }

    public Fraction multiply(Fraction other) {
        return new Fraction(this.numerator * other.numerator, this.denominator * other.denominator);
    }

    public Fraction multiply(int value) {
        return this.multiply(new Fraction(value, 1));
    }

    public Fraction div(Fraction other) {
        return new Fraction(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    public Fraction div(int value) {
        return this.div(new Fraction(value, 1));
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
}