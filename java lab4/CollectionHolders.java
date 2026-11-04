
import java.util.ArrayList;
import java.util.List;

class SignPartition {
    List<Integer> positives = new ArrayList<>();
    List<Integer> negatives = new ArrayList<>();
    @Override public String toString() { return "Positives: " + positives + ", Negatives: " + negatives; }
}

class StringLengthMap {
    java.util.Map<Integer, List<String>> map = new java.util.HashMap<>();
    @Override public String toString() { return map.toString(); }
}

class UniqueStringSet {
    java.util.Set<String> set = new java.util.HashSet<>();
    @Override public String toString() { return set.toString(); }
}
