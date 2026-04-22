public abstract class Animal {

    // Статические счётчики
    protected static int animalCount = 0;
    protected static int dogCount = 0;
    protected static int catCount = 0;

    // Поля
    protected String name;
    protected String type;  // "Собака" или "Кот"

    // Конструктор
    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        animalCount++;

        if (type.equals("Собака")) {
            dogCount++;
        } else if (type.equals("Кот")) {
            catCount++;
        }
    }

    // Абстрактные методы
    public abstract void run(double distance);
    public abstract void swim(double distance);

    // Геттеры
    public String getName() { return name; }
    public String getType() { return type; }

    // Статические методы для получения счётчиков
    public static int getAnimalCount() { return animalCount; }
    public static int getDogCount() { return dogCount; }
    public static int getCatCount() { return catCount; }
}