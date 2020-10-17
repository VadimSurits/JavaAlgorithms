package homework2;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Задание 2.1: Реализуйте массив на основе существующих примитивных или ссылочных типов данных. Выполните
        // обращение к массиву и базовые операции класса Arrays. Оценить выполненные методы с помощью базового класса
        // System.nanoTime().
        Random random = new Random();
        int[] arr = new int[]{9,8,2,1,5,6,4,3,10,7};
        int key = arr[random.nextInt(arr.length)];
        System.out.println("Задание 2.1. \nБазовые операции класса Arrays:");
        long startTime_2_1 = System.nanoTime();
        System.out.println("Получившийся массив arr: " + Arrays.toString(arr));
        int[] arrCopy = Arrays.copyOf(arr,arr.length);
        System.out.println("Cкопированный массив arrCopy: " + Arrays.toString(arrCopy));
        System.out.println("Результат метода binarySearch(поиск значения 'key' в массиве), искомое значение " +
                "находится в элементе массива под индексом " + Arrays.binarySearch(arr, key));
        System.out.println("Вывод результата метода Arrays.equals между массивами arr и arrCopy: " + Arrays.equals
                (arr, arrCopy));
        long executionTime_2_1 = System.nanoTime() - startTime_2_1;
        System.out.println("Время выполнения указанных базовых операций класса Arrays заняло: " + executionTime_2_1 +
                " наносекунд \n");

        //Задание 2.2: На основе написанного кода в задании 2.1 реализуйте линейный и двоичный поиск. Оценить алгоритмы
        // линейного и двоичного поиска с помощью базового класса System.nanoTime(), при необходимости расширьте уже
        // существующий массив данных.
        long startTime_2_2 = System.nanoTime();
        long executionTime_2_2;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == key){
                executionTime_2_2 = System.nanoTime() - startTime_2_2;
                System.out.println("Задание 2.2. \nВремя выполнения линейного поиска значения (key) в неотсортированном" +
                        " массиве заняло " + executionTime_2_2 + " наносекунд");
            }
        }
        startTime_2_2 = System.nanoTime();
        Arrays.binarySearch(arr, key);
        executionTime_2_2 = System.nanoTime() - startTime_2_2;
        System.out.println("Время выполнения двоичного поиска значения (key) в неотсортированном массиве заняло "
                + executionTime_2_2 + " наносекунд \n");

        // Задание 2.3: Создайте массив размером 400 элементов. Выполните сортировку с помощью метода sort().
        // Оцените сортировку с помощью базового класса System.nanoTime().
        int[] bigArr_2_3 = new int[400];
        for(int i = 0; i < bigArr_2_3.length; i++){
            bigArr_2_3[i] = random.nextInt(1000);
        }

        int[] bigArr_2_4 = bigArr_2_3.clone();//создаю такой же неотсортированный клон массива bigArr_2_3 для задания 2.4
        int[] bigArr_2_5 = bigArr_2_3.clone();//создаю такой же неотсортированный клон массива bigArr_2_3 для задания 2.5
        int[] bigArr_2_6 = bigArr_2_3.clone();//создаю такой же неотсортированный клон массива bigArr_2_3 для задания 2.6

        System.out.println("Задание 2.3. \nИзначальный массив: " + Arrays.toString(bigArr_2_3));
        long startTime_2_3 = System.nanoTime();
        Arrays.sort(bigArr_2_3);
        long executionTime_2_3 = System.nanoTime() - startTime_2_3;
        System.out.println("Отсортированный массив: " + Arrays.toString(bigArr_2_3) + "\nВремя выполнения сортировки" +
                " массива bigArr_2_3 с помощью метода sort() заняло " + executionTime_2_3 + " наносекунд\n");

        //Задание 2.4: На основе существующего массива данных из задания 2.3 реализуйте алгоритм сортировки пузырьком.
        // Оцените сортировку с помощью базового класса System.nanoTime(). Сравните время выполнения алгоритмы сортировки
        // методом sort() из задания 2.3 и сортировку пузырьком.
        System.out.println("Задание 2.4. \nИзначальный массив: " + Arrays.toString(bigArr_2_4));
        int buff;
        boolean sorted = false;
        long startTime_2_4 = System.nanoTime();
        while(!sorted){
            sorted = true;
            for(int i = 0; i < bigArr_2_4.length - 1; i++){
                if(bigArr_2_4[i] > bigArr_2_4[i+1]){
                    sorted = false;
                    buff = bigArr_2_4[i];
                    bigArr_2_4[i] = bigArr_2_4[i+1];
                    bigArr_2_4[i+1] = buff;
                }
            }
        }
        long executionTime_2_4 = System.nanoTime() - startTime_2_4;
        System.out.println("Отсортированный массив: " + Arrays.toString(bigArr_2_4) + "\nВремя выполнения сортировки" +
                " пузырьком массива bigArr_2_4 заняло " + executionTime_2_4 + " наносекунд");
        System.out.println("Выполнение сортировки массива методом сортировки пузырьком заняло на " +
                (executionTime_2_4 - executionTime_2_3) + " наносекунд больше, чем метод sort().\n");

        //Задание 2.5: На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом выбора. Оцените
        // сортировку с помощью базового класса System.nanoTime(). Сравните с временем выполнения алгоритмов сортировки
        // из прошлых заданий 2.3 и 2.4.
        System.out.println("Задание 2.5. \nИзначальный массив: " + Arrays.toString(bigArr_2_5));
        long startTime_2_5 = System.nanoTime();
        for (int i = 0; i < bigArr_2_5.length - 1; i++){
            int min = i;
            for(int j = i+1; j < bigArr_2_5.length; j++){
                if(bigArr_2_5[j] < bigArr_2_5[min]){
                    min = j;
                }
            }
            buff = bigArr_2_5[i];
            bigArr_2_5[i] = bigArr_2_5[min];
            bigArr_2_5[min] = buff;
        }
        long executionTime_2_5 = System.nanoTime() - startTime_2_5;
        System.out.println("Отсортированный массив: " + Arrays.toString(bigArr_2_5) + "\nВремя выполнения сортировки" +
                " массива bigArr_2_5 методом выбора заняло " + executionTime_2_5 + " наносекунд");
        System.out.println("Выполнение сортировки массива методом выбора заняло:\n- на " +
                (executionTime_2_5 - executionTime_2_3) + " наносекунд больше, чем метод sort();\n" +
                "- на " + (executionTime_2_4 - executionTime_2_5) + " наносекунд меньше, чем метод сортировки пузырьком.\n");

        //Задание 2.6: На основе массива данных из задания 2.3 реализуйте алгоритм сортировки методом вставки. Оцените
        // сортировку с помощью базового класса System.nanoTime(). Сравните с временем выполнения алгоритмов сортировки
        // из прошлых заданий 2.3, 2.4 и 2.5.
        System.out.println("Задание 2.6. \nИзначальный массив: " + Arrays.toString(bigArr_2_6));
        int in;
        long startTime_2_6 = System.nanoTime();
        for(int i = 1; i < bigArr_2_6.length; i++){
            buff = bigArr_2_6[i];
            in = i;
            while (in > 0 && bigArr_2_6[in-1] >= buff){
                bigArr_2_6[in] = bigArr_2_6[in-1];
                in--;
            }
            bigArr_2_6[in] = buff;
        }
        long executionTime_2_6 = System.nanoTime() - startTime_2_6;
        System.out.println("Отсортированный массив: " + Arrays.toString(bigArr_2_6) + "\nВремя выполнения сортировки" +
                " массива bigArr_2_6 методом вставки заняло " + executionTime_2_6 + " наносекунд");
        System.out.println("Выполнение сортировки массива методом вставки заняло:\n- на " +
                (executionTime_2_6 - executionTime_2_3) + " наносекунд больше, чем метод sort();\n" +
                "- на " + (executionTime_2_5 - executionTime_2_6) + " наносекунд меньше, чем метод вставки;\n" +
                "- на " + (executionTime_2_4 - executionTime_2_6) + " наносекунд меньше, чем метод сортировки пузырьком.");
    }
}
