// Исключение для некорректных данных в массиве
public class MyArrayDataException extends Exception {

    private int row;
    private int column;
    private String invalidValue;

    public MyArrayDataException(String message, int row, int column, String invalidValue) {
        super(message);
        this.row = row;
        this.column = column;
        this.invalidValue = invalidValue;
    }

    public int getRow() { return row; }
    public int getColumn() { return column; }
    public String getInvalidValue() { return invalidValue; }
}