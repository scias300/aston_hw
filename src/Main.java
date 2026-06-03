import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        System.out.println();

        checkSumSign();
        System.out.println();

        printColor();
        System.out.println();

        compareNumbers();
        System.out.println();

        System.out.println(isSumBetween10And20(1, 2));
        System.out.println();

        checkPositive(-1);
        System.out.println();

        System.out.println(isPositive(0));
        System.out.println();

        printStringNTimes("Здарова", 2);
        System.out.println();

        System.out.println(isYearLeap(2026));
        System.out.println();

        changeArray();
        System.out.println();

        createArray1To100();
        System.out.println();

        doubleValuesLessThanSix();
        System.out.println();

        createDiagonal();
        System.out.println();

        System.out.println(Arrays.toString(createFilledArray(5, 7)));
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }

    public static void checkSumSign(){
        int a = 5;
        int b = 10;
        if (a+b>0){
            System.out.println("Сумма положительная");
        }else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void printColor(){
        int value = 10;
        if (value<=0){
            System.out.println("Красный");
        } else if (value>0&&value<=100) {
            System.out.println("Желтый");
        }else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers(){
        int a = 2;
        int b = 2;
        if (a>=b){
            System.out.println("a >= b");
        }else {
            System.out.println("a < b");
        }
    }

    public static boolean isSumBetween10And20(int a, int b){
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkPositive(int a){
        if (a>=0){
            System.out.println("Число " + a + " - положительное");
        }else {
            System.out.println("Число " + a + " - отрицательное");
        }
    }

    public static boolean isPositive(int a){
        return a < 0;
    }

    public static void printStringNTimes(String message, int repeats){
        for (int i = 0; i < repeats; i++) {
            System.out.println(message);
        }
    }

    public static boolean isYearLeap(int year){
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    public static void changeArray(){
        int [] array = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                array[i] = 0;
            } else if (array[i] == 0) {
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void createArray1To100(){
        int[]array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i+1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void doubleValuesLessThanSix(){
        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i]<6){
                array[i] = array[i]*2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void createDiagonal(){
        int [][] array = new int[7][7];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j){
                    array[i][j] = 1;
                } else if (i+j==array.length-1) {
                    array[i][j] = 1;
                }
            }
        }
        for (int[] elem : array){
            System.out.println(Arrays.toString(elem));
        }
    }

    public static int[] createFilledArray(int len, int initialValue){
        int [] result = new int[len];
        for (int i = 0; i < result.length; i++) {
            result[i] = initialValue;
        }
        return result;
    }
}
