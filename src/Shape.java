import java.util.List;

// Создаем интерфейс описывающий контракт для всех геометрических фигур
interface Shape {
    double getArea();

// Абстрактный метод площади.Каждая фигура обязана реализовать его сама.
    default double getPerimeter() {
        System.out.println();
        return 0.0;
    }

// Гетеры цветов
    String getFillColor();
    String getBorderColor();

    default void printInfo() {
        System.out.printf("[ Периметр: %.2f, Плащадь: %.2f, Цвет фона: %s, Цвет границ: %s ]%n", getPerimeter(),
                getArea(), getFillColor(), getBorderColor());
    }
}