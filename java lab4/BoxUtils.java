
import java.util.List;

public class BoxUtils {
    public static double findMax(List<Box<? extends Number>> boxes) {
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Список коробок пуст или равен null");
        }
        
        double max = -Double.MAX_VALUE;
        for (Box<? extends Number> box : boxes) {
            if (box != null && !box.isEmpty()) {
                double val = box.peek().doubleValue();
                if (val > max) {
                    max = val;
                }
            }
        }
        return max;
    }

    // Вспомогательный метод для Задания 1.1 по условию задачи (извлечение и вывод)
    public static <T> void printAndExtract(Box<T> box) {
        T val = box.take();
        System.out.println("Извлечено из коробки: " + val);
    }
}
