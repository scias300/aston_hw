public class Main {
    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4) {
            throw new MyArraySizeException("Количество строк должно равняться 4");
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != 4) {
                throw new MyArraySizeException("Строка " + i + " должна содержать 4 элемента");
            }
        }
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(
                            "Некорректные данные в ячейке [" + i + "][" + j + "]: "
                                    + array[i][j]);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "abc", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumArray(array);
            System.out.println("Сумма = " + result);

        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных массива: " + e.getMessage());
        }

        try {
            System.out.println(array[5][5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ошибка: обращение к индексу за границами массива");
            System.out.println(e.getMessage());
        }
    }
}
