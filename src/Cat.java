public class Cat extends Animal {

    // Ограничения для кота
    private static final double MAX_RUN_DISTANCE = 200;  // метров
    // Коты не плавают!

    // Поле сытости
    private boolean isSatiated = false;  // по умолчанию кот голоден

    // Конструктор
    public Cat(String name) {
        super(name, "Кот");
        // isSatiated = false по умолчанию
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

    // Метод плавания (коты не умеют плавать)
    @Override
    public void swim(double distance) {
        System.out.println(name + " не умеет плавать! ");
    }

    // Метод еды из миски
    public void eatFromBowl(Bowl bowl, int foodAmount) {
        if (bowl.tryGetFood(foodAmount)) {
            isSatiated = true;
            System.out.println(name + " поел " + foodAmount + " ед. и насытился!");
        } else {
            System.out.println(name + " не стал есть (мало еды: " +
                    bowl.getFoodAmount() + " ед., нужно: " + foodAmount + ")");
        }
    }

    // Геттер сытости
    public boolean isSatiated() {
        return isSatiated;
    }

    // Сброс сытости
    public void resetSatiety() {
        isSatiated = false;
    }
}