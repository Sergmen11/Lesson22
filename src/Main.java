
public class Main {
    public static void main(String[] args) {
// 1 Проверяем вывод класса Product. Создаем массив с 5 товарами
        Product[] productsArray = new Product[5];
// 2 Наполнем массив информацией о товаре
        productsArray[0] = new Product("Samsung S25 Ultra", "01.02.2025",
                "Samsung Corp.", "Korea", 55000.0, true);
        productsArray[1] = new Product("Samsung Galaxy A50", "15.01.2022",
                "Samsung Corp.", "Korea", 46500.0, false);
        productsArray[2] = new Product("iPhone 15 Pro", "22.10.2023",
                "Apple Corp.", "USA", 66000.0, true);
        productsArray[3] = new Product("iPhone 14", "17.04.2021",
                "Apple Corp.", "USA", 59000.0, false);
        productsArray[4] = new Product("Xiaomi 12 Note Pro", "12.05.2019",
                "Xiaomi Corp.", "China", 40500.0, true);
// 3 выводим информацию о товаре
        System.out.println("Каталог товаров:\n");
        for (int i = 0; i < productsArray.length; i++) {
            productsArray[i].printInfo();
            System.out.println();
        }

// 1 Проверяем вывод класса Park. Создаем экземпляр внешнего вида
        Park park = new Park("Москва", "Парк Горького");

// 2 Наполнем экземпляр внутреннего класса информацией об аттракционах
        Park.Attraction ferrisWheel = park.new Attraction(
                    "Колесо обозрения", "10.00", "23.00", 400.0);
        Park.Attraction rollerCoaster = park.new Attraction(
                    "Американские горки", "10.00", "22.00", 500.0);

        ferrisWheel.printInfo();
        System.out.println();

        rollerCoaster.printInfo();
        System.out.println();
    }
}