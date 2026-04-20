public class Park {
    // поля внешнего класса
    String location;
    String namePark;
    // конструктор внешнего класса
    public Park(String location, String namePark) {
        this.location = location;
        this.namePark = namePark;
    }
    // объявление внутреннего класса
    class Attraction {
        String nameAttraction;
        String opening;
        String closing;
        double price;
        // конструктор внутреннего класса
        public Attraction(String nameAttraction, String opening, String closing, double price) {
            this.nameAttraction = nameAttraction;
            this.opening = opening;
            this.closing = closing;
            this.price = price;
        }
        // Метод для вывода информации об аттракционе
        void printInfo() {
            System.out.println("============== Информация об аттракционе ==============");
            System.out.println("Парк: " + namePark + ", г. " + location);
            System.out.println("Название атракциона: " + nameAttraction);
            System.out.println("Время работы: " + opening + " - " + closing);
            System.out.println("Стоимость аттракциона: " + price + " руб.");
        }
    }
}