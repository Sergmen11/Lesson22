import java.util.Arrays;
import java.util.Scanner;

class MainWords {
    public static void main(String[] args) {
        printThreeWords();

    }

    static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
}

class MainSum {
    public static void main(String[] args) {
        checkSumSign();
    }

    static void checkSumSign() {
        int a = 20;
        int b = 34;
        int sum = a + b;

        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Суумма отрицительная");
        }
    }
}

class MainColor {
    public static void main(String[] args) {
        printColor();
    }
    static void printColor() {
        int value = 0;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value > 0 & value <= 100) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }
}

class MainNumbers {
    public static void main(String[] args) {
        compareNumbers();
    }
    static void compareNumbers() {
        int a = 12;
        int b = 24;

        if (a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
}

class MainBul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num_1 = sc.nextInt();
        int num_2 = sc.nextInt();

        System.out.println(printBul(num_1, num_2));
    }
    static boolean printBul(int num_1, int num_2) {
        int sum = num_1 + num_2;

        return sum >= 10 & sum <= 20;
    }
}

class MainPol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        printPol(num);
    }
    static void printPol(int num) {
        System.out.println((num >= 0) ? "Положительное число" : "Отрицательное число");
    }
}

class MainOtr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(printOtr(num));
    }
    static boolean printOtr(int num) {

        return num < 0;
    }
}

class MainFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int num = sc.nextInt();

        printFor(str, num);
    }
    static void printFor(String str, int num) {
        for (int i = 1; i <= num; i++) {
            System.out.println(str);
        }
    }
}

class MainLeap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        System.out.println(leapYear(year));
    }
    static boolean leapYear(int year) {

        if (year % 4 == 0 & (year % 100 != 0) || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }
}

class MainArray {
    public static void main(String[] args) {
        printArray();
    }
    static void printArray() {
        int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                arr[i] = 0;
            } else {
                arr[i] = 1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}

class MainArrays {
    public static void main(String[] args) {
        printArrays();
    }
    static void printArrays() {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        System.out.println(Arrays.toString(arr));
    }
}

class MainSix {
    public static void main(String[] args) {
        minSix();
    }
    static void minSix() {
        int[] arr = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 6) {
                arr[i] = arr[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}

class MainDiagonals {
    public static void main(String[] args) {
        diagonalsSquare();
    }
    static void diagonalsSquare() {
        int[][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == j) {
                    arr[i][j] = 1;
                } else if (i + j == arr.length - 1) {
                    arr[i][j] = 1;
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}

class MainLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int initialValue = sc.nextInt();

        System.out.println(Arrays.toString(createFilledArrayLoop(len, initialValue)));
    }

    static int[] createFilledArrayLoop(int len, int initialValue) {
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = initialValue;
        }
        return arr;
    }
}