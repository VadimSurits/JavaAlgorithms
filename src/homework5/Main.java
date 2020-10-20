package homework5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        //Задание 5.1: Приведите пример использования рекурсии.
        //Конечная рекурсия - обыкновенная матрёшка.
        //Бесконечная рекурсия - круговорот воды в природе.

        //Задание 5.2: Реализуйте простой пример бесконечной рекурсии и обычной рекурсии с условием для выхода.
        System.out.println("Задание 5.2.");
        int a = 10;
        // Бесконечная рекурсия (метод endlessCountdown намеренно закомментирован для того, чтобы выполнение кода не
        // прерывалось из-за StackOverflowError:

        // endlessCountdown(a);

        // Обычная рекурсия:
        countdown(a);

        //Задание 5.3: Приведите пример изображающий стек вызова и стек вызова с рекурсией.
        System.out.println("\nЗадание 5.3.\nПример стека вызова:");
        String name = "Иван";
        greetings(name);
        // В данном случае стек вызова будет заполняться следующим образом:
        // main -> greetings -> hello -> println. После вывода на печать приветствия стек очистится в обратном порядке
        // println -> hello и вернется до уровня метода greetings, из которого стек снова заполнится дальше следующими
        // двумя методами bye -> println и будет выглядеть таким образом: main -> greetings -> bye -> println
        // После вывода на печать прощания стек очистится в обратном порядке println -> bye -> greetings и вернется
        // в main.

        System.out.println("\nПример стека вызова c рекурсией (метод recursiveGreetings):");
        int count_5_3 = 0;
        recursiveGreetings(name, count_5_3);
        // В данном случае за основу взят предыдущий пример, но вместо метода greetings будем использовать метод
        // recursiveGreetings, который вместо вызовов методов hello и bye будет самостоятельно вызывать метод println
        // для приветствия и прощания, а затем вызывать сам себя до тех пор, пока переменная count не станет равна 3.
        // В данном случае стек вызова будет заполняться следующим образом:
        // 1) main -> recursiveGreetings -> println
        // 2) main -> recursiveGreetings -> recursiveGreetings -> println
        // 3) main -> recursiveGreetings -> recursiveGreetings -> recursiveGreetings -> println
        // После этого стек вызова очистится в обратном порядке и вернется в main.

        // Задание 5.4: Реализуйте простой алгоритм использующий цикл и простой алгоритм использующий рекурсию. Оцените
        // два алгоритма с помощью базового метода System.nanoTime().
        System.out.println("\nЗадание 5.4.\nПример реализации алгоритма цикла (берем тот же пример с выводом приветствия" +
                " и прощания):");
        int count_5_4 = 0;
        do{
            greetings(name);
            count_5_4++;
        } while(count_5_4 < 3);
        // C помощью цикла трижды запустили метод greetings

        System.out.println("\nПример реализации алгоритма рекурсии продемонстрирован в задании 5.3 в методе " +
                "recursiveGreetings");

        //Задание 5.5: Реализуйте алгоритм двоичного рекурсивного поиска на основе массива из задания 2.1. Оцените
        // алгоритм двоичного рекурсивного поиска с помощью базового метода System.nanoTime() и сравните с обычным
        // двоичным поиском.
        System.out.println("\nЗадание 5.5.\nРеализация алгоритма двоичного рекурсивного поиска:");
        int[] arr = new int[]{9,8,2,1,5,6,4,3,10,7}; // массив для обычного метода binarySearch
        int[] arr2 = Arrays.copyOf(arr, arr.length); // массив для метода двоичного рекурсивного поиска
        int[] arr3 = Arrays.copyOf(arr, arr.length); // массив для сортировки методом sort (задание 5.6)
        int[] arr4 = Arrays.copyOf(arr, arr.length); // массив для сортировки слиянием (задание 5.6)
        int key = 8;
        System.out.println("Изначальный массив arr:" + Arrays.toString(arr));
        Arrays.sort(arr);
        Arrays.sort(arr2);
        System.out.println("Отсортированный массив arr:" + Arrays.toString(arr));
        long startTime_5_5 = System.nanoTime();
        System.out.println("Результат обычного метода binarySearch: искомый элемент располагается под индексом " +
                Arrays.binarySearch(arr, key));
        long executionTime_5_5 = System.nanoTime() - startTime_5_5;
        startTime_5_5 = System.nanoTime();
        System.out.println("Время выполнения обычного метода binarySearch заняло: " + executionTime_5_5 +" наносекунд\n" +
                "Результат метода двоичного рекурсивного поиска: искомый элемент располагается под индексом "
                + recBinarySearch(key,0,arr2.length,arr2));
        executionTime_5_5 = System.nanoTime() - startTime_5_5;
        System.out.println("Время выполнения метода двоичного рекурсивного поиска заняло: " + executionTime_5_5 +
                " наносекунд");

        // Задание 5.6: На основе массива из задания 2.1 реализуйте алгоритм сортировки слиянием. Оцените алгоритм
        // сортировки слиянием с помощью базового метода System.nanoTime() и сравните с сортировкой методом sort().
        System.out.println("\nЗадание 5.6.\nРеализация алгоритма сортировки слиянием\nИзначальный массив arr: " +
                Arrays.toString(arr3));
        long startTime_5_6 = System.nanoTime();
        Arrays.sort(arr3);
        long executionTime_5_6 = System.nanoTime() - startTime_5_6;
        System.out.println("Результат метода sort: " + Arrays.toString(arr3) + "\nВремя выполнения метода sort заняло: " +
                " " + executionTime_5_6 + " наносекунд");
        startTime_5_6 = System.nanoTime();
        sortMerge(arr4);
        executionTime_5_6 = System.nanoTime() - startTime_5_6;
        System.out.println("Результат сортировки слиянием: " + Arrays.toString(sortMerge(arr4)) + "\nВремя выполнения" +
                " сортировки слиянием заняло: " + executionTime_5_6 + " наносекунд");
        executionTime_5_6 = System.nanoTime() - startTime_5_6;
    }

    //метод для бесконечной рекурсии из задания 5.2
    public static int endlessCountdown(int a){
        System.out.println(a);
        return endlessCountdown(a-1);
    }

    //метод для обычной рекурсии из задания 5.2
    public static int countdown(int a){
        System.out.println(a);
        if (a == 1){
            return a;
        }
        return countdown(a-1);
    }

    //3 метода для объяснения стека вызова из задания 5.3 (также использую их для задания 5.4)
    public static void greetings(String name){
        hello(name);
        bye(name);
    }
    public static void hello(String name){
        System.out.println(name + ", привет!");
    }
    public static void bye(String name){
        System.out.println(name + ", пока!");
    }
    //метод для объяснения стека вызова с рекурсией из задания 5.3 и для реализации алгоритма рекурсии из задания 5.4
    public static void recursiveGreetings(String name, int count){
        if(count == 3){
            return;
        } else{
            System.out.println(name + ", привет!");
            System.out.println(name + ", пока!");
            count++;
        }
        recursiveGreetings(name, count);
    }

    //метод двоичного рекурсивного поиска (задание 5.5)
    public static int recBinarySearch(int searchkey, int low, int high, int[] arr){
        if(low>high){
            return arr.length;
        }
        int middle = (low + high)/2;
        if(arr[middle] == searchkey){
            return middle;
        } else if(arr[middle] < searchkey){
            return recBinarySearch(searchkey, low+1,high,arr);
        } else{
            return recBinarySearch(searchkey, low,high-1,arr);
        }
    }

    //метод сортировки слиянием (задание 5.6)
    public static int[] sortMerge (int[] arr){
        int length = arr.length;
        if(length < 2){
            return arr;
        }
        int middle = length / 2;
        return merge(sortMerge(Arrays.copyOfRange(arr,0,middle)),
                sortMerge(Arrays.copyOfRange(arr, middle, length)));
    }
    //метод слияния для задания 5.6
    public static int[] merge (int[] a, int[] b){
        int[] result = new int[a.length + b.length];
        int aIndex = 0;
        int bIndex = 0;

        for(int i = 0; i < result.length; i++){
            result[i] = a[aIndex] < b[bIndex] ? a[aIndex++] : b[bIndex++];
            if(aIndex == a.length){
                System.arraycopy(b, bIndex, result, ++i, b.length - bIndex);
                break;
            }
            if(bIndex == b.length){
                System.arraycopy(a, aIndex,result, ++i,a.length - aIndex);
                break;
            }
        }
        return result;
    }
}
