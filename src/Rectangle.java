// Класс прямоуголник
class Rectangle implements Shape {
    private final double width;
    private final double height;
    private final String fillColor;
    private final String borderColor;

    // Конуструктор
    public Rectangle(double width, double height, String fillColor, String borderColor) {
        if (width <= 0 || height <= 0) throw new IllegalArgumentException("Стороны должны быть больше 0");
        this.width = width;
        this.height = height;
        this.fillColor = fillColor;
        this.borderColor = borderColor;
    }

    // Метод рассчета площади
    @Override
    public double getArea() {
        return width * height;
    }

    // Метод рассчета периметра
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Заливка границ и фона
    @Override public String getFillColor() {return fillColor; }
    @Override public String getBorderColor() {return borderColor; }
}