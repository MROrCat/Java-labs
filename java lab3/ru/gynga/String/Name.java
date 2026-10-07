package ru.gynga.String;

public class Name {
    // 1. Поля теперь private final — гарантируют неизменяемость объекта [index: 0.1.2]
    private final String firstName;   
    private final String lastName;   
    private final String patronymic;  

    public Name(String firstName) {
        this(firstName, null, null);
    }

    public Name(String firstName, String lastName) {
        this(firstName, lastName, null);
    }

    // 2. Главный конструктор, где мы проверяем входные данные
    public Name(String firstName, String lastName, String patronymic) {
        // Проверяем, что хотя бы одно поле содержит осмысленный текст (не null и не пустое) [index: 0.1.2]
        if (!isValid(firstName) && !isValid(lastName) && !isValid(patronymic)) {
            throw new IllegalArgumentException("Ошибка! Как минимум один параметр должен быть заполнен (не null и не пустой).");
        }

        this.firstName = firstName;
        this.lastName = lastName;
        this.patronymic = patronymic;
    }

    // Вспомогательный метод для проверки строки
    private boolean isValid(String str) {
        return str != null && !str.trim().isEmpty();
    }

    // Геттеры (поскольку поля final, менять их нельзя, но читать нужно)
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getPatronymic() { return patronymic; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (lastName != null && !lastName.isEmpty()) {
            sb.append(lastName).append(" ");
        }
        if (firstName != null && !firstName.isEmpty()) {
            sb.append(firstName).append(" ");
        }
        if (patronymic != null && !patronymic.isEmpty()) {
            sb.append(patronymic);
        }
        return sb.toString().trim(); 
    }
}
