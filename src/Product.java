// Объявление класса
public class Product {
    String name;
    String productionDate;
    String manufacturer;
    String countryOfOrigin;
    double price;
    boolean bookingStatus;

    // Конструктор
    public Product(String name, String productionDate, String manufacturer,
                   String countryOfOrigin, double price, boolean bookingStatus) {
        this.name = name;
        this.productionDate = productionDate;
        this.manufacturer = manufacturer;
        this.countryOfOrigin = countryOfOrigin;
        this.price = price;
        this.bookingStatus = bookingStatus;
    }

    // Метод для вывода инофрмации о товаре
    void printInfo() {
        System.out.println("==========Информация о товаре==========");
        System.out.println("Название товара: " + name);
        System.out.println("Дата производства: " + productionDate);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Страна производитель: " + countryOfOrigin);
        System.out.println("Цена: " + price + " руб.");
        System.out.println("Статус бронирования: " + (bookingStatus ? "Да" : "Нет"));
    }
}
