import java.util.List;

public class Lab2 {
        public static void main(String[] args) {
        
        System.out.println("ЗАДАНИЕ 1. Задача 3. Имена");

        Name cleopatra = new Name("Клеопатра");
        Name pushkin = new Name("Александр", "Пушкин", "Сергеевич");
        Name mayakovsky = new Name("Владимир", "Маяковский");

        System.out.println("Результат вывода имен:");
        System.out.println(cleopatra);
        System.out.println(pushkin);
        System.out.println(mayakovsky);


        System.out.println("\n");
        System.out.println("ЗАДАНИЕ 1. Задача 5. Дом");
    
        House house1 = new House(1);
        House house5 = new House(5);
        House house23 = new House(23);

        System.out.println("Результат вывода домов:");
        System.out.println(house1);
        System.out.println(house5);
        System.out.println(house23);

        System.out.println("\n");
        System.out.println("ЗАДАНИЕ 2. Задача 4. Сотрудники и отделы");
       
        Department itDept = new Department("IT");
        Employee petrov = new Employee("Петров", itDept);
        Employee kozlov = new Employee("Козлов", itDept);
        Employee sidorov = new Employee("Сидоров", itDept);

        itDept.manager = kozlov;

        System.out.println("Список сотрудников после назначения начальника:");
        System.out.println(petrov);
        System.out.println(kozlov);
        System.out.println(sidorov);

        System.out.println("\n");
        System.out.println("ЗАДАНИЕ 3. Задача 4. Сотрудники и отделы (Расширение)");
        
        System.out.println("Запрос списка всех сотрудников отдела через ссылку на Петрова:");
        List<Employee> colleagues = petrov.getColleagues();
        for (Employee emp : colleagues) {
            System.out.println(" - " + emp.name + " (" + (emp.department.manager == emp ? "Начальник" : "Сотрудник") + ")");
        }

        System.out.println("\n");
        System.out.println("ЗАДАНИЕ 4. Задача 5. Создаем Имена (Новые конструкторы)");

        Name n4_1 = new Name("Клеопатра");                             
        Name n4_2 = new Name("Александр", "Пушкин", "Сергеевич");       
        Name n4_3 = new Name("Владимир", "Маяковский");                 
        Name n4_4 = new Name("Христофор", "Бонифатьевич");              

        System.out.println("Результат вывода созданных имен:");
        System.out.println("1. " + n4_1);
        System.out.println("2. " + n4_2);
        System.out.println("3. " + n4_3);
        System.out.println("4. " + n4_4);

        System.out.println("\n");
        System.out.println("ЗАДАНИЕ 5. Задача 5. Дроби");
        
        Fraction fracA = new Fraction(1, 2);
        Fraction fracB = new Fraction(1, 4);

        System.out.println("Демонстрация базовых методов:");
        System.out.println(fracA + " + " + fracB + " = " + fracA.sum(fracB));
        System.out.println(fracA + " - " + fracB + " = " + fracA.minus(fracB));
        System.out.println(fracA + " * " + fracB + " = " + fracA.multiply(fracB));
        System.out.println(fracA + " / " + fracB + " = " + fracA.div(fracB));

        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(2, 3);
        System.out.println("\nПример из задания:");
        System.out.println(f1 + " * " + f2 + " = " + f1.multiply(f2));

        Fraction f3 = new Fraction(1, 2);
        Fraction finalResult = f1.sum(f2).div(f3).minus(5);
        System.out.println("\nВычисление финального выражения:");
        System.out.println("f1.sum(f2).div(f3).minus(5) = " + finalResult);
    }
}