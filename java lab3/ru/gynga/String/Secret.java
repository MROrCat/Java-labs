package ru.gynga.String;

import java.util.Random;

public class Secret {
    private final String text;         // Текст секрета (геттера для него НЕТ!)
    private final String keeperName;   // Имя хранителя
    
    // Ссылки для связи в цепочку (двусвязный список)
    private Secret previous;           
    private Secret next;               
    
    private boolean isTold = false;    // Флаг: был ли секрет уже передан кому-то
    private final int sequenceNumber;  // Порядковый номер хранителя в цепочке

    // Конструктор 1: Создание абсолютно нового секрета
    public Secret(String keeperName, String text) {
        if (keeperName == null || keeperName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя хранителя не может быть пустым");
        }
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("Текст секрета не может быть пустым");
        }
        this.keeperName = keeperName;
        this.text = text;
        this.sequenceNumber = 1; // Первый в цепочке
    }

    // Конструктор 2: Передача секрета другому хранителю
    public Secret(Secret originalSecret, String newKeeperName) {
        if (originalSecret == null) {
            throw new IllegalArgumentException("Исходный секрет не может быть null");
        }
        if (newKeeperName == null || newKeeperName.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя нового хранителя не может быть пустым");
        }
        // Жесткая проверка инкапсуляции: нельзя рассказать секрет дважды!
        if (originalSecret.isTold) {
            throw new RuntimeException("Этот секрет уже был передан другому человеку! Больше рассказывать нельзя.");
        }

        // 1. Вывод в консоль строго по требованию лабы
        System.out.println(originalSecret.keeperName + " сказал что " + originalSecret.text);

        // 2. Пометка, что оригинальный секрет теперь передан
        originalSecret.isTold = true;

        // 3. Генерация искаженного текста (+X случайных символов в X случайных мест)
        this.text = distortText(originalSecret.text);
        this.keeperName = newKeeperName;
        
        // 4. Связывание в цепочку
        this.previous = originalSecret;
        originalSecret.next = this;
        this.sequenceNumber = originalSecret.sequenceNumber + 1;
    }

    // Метод генерации шума в тексте (от 0 до 10% случайных символов)
    private String distortText(String source) {
        Random random = new Random();
        int n = (int) (source.length() * 0.1); // 10% от длины исходного текста
        int x = random.nextInt(n + 1);         // Количество символов от 0 до N

        StringBuilder sb = new StringBuilder(source);
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!?@#";

        for (int i = 0; i < x; i++) {
            // Выбираем случайное место в текущей строке
            int targetIndex = random.nextInt(sb.length() + 1);
            // Выбираем случайный символ для вставки
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            sb.insert(targetIndex, randomChar);
        }
        return sb.toString();
    }

    // Действие: Приведение к строке
    @Override
    public String toString() {
        return keeperName + ": это секрет!";
    }

    // Действие: Каким по очереди был данный хранитель
    public int getSequenceNumber() {
        return this.sequenceNumber;
    }

    // Действие: Сколько еще человек узнали секрет ПОСЛЕ текущего хранителя
    public int getCountAfterMe() {
        int count = 0;
        Secret current = this.next;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Действие: Получить имя N-го человека (N > 0 — вперед по цепочке, N < 0 — назад)
    public String getKeeperNameAt(int n) {
        if (n == 0) return this.keeperName;
        
        Secret current = this;
        if (n > 0) {
            // Идем вперед
            for (int i = 0; i < n; i++) {
                if (current.next == null) return null; // Цепочка закончилась
                current = current.next;
            }
        } else {
            // Идем назад (переводим в положительный шаг)
            for (int i = 0; i < Math.abs(n); i++) {
                if (current.previous == null) return null; // Начало цепочки
                current = current.previous;
            }
        }
        return current.keeperName;
    }

    // Действие: Разница в количестве символов текста секрета с N-ым человеком
    public int getLengthDifferenceWith(int n) {
        if (n == 0) return 0;
        
        Secret current = this;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                if (current.next == null) throw new IllegalArgumentException("Нет такого человека вперед по цепочке");
                current = current.next;
            }
        } else {
            for (int i = 0; i < Math.abs(n); i++) {
                if (current.previous == null) throw new IllegalArgumentException("Нет такого человека назад по цепочке");
                current = current.previous;
            }
        }
        // Возвращаем разницу длин строк
        return this.text.length() - current.text.length();
    }
}
