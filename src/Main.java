import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    static Random random;

    public static void main(String[] args) {

    //    Задание 1.1: Приведите пример алгоритмов и структур данных из жизни.
    //    Чтение книги. Книга сама по себе является данными, которые упорядочены и структурированы в соответствии
    //    с видением автора. Как читатели, мы можем читать книгу с помощью разных подходов и алгоритмов. Например,
    //    самый простой и принятый способ – это прочитать книгу целиком по порядку, начиная с 1 страницы и заканчивая
    //    последней. Но в зависимости от наших целей мы можем избрать и другой подход. Например, по каким-то причинам
    //    нас интересует именно пятая глава книги, а все остальные главы нас не интересуют, в этом случае нам не нужно
    //    тратить время на чтение книги с самого начала, а в соответствии с оглавлением мы сразу открываем начальную
    //    страницу 5 главы и читаем только эту главу (и тратим на это гораздо меньше времени, чем при чтении всей книги).

    //    Задание 1.2: Приведите пример алгоритмов и структур данных в программировании.
    //    Обычный цикл for в Java, например:
    //    for (int i = 0; i <= 5;  i++){
    //        System.out.println(i);
    //    }
    //    В данном случае мы проходим линейным алгоритмом по порядку по указанным данным (от 0 до 5) и распечатываем
    //    их также по порядку в консоль.

        // задание 1.3: Напишите программный код, в котором все данные хранятся только в переменных трех типов данных:
        // Ссылочные, примитивные и своего класса содержащего: конструктор и метод отображения данных.
        //Выведите написанные данные.
        String abc = "Hello, world!";
        byte a = -100;
        short b = 0;
        int c = 20000;
        long d = 500L;
        float e = 13.25f;
        double f = -573.007;
        char g = '\u2242';
        boolean h = false;
        SvoyClass svoyClass = new SvoyClass("svoyClass");

        System.out.println(abc);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        System.out.println(f);
        System.out.println(g);
        System.out.println(h);
        svoyClass.printInConsole();

        // задание 1.4: Дополните предыдущий код сравнением ваших данных с другой переменной, данный код должен
        // имитировать простейший поиск перебором. Оцените время выполнения алгоритма с помощью базового метода
        // System.nanoTime().
        String[] arr = new String[]{abc, String.valueOf(a),String.valueOf(b),String.valueOf(c),String.valueOf(d),
            String.valueOf(e),String.valueOf(f),String.valueOf(g), String.valueOf(h), svoyClass.name};
        random = new Random();
        String drugayaPeremennaya = String.valueOf(arr[random.nextInt(arr.length)]);
        compare(drugayaPeremennaya,arr);
    }

    private static void compare(String x, String[] arr){
        long startTime = System.nanoTime();
        for(int i = 0; i < arr.length; i++){
            if(x == String.valueOf(arr[i])){
                long executionTime = System.nanoTime() - startTime;
                System.out.println("Задание 1.4: x = "+ String.valueOf(arr[i]) + " from arr[" + i + "], algorithm's" +
                        " execution time is " + executionTime + " nanoseconds.");
            }
        }
    }
}
