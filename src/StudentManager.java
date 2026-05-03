import java.util.*;

public class StudentManager {

    // Метод удаления студентов со средним баллом < 3
    public static void removeLowGradeStudents(Set<Student> students) {
        System.out.println("\n Удаление студентов со средним баллом < 3...");

        Iterator<Student> iterator = students.iterator();
        int removedCount = 0;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                System.out.println("   Удалён: " + student.getName() +
                        " (средний балл: " +
                        String.format("%.2f", student.getAverageGrade()) + ")");
                iterator.remove();
                removedCount++;
            }
        }

        System.out.println("Удалено студентов: " + removedCount);
    }

    // Метод перевода студента на следующий курс (если средний балл >= 3)
    public static void advanceCourse(Set<Student> students) {
        System.out.println("\n Перевод студентов на следующий курс...");

        int advancedCount = 0;

        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                int oldCourse = student.getCourse();
                student.setCourse(oldCourse + 1);
                System.out.println("   " + student.getName() + ": " +
                        oldCourse + " → " + student.getCourse() + " курс");
                advancedCount++;
            } else {
                System.out.println("   " + student.getName() +
                        " остаётся на курсе (средний балл: " +
                        String.format("%.2f", student.getAverageGrade()) + ")");
            }
        }

        System.out.println("Переведено студентов: " + advancedCount);
    }

    // Метод печати студентов определённого курса
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\n Студенты " + course + " курса:");
        System.out.println("================================");

        int count = 0;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("   " + student.getName() +
                        " (группа: " + student.getGroup() +
                        ", средний балл: " +
                        String.format("%.2f", student.getAverageGrade()) + ")");
                count++;
            }
        }

        if (count == 0) {
            System.out.println("   Нет студентов на " + course + " курсе");
        } else {
            System.out.println("--------------------------------");
            System.out.println("Всего: " + count + " студент(а/ов)");
        }
    }

    // Метод печати всех студентов
    public static void printAllStudents(Set<Student> students) {
        System.out.println("\n Все студенты:");
        System.out.println("================================");

        for (Student student : students) {
            System.out.println("   " + student);
        }

        System.out.println("--------------------------------");
        System.out.println("Всего: " + students.size() + " студент(а/ов)");
    }
}