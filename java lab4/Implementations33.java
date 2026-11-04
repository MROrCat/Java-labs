
//Классы-объединители для 3.3
class StringConcatCombiner implements GeneralMethods.Combiner<String> {
    @Override public String combine(String left, String right) { return left + right; }
}

class IntegerSumCombiner implements GeneralMethods.Combiner<Integer> {
    @Override public Integer combine(Integer left, Integer right) { return left + right; }
}


