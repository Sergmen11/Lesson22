public class Main {
    public static void main(String[] args) {
        // Заполнение параметрами классов Триугольник, Круг, Прямоугольник
        Shape circle = new Circle(7.0, "Желтый", "Красный");
        Shape rectangle = new Rectangle(4.0, 7.0, "Зеленый", "Серый");
        Shape triangle = new Triangle(3.0, 4.0, 5.0, "Синий", "Белый");

        // Вывод методов информации класса Треугольник, Прямоуголник, Круг
        circle.printInfo();
        rectangle.printInfo();
        triangle.printInfo();

        System.out.println("ТЕСТ 1: Бег и плавание");
        System.out.println("==================================\n");

        // Создаём животных
        Dog dogBobik = new Dog("Бобик");
        Dog dogRex = new Dog("Рекс");
        Cat catBarsik = new Cat("Барсик");
        Cat catMurka = new Cat("Мурка");

        // Тестируем бег
        dogBobik.run(150);
        dogRex.run(600);
        catBarsik.run(150);
        catMurka.run(250);

        System.out.println();

        // Тестируем плавание
        dogBobik.swim(5);
        dogRex.swim(15);
        catBarsik.swim(5);
        catMurka.swim(1);

        // Статистика
        System.out.println("\n Статистика созданных животных:");
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Animal.getDogCount());
        System.out.println("Котов: " + Animal.getCatCount());

        // ============================================
        System.out.println("\n\n ТЕСТ 2: Коты и миска с едой");
        System.out.println("==================================\n");

        // Создаём миску (вместимость 50, начальная еда 30)
        Bowl bowl = new Bowl(50, 30);
        System.out.println(bowl + "\n");

        // Создаём массив котов
        Cat[] cats = {
                new Cat("Барсик"),
                new Cat("Мурка"),
                new Cat("Рыжик"),
                new Cat("Пушок"),
                new Cat("Снежок")
        };

        // Просим всех котов покушать (каждому нужно 10 ед.)
        System.out.println("🍴 Коты пытаются покушать (нужно 10 ед. каждому):\n");
        for (Cat cat : cats) {
            cat.eatFromBowl(bowl, 10);
        }

        // Выводим состояние миски
        System.out.println("\n" + bowl);

        // Выводим статус сытости котов
        System.out.println("\nСтатус сытости котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " +
                    (cat.isSatiated() ? "Сыт" : "Голоден"));
        }

        // Добавляем ещё еды и пробуем снова
        System.out.println("\n Добавляем 25 ед. еды в миску:");
        bowl.addFood(25);

        System.out.println("\n Коты снова пытаются покушать:\n");
        for (Cat cat : cats) {
            if (!cat.isSatiated()) {  // только голодные коты
                cat.eatFromBowl(bowl, 10);
            }
        }

        // Финальный статус
        System.out.println("\n Финальный статус сытости:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + ": " +
                    (cat.isSatiated() ? "Сыт" : "Голоден"));

            // Итоговая статистика
            System.out.println("Всего животных: " + Animal.getAnimalCount());
            System.out.println("Собак: " + Animal.getDogCount());
            System.out.println("Котов: " + Animal.getCatCount());
        }
    }
}