
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("ЗАДАНИЕ 1.1 и 2.2: КОРОБКА И МАКСИМУМ");
        Box<Integer> intBox = new Box<>();
        intBox.put(3);
        System.out.println("Создана коробка: " + intBox);
        
        BoxUtils.printAndExtract(intBox);
        System.out.println("Состояние коробки после извлечения: " + intBox);

        List<Box<? extends Number>> boxes = new ArrayList<>();
        boxes.add(new Box<>(10));
        boxes.add(new Box<>(25.5));
        boxes.add(new Box<>(3));
        System.out.println("Набор коробок: " + boxes);
        System.out.println("Максимум среди коробок: " + BoxUtils.findMax(boxes));


        System.out.println("\nЗАДАНИЕ 1.3: СРАВНИМОЕ");
        StringLengthComparable comp = new StringLengthComparable("Java");
        System.out.println("Сравнение 'Java' со строкой 'C++': " + comp.compare("C++"));
        System.out.println("Сравнение 'Java' со строкой 'Python': " + comp.compare("Python"));


        System.out.println("\nЗАДАНИЕ 3.1: ФУНКЦИЯ");
        List<String> strings1 = Arrays.asList("qwerty", "asdfg", "zx");
        System.out.println("Исходные строки: " + strings1);
        System.out.println("Длины: " + GeneralMethods.transform(strings1, new StringLengthTransformer()));

        List<Integer> numbers1 = Arrays.asList(1, -3, 7);
        System.out.println("Исходные числа: " + numbers1);
        System.out.println("Модули: " + GeneralMethods.transform(numbers1, new AbsoluteValueTransformer()));

        List<int[]> arrays = Arrays.asList(new int[]{1, 2, 3}, new int[]{-5, 10, 2}, new int[]{0});
        System.out.println("Максимумы массивов: " + GeneralMethods.transform(arrays, new MaxIntArrayTransformer()));


        System.out.println("\nЗАДАНИЕ 3.2: ФИЛЬТР");
        System.out.println("Фильтр строк (длина >= 3): " + GeneralMethods.filter(strings1, new MinLengthCondition()));
        System.out.println("Фильтр чисел (только < 0): " + GeneralMethods.filter(numbers1, new NegativeNumberCondition()));

        List<int[]> mixedArrays = Arrays.asList(new int[]{-1, -2}, new int[]{1, -3}, new int[]{-5, 0});
        List<int[]> filteredArrays = GeneralMethods.filter(mixedArrays, new NoPositiveElementsCondition());
        System.out.print("Массивы без положительных: ");
        for (int[] arr : filteredArrays) System.out.print(Arrays.toString(arr) + " ");
        System.out.println();


        System.out.println("\nЗАДАНИЕ 3.3: СОКРАЩЕНИЕ");
        System.out.println("Склеивание: " + GeneralMethods.reduce(strings1, new StringConcatCombiner(), ""));
        System.out.println("Сумма: " + GeneralMethods.reduce(numbers1, new IntegerSumCombiner(), 0));

        List<List<Integer>> listOfLists = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(3, 4, 5), Arrays.asList(6));
        List<Integer> sizes = GeneralMethods.transform(listOfLists, new ListSizeTransformer());
        System.out.println("Общее число элементов: " + GeneralMethods.reduce(sizes, new IntegerSumCombiner(), 0));
        System.out.println("Тест пустого списка: " + GeneralMethods.reduce(new ArrayList<Integer>(), new IntegerSumCombiner(), 0));

    }
}
