import java.util.*;

public class Student {

    // Поля класса
    private String name;           // имя
    private String group;          // группа
    private int course;            // курс
    private List<Double> grades;   // оценки по предметам

    // Конструктор
    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>();
    }

    // Метод для добавления оценки
    public void addGrade(double grade) {
        if (grade >= 2 && grade <= 5) {
            grades.add(grade);
        } else {
            System.out.println("⚠️ Оценка должна быть от 2 до 5!");
        }
    }

    // Метод для расчёта среднего балла
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }

    // Геттеры и сеттеры
    public String getName() { return name; }
    public String getGroup() { return group; }
    public int getCourse() { return course; }
    public List<Double> getGrades() { return grades; }

    public void setCourse(int course) { this.course = course; }

    // Вывод
    @Override
    public String toString() {
        return String.format("%s | Группа: %s | Курс: %d | Средний балл: %.2f",
                name, group, course, getAverageGrade());
    }

    // Equals и hashCode для работы в Set
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course &&
                Objects.equals(name, student.name) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, group, course);
    }
}