
import java.util.List;

//Классы-трансформеры для 3.1
class StringLengthTransformer implements GeneralMethods.Transformer<String, Integer> {
    @Override public Integer apply(String value) { return value.length(); }
}

class AbsoluteValueTransformer implements GeneralMethods.Transformer<Integer, Integer> {
    @Override public Integer apply(Integer value) { return Math.abs(value); }
}

class MaxIntArrayTransformer implements GeneralMethods.Transformer<int[], Integer> {
    @Override public Integer apply(int[] array) {
        if (array == null || array.length == 0) return 0;
        int max = array[0];
        for (int val : array) if (val > max) max = val;
        return max;
    }
}

class ListSizeTransformer implements GeneralMethods.Transformer<List<Integer>, Integer> {
    @Override public Integer apply(List<Integer> list) { return list.size(); }
}

//Классы-условия для 3.2
class MinLengthCondition implements GeneralMethods.Condition<String> {
    @Override public boolean test(String value) { return value.length() >= 3; }
}

class NegativeNumberCondition implements GeneralMethods.Condition<Integer> {
    @Override public boolean test(Integer value) { return value < 0; }
}

class NoPositiveElementsCondition implements GeneralMethods.Condition<int[]> {
    @Override public boolean test(int[] array) {
        for (int val : array) if (val > 0) return false;
        return true;
    }
}
