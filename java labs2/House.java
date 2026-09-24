public class House {
    private final int floors;

    public House(int floors) {
        if (floors <= 0) {
            throw new IllegalArgumentException("Количество этажей должно быть больше 0");
        }
        this.floors = floors;
    }

    @Override
    public String toString() {
        String ending;
        int lastDigit = floors % 10;
        int lastTwoDigits = floors % 100;

        if (lastTwoDigits >= 11 && lastTwoDigits <= 14) {
            ending = "этажами";
        } else if (lastDigit == 1) {
            ending = "этажом";
        } else {
            ending = "этажами";
        }

        return "дом с " + floors + " " + ending;
    }
}
