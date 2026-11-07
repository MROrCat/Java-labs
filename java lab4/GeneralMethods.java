
import java.util.ArrayList;
import java.util.List;

public class GeneralMethods {

    //3.1 ФУНКЦИЯ
    public interface Transformer<T, P> {
        P apply(T value);
    }

    public static <T, P> List<P> transform(List<T> source, Transformer<T, P> transformer) {
        List<P> result = new ArrayList<>();
        for (T item : source) {
            result.add(transformer.apply(item));
        }
        return result;
    }

    //3.2 ФИЛЬТР
    public interface Condition<T> {
        boolean test(T value);
    }

    public static <T> List<T> filter(List<T> source, Condition<T> condition) {
        List<T> result = new ArrayList<>();
        for (T item : source) {
            if (condition.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    //3.3 СОКРАЩЕНИЕ
    public interface Combiner<T> {
        T combine(T left, T right);
    }

    public static <T> T reduce(List<T> source, Combiner<T> combiner, T defaultValue) {
        if (source == null || source.isEmpty()) {
            return defaultValue;
        }
        T result = source.get(0);
        for (int i = 1; i < source.size(); i++) {
            result = combiner.combine(result, source.get(i));
        }
        return result;
    }
}
