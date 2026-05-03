import java.util.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("🎓 ЗАДАНИЕ 1: Управление студентами");

        // Создаём коллекцию студентов
        Set<Student> students = new HashSet<>();

        // Добавляем студентов
        Student s1 = new Student("Иванов Иван", "ИВТ-101", 1);
        s1.addGrade(5); s1.addGrade(4); s1.addGrade(5); s1.addGrade(4);

        Student s2 = new Student("Петров Пётр", "ИВТ-101", 1);
        s2.addGrade(3); s2.addGrade(3); s2.addGrade(4); s2.addGrade(3);

        Student s3 = new Student("Сидоров Сидор", "ИВТ-101", 1);
        s3.addGrade(2); s3.addGrade(2); s3.addGrade(3); s3.addGrade(2);

        Student s4 = new Student("Смирнова Анна", "ИВТ-201", 2);
        s4.addGrade(5); s4.addGrade(5); s4.addGrade(4); s4.addGrade(5);

        Student s5 = new Student("Кузнецов Олег", "ИВТ-201", 2);
        s5.addGrade(3); s5.addGrade(2); s5.addGrade(3); s5.addGrade(2);

        Student s6 = new Student("Попова Мария", "ИВТ-301", 3);
        s6.addGrade(4); s6.addGrade(4); s6.addGrade(5); s6.addGrade(4);

        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        // Печатаем всех студентов
        StudentManager.printAllStudents(students);

        // Печатаем студентов 1 курса
        StudentManager.printStudents(students, 1);

        // Удаляем студентов со средним баллом < 3
        StudentManager.removeLowGradeStudents(students);

        // Печатаем оставшихся студентов
        StudentManager.printAllStudents(students);

        // Переводим студентов на следующий курс
        StudentManager.advanceCourse(students);

        // Печатаем финальный список
        StudentManager.printAllStudents(students);

        // Печатаем студентов 2 курса (после перевода)
        StudentManager.printStudents(students, 2);

        System.out.println("ЗАДАНИЕ 2: Телефонный справочник");

        // Создаём справочник
        PhoneBook phoneBook = new PhoneBook();

        // Добавляем записи
        System.out.println("Добавление записей:");
        System.out.println("------------------------");

        phoneBook.add("Иванов", "+7-900-111-11-11");
        phoneBook.add("Иванов", "+7-900-222-22-22");  // Второй телефон Иванова
        phoneBook.add("Петров", "+7-900-333-33-33");
        phoneBook.add("Сидоров", "+7-900-444-44-44");
        phoneBook.add("Сидоров", "+7-900-555-55-55");  // Второй телефон Сидорова
        phoneBook.add("Сидоров", "+7-900-666-66-66");  // Третий телефон Сидорова
        phoneBook.add("Кузнецов", "+7-900-777-77-77");
        phoneBook.add("Попова", "+7-900-888-88-88");

        // Печатаем весь справочник
        phoneBook.printAll();

        // Поиск по фамилии
        System.out.println("\n Поиск по фамилии \"Иванов\":");
        System.out.println("--------------------------------");
        List<String> ivanovPhones = phoneBook.get("Иванов");
        for (String phone : ivanovPhones) {
            System.out.println("   " + phone);
        }

        System.out.println("\n Поиск по фамилии \"Сидоров\":");
        System.out.println("--------------------------------");
        List<String> sidorovPhones = phoneBook.get("Сидоров");
        for (String phone : sidorovPhones) {
            System.out.println("   " + phone);
        }

        // Поиск несуществующей фамилии
        System.out.println("\n Поиск по фамилии \"Смирнов\":");
        System.out.println("--------------------------------");
        List<String> smirnovPhones = phoneBook.get("Смирнов");

        // Обратный поиск по телефону
        System.out.println("\n Обратный поиск по телефону +7-900-444-44-44:");
        System.out.println("-----------------------------------------------");
        List<String> foundSurnames = phoneBook.findByPhone("+7-900-444-44-44");
        if (!foundSurnames.isEmpty()) {
            for (String surname : foundSurnames) {
                System.out.println("   " + surname);
            }
        } else {
            System.out.println("   Телефон не найден");
        }

        // Удаление одного телефона
        System.out.println("\n Удаление одного телефона:");
        System.out.println("-----------------------------");
        phoneBook.remove("Иванов", "+7-900-111-11-11");

        // Удаление всех записей по фамилии
        System.out.println("\n Удаление всех записей для \"Кузнецов\":");
        System.out.println("------------------------------------------");
        phoneBook.removeBySurname("Кузнецов");

        // Финальная печать
        phoneBook.printAll();

        // Статистика
        System.out.println("\n Статистика:");
        System.out.println("----------------");
        System.out.println("Всего фамилий: " + phoneBook.getAllSurnames().size());
        System.out.println("Всего записей: " + phoneBook.getTotalRecords());
    }
}