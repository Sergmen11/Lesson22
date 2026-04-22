// Класс круг
class Circle implements Shape {
    private final double radius;
    private final String fillColor;
    private final String borderColor;

    // Конструктор
    public Circle(double radius, String fillColor, String borderColor) {
        if (radius <= 0) throw new IllegalArgumentException("Радиус должен быть > 0");
        this.radius = radius;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Метод рассчета площади
    @Override
    public double getArea() {
        return 2 * Math.PI * radius * radius;
    }

    // Метод рассчета Периметра
    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    // Заливка границ и фона
    @Override public String getFillColor() {return fillColor; }
    @Override public String getBorderColor() {return borderColor; }
}