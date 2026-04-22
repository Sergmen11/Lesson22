// Класс треугольник
class Triangle implements Shape {
    private final double a, b, c;
    private final String fillColor;
    private final String borderColor;
// Конструктор
    public Triangle(double a, double b, double c, String fillColor, String borderColor) {
        if (a + b <= c || a + c <= b || c + b <= a) {
            throw new IllegalArgumentException("Сумма лубых двух сторон должна быть больше третьей");
        }
        this.a = a;
        this.b = b;
        this.c = c;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Метод рассчета площади
    @Override
    public double getArea() {
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p * (p - a) * (p - b) * (p - c)));
    }

    // Метод рассчета Периметра
    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    // Заливка границ и фона
    @Override public String getFillColor() {return fillColor; }
    @Override public String getBorderColor() {return borderColor; }
}