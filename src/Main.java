public class Main {

    // Метод для обработки массива 4x4
    public static int processArray(String[][] array)
            throws MyArraySizeException, MyArrayDataException {

        // 1. Проверка размера массива
        if (array == null) {
            throw new MyArraySizeException("Массив равен null!");
        }

        if (array.length != 4) {
            throw new MyArraySizeException(
                    "Неверное количество строк: " + array.length + " (ожидалось 4)"
            );
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == null || array[i].length != 4) {
                throw new MyArraySizeException(
                        "Неверное количество столбцов в строке " + i + ": " +
                                (array[i] == null ? 0 : array[i].length) + " (ожидалось 4)"
                );
            }
        }

        // 2. Преобразование и суммирование
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    int value = Integer.parseInt(array[i][j]);
                    sum += value;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Неверные данные в ячейке [" + i + "][" + j + "]: \"" +
                                    array[i][j] + "\" не является числом",
                            i, j, array[i][j]
                    );
                }
            }
        }

        return sum;
    }

    // Метод для демонстрации ArrayIndexOutOfBoundsException
    public static void demonstrateArrayIndexOutOfBoundsException() {
        System.out.println("\n Демонстрация ArrayIndexOutOfBoundsException:");
        System.out.println("==============================================");

        int[] numbers = {1, 2, 3, 4, 5};

        try {
            System.out.println("Попытка доступа к элементу с индексом 10...");
            System.out.println("Значение: " + numbers[10]);  // Вызовет исключение
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Допустимые индексы: 0-" + (numbers.length - 1));
        }
    }

    // Главный метод
    public static void main(String[] args) {

        System.out.println("Работа с двумерным массивом 4x4");
        System.out.println("===================================\n");

        // ===== ТЕСТ 1: Корректный массив =====
        System.out.println("ТЕСТ 1: Корректный массив 4x4");
        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = processArray(correctArray);
            System.out.println("Сумма всех элементов: " + sum);
            System.out.println("Ожидаемая сумма: 136 (1+2+...+16)");
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // ТЕСТ 2: Неправильный размер массива
        System.out.println("\n ТЕСТ 2: Неправильный размер массива (3x4)");
        String[][] wrongSizeArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        try {
            int sum = processArray(wrongSizeArray);
            System.out.println("Сумма: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Поймано MyArraySizeException:");
            System.out.println("   " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных: " + e.getMessage());
        }

        // ТЕСТ 3: Некорректные данные в массиве
        System.out.println("\n ТЕСТ 3: Некорректные данные в ячейке [1][2]");
        String[][] wrongDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "abc", "8"},  // "abc" вместо числа
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = processArray(wrongDataArray);
            System.out.println("Сумма: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера: " + e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println("Поймано MyArrayDataException:");
            System.out.println("   " + e.getMessage());
            System.out.println("   Ячейка: [" + e.getRow() + "][" + e.getColumn() + "]");
            System.out.println("   Неверное значение: \"" + e.getInvalidValue() + "\"");
        }

        // ТЕСТ 4: Массив с отрицательными числами (должен работать)
        System.out.println("\n ТЕСТ 4: Массив с отрицательными числами");
        String[][] negativeArray = {
                {"-1", "-2", "-3", "-4"},
                {"5", "6", "7", "8"},
                {"9", "10", "-11", "12"},
                {"13", "-14", "15", "16"}
        };

        try {
            int sum = processArray(negativeArray);
            System.out.println("Сумма: " + sum);
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // ТЕСТ 5: Демонстрация ArrayIndexOutOfBoundsException
        demonstrateArrayIndexOutOfBoundsException();

        // ТЕСТ 6: Ещё один пример ArrayIndexOutOfBoundsException
        System.out.println("\n Дополнительный пример ArrayIndexOutOfBoundsException:");
        System.out.println("====================================================");

        String[][] testArray = new String[4][4];

        try {
            System.out.println("Попытка доступа к testArray[5][3]...");
            String value = testArray[5][3];  // Выход за границы
            System.out.println("Значение: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Поймано исключение: " + e.getClass().getSimpleName());
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Массив имеет размеры: 4x4 (индексы 0-3)");
        }

        // ИТОГ
        System.out.println("\n ЗАВЕРШЕНИЕ ПРОГРАММЫ");
        System.out.println("======================");
        System.out.println("Все исключения обработаны корректно! ");
    }
}