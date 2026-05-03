import java.util.*;

public class PhoneBook {

    // Хранилище: Фамилия → Список телефонов
    private Map<String, List<String>> phoneBook;

    // Конструктор
    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    // Метод добавления записи
    public void add(String surname, String phone) {
        if (surname == null || surname.trim().isEmpty()) {
            System.out.println("Фамилия не может быть пустой!");
            return;
        }

        if (phone == null || phone.trim().isEmpty()) {
            System.out.println("Телефон не может быть пустым!");
            return;
        }

        // Нормализуем фамилию (первая буква заглавная)
        surname = surname.trim().substring(0, 1).toUpperCase() +
                surname.trim().substring(1).toLowerCase();

        // Если фамилии ещё нет в справочнике, создаём новый список
        phoneBook.putIfAbsent(surname, new ArrayList<>());

        // Добавляем телефон, если его ещё нет
        List<String> phones = phoneBook.get(surname);
        if (!phones.contains(phone)) {
            phones.add(phone);
            System.out.println("Добавлен: " + surname + " → " + phone);
        } else {
            System.out.println("Телефон уже существует для " + surname);
        }
    }

    // Метод поиска по фамилии
    public List<String> get(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            System.out.println("⚠️ Фамилия не может быть пустой!");
            return new ArrayList<>();
        }

        // Нормализуем фамилию
        surname = surname.trim().substring(0, 1).toUpperCase() +
                surname.trim().substring(1).toLowerCase();

        List<String> phones = phoneBook.get(surname);

        if (phones == null || phones.isEmpty()) {
            System.out.println("Для фамилии \"" + surname + "\" записей не найдено");
            return new ArrayList<>();
        }

        return new ArrayList<>(phones);  // Возвращаем копию списка
    }

    // Метод удаления записи по фамилии и телефону
    public boolean remove(String surname, String phone) {
        surname = surname.trim().substring(0, 1).toUpperCase() +
                surname.trim().substring(1).toLowerCase();

        List<String> phones = phoneBook.get(surname);

        if (phones != null && phones.contains(phone)) {
            phones.remove(phone);
            System.out.println("Удалён: " + surname + " → " + phone);

            // Если телефонов не осталось, удаляем фамилию
            if (phones.isEmpty()) {
                phoneBook.remove(surname);
            }
            return true;
        }

        System.out.println("Запись не найдена");
        return false;
    }

    // Метод удаления всех записей по фамилии
    public boolean removeBySurname(String surname) {
        surname = surname.trim().substring(0, 1).toUpperCase() +
                surname.trim().substring(1).toLowerCase();

        if (phoneBook.containsKey(surname)) {
            int count = phoneBook.get(surname).size();
            phoneBook.remove(surname);
            System.out.println("Удалено записей для " + surname + ": " + count);
            return true;
        }

        System.out.println("Фамилия не найдена");
        return false;
    }

    // Метод получения всех фамилий
    public Set<String> getAllSurnames() {
        return new TreeSet<>(phoneBook.keySet());  // Сортированный список
    }

    // Метод получения общего количества записей
    public int getTotalRecords() {
        int count = 0;
        for (List<String> phones : phoneBook.values()) {
            count += phones.size();
        }
        return count;
    }

    // Печать всего справочника
    public void printAll() {
        System.out.println("\n Телефонный справочник:");
        System.out.println("================================");

        if (phoneBook.isEmpty()) {
            System.out.println("   Справочник пуст");
        } else {
            for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
                System.out.println("   " + entry.getKey() + ":");
                for (String phone : entry.getValue()) {
                    System.out.println("       " + phone);
                }
            }
        }

        System.out.println("--------------------------------");
        System.out.println("Всего записей: " + getTotalRecords());
    }

    // ===== Поиск по номеру телефона (обратный поиск) =====
    public List<String> findByPhone(String phone) {
        List<String> foundSurnames = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            if (entry.getValue().contains(phone)) {
                foundSurnames.add(entry.getKey());
            }
        }

        return foundSurnames;
    }
}
