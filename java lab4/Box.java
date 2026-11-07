
public class Box<T> {
    private T item;

    public Box() {
        this.item = null;
    }

    public Box(T item) {
        this.item = item;
    }

    public void put(T newItem) {
        if (!isEmpty()) {
            throw new IllegalStateException("Коробка уже заполнена!");
        }
        this.item = newItem;
    }

    public T take() {
        T temp = this.item;
        this.item = null; // Обнуляем ссылку при извлечении по условию
        return temp;
    }

    public T peek() {
        return this.item;
    }

    public boolean isEmpty() {
        return this.item == null;
    }

    @Override
    public String toString() {
        return "Box{" + (item == null ? "empty" : item.toString()) + "}";
    }
}
