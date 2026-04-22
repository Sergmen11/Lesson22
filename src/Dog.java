public class Dog extends Animal {

    // Ограничения для собаки
    private static final double MAX_RUN_DISTANCE = 500;  // метров
    private static final double MAX_SWIM_DISTANCE = 10;   // метров

    // Конструктор
    public Dog(String name) {
        super(name, "Собака");
    }

    // Метод бега
    @Override
    public void run(double distance) {
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println(name + " не смог пробежать " + distance +
                    " м. (максимум: " + MAX_RUN_DISTANCE + " м.)");
        }
    }

    // Метод плавания
    @Override
    public void swim(double distance) {
        if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println(name + " не смог проплыть " + distance +
                    " м. (максимум: " + MAX_SWIM_DISTANCE + " м.)");
        }
    }
}