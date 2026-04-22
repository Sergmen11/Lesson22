public class Bowl {

    // Поля
    private int foodAmount;      // текущее количество еды
    private final int capacity;  // максимальная вместимость

    // Конструктор
    public Bowl(int capacity) {
        this.capacity = capacity;
        this.foodAmount = 0;  // новая миска пустая
    }

    // Конструктор с начальным количеством еды
    public Bowl(int capacity, int initialFood) {
        this.capacity = capacity;
        this.foodAmount = Math.max(0, Math.min(initialFood, capacity));
    }

    // Попытка взять еду
    // Возвращает true, если удалось взять, false если еды мало
    public boolean tryGetFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя взять отрицательное количество еды!");
            return false;
        }

        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;  // еды недостаточно
    }

    // Добавить еду в миску
    public void addFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя добавить отрицательное количество еды!");
            return;
        }

        int oldAmount = foodAmount;
        foodAmount = Math.min(foodAmount + amount, capacity);

        if (foodAmount == capacity && oldAmount < capacity) {
            System.out.println("Миска наполнена до краёв! (" + foodAmount + "/" + capacity + ")");
        } else {
            System.out.println("Добавлено " + amount + " ед. еды. Теперь: " +
                    foodAmount + "/" + capacity);
        }
    }

    // Геттеры
    public int getFoodAmount() {return foodAmount;
    }

    public int getCapacity() {return capacity;
    }

    // toString для удобного вывода
    @Override
    public String toString() {
        return "Миска: " + foodAmount + "/" + capacity + " ед. еды";
    }
}