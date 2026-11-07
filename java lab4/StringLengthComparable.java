
public class StringLengthComparable implements ComparableCustom<String> {
    private final String base;

    public StringLengthComparable(String base) {
        this.base = base;
    }

    @Override
    public int compare(String other) {
        return Integer.compare(this.base.length(), other.length());
    }

    @Override
    public String toString() {
        return "StringLengthComparable{" + base + "}";
    }
}
