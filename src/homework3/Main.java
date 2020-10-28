package homework3;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Задание 3.1: На основе массива из домашнего задания 2.1 реализуйте простой список и коллекцию. Оцените время
        // выполнения преобразования.
        Integer[] arr = new Integer[]{9,8,2,1,5,6,4,3,10,7};
        System.out.println("Задание 3.1. \nСтартовый массив arr: " + Arrays.toString(arr));
        long startTime_3_1 = System.nanoTime();
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(arr));
        long executionTime_3_1 = System.nanoTime() - startTime_3_1;
        System.out.println("Получившийся список arrayList: " + arrayList + "\nВремя выполнения преобразования массива в" +
                " список заняло: " + executionTime_3_1 + " наносекунд \n");

        // Задание 3.2: На основе списка из задания 3.1 реализуйте основные методы добавления, удаления и получения
        // объекта или элемента из списка. Оценить выполненные методы с помощью базового класса System.nanoTime().
        System.out.println("Задание 3.2. \nДобавление элемента:");
        long startTime_3_2 = System.nanoTime();
        arrayList.add(10, 100);
        long executionTime_3_2 = System.nanoTime() - startTime_3_2;
        System.out.println("Получившийся список arrayList после добавления элемента: " + arrayList + "\nВремя выполнения" +
                " метода добавления элемента в список заняло: " + executionTime_3_2 + " наносекунд\nУдаление элемента:");
        startTime_3_2 = System.nanoTime();
        arrayList.remove(10);
        executionTime_3_2 = System.nanoTime() - startTime_3_2;
        System.out.println("Получившийся список arrayList после удаления элемента: " + arrayList + "\nВремя выполнения" +
                " метода удаления элемента из списка заняло: " + executionTime_3_2 + " наносекунд\nПолучение элемента:");
        startTime_3_2 = System.nanoTime();
        int a = arrayList.get(8);
        executionTime_3_2 = System.nanoTime() - startTime_3_2;
        System.out.println("Полученный элемент arrayList: " + a + "\nВремя выполнения метода получения элемента из списка" +
                " заняло: " + executionTime_3_2 + " наносекунд \n");

        // Задание 3.3: Реализуйте простой односвязный список и его базовые методы.
        // Необходимые для выполнения данного задания классы прописаны ниже (после класса main).
        System.out.println("Задание 3.3.");
        LinkedList <Integer> list = new LinkedList<>();
        list.insert(1);
        list.insert(5);
        list.insert(100);
        System.out.print("Получившийся односвязный список: ");
        list.display();
        System.out.println("\nПример поиска нужного элемента с помощью метода find: "+ list.find(100) + "\n");

        // Задание 3.4: На основе списка из задания 3.1 реализуйте простой двусторонний список и его базовые методы.
        // Реализуйте список, заполненный объектами из вашего класса из задания 1.3
        System.out.print("Задание 3.4.\nЗаполнение LinkedList из Arraylist. ");
        java.util.LinkedList<Integer> linkedList = new java.util.LinkedList<>();
        linkedList.addAll(0,arrayList);
        System.out.print("Получившийся двусторонний список: " + linkedList + "\nДобавление элемента в двусторонний " +
                "список. ");
        linkedList.add(100);
        System.out.print("Получившийся двусторонний список: " + linkedList+ "\nЗамена элемента в двустороннем списке. ");
        linkedList.set(4,500);
        System.out.print("Получившийся двусторонний список: " + linkedList+ "\nУдаление элемента из двустороннего списка. ");
        linkedList.remove(10);
        System.out.print("Получившийся двусторонний список: " + linkedList+ "\nДобавление первого и последнего элемента. ");
        linkedList.addFirst(100);
        linkedList.addLast(200);
        System.out.println("Получившийся двусторонний список: " + linkedList + "\n");

        // Задание 3.5: Реализуйте итератор на основе связанных списков из задания 3.4 и выполните базовые операции
        // итератора. Оцените время выполнения операций с помощью базового метода System.nanoTime()
        System.out.println("Задание 3.5.\nПроверяем есть ли в связанном списке следующий элемент (метод hasNext) и" +
                " распечатываем по порядку все элементы с помощью метода next:");
        ListIterator<Integer> iterator = linkedList.listIterator();
        long startTime_3_5 = System.nanoTime();
        while (iterator.hasNext()){
            System.out.print(iterator.next() + " ");
        }
        long executionTime_3_5 = System.nanoTime() - startTime_3_5;
        System.out.println("\nВремя выполнения данных методов заняло: " + executionTime_3_5 + " наносекунд\nПроверяем" +
                " есть ли в связанном списке предыдущий элемент (метод hasPrevious) и распечатываем в обратном порядке" +
                " все элементы с помощью метода previous:");
        startTime_3_5 = System.nanoTime();
        while (iterator.hasPrevious()){
            System.out.print(iterator.previous() + " ");
        }
        executionTime_3_5 = System.nanoTime() - startTime_3_5;
        System.out.print("\nВремя выполнения данных методов заняло: " + executionTime_3_5 + " наносекунд\nУдаление" +
                        " элементов списка, которые при делении на 100 дают целое число без остатка (то есть 100, 500 и" +
                " 200):");
        startTime_3_5 = System.nanoTime();
        while (iterator.hasNext()){
            Integer abc = iterator.next();
            if(abc % 100 == 0){
                iterator.remove();
            }
        }
        executionTime_3_5 = System.nanoTime() - startTime_3_5;
        System.out.println("\nПолучившийся список " + linkedList + "\nВремя выполнения удаления элементов заняло: " +
                executionTime_3_5 + " наносекунд\nДобавление элемента (со значением 999) в список в том месте, на которое" +
                " в текущий момент указывает итератор (в нашем случае это конец списка):");
        startTime_3_5 = System.nanoTime();
        iterator.add(999);
        executionTime_3_5 = System.nanoTime() - startTime_3_5;
        System.out.println("Получившийся список " + linkedList + "\nВремя выполнения добавления элемента заняло: "
                + executionTime_3_5 + " наносекунд");
    }

    // класс элемента списка для выполнения задания 3.3
    static class Link<T>{
        private T link;
        private Link<T> next;

        public Link(T link) {
            this.link = link;
        }

        public Link<T> getNext(){
            return next;
        }

        public void setNext (Link<T> next){
            this.next = next;
        }

        public T getValue(){
            return link;
        }
    }

    // класс односвязного списка для выполнения задания 3.3
    static class LinkedList<T>{
        private Link<T> first;

        public LinkedList(){
            first = null;
        }

        public boolean isEmpty(){
            return (first == null);
        }

        public void insert(T link){
            Link<T> l = new Link<>(link);
            l.setNext(first);
            this.first = l;
        }

        public Link<T> delete(){
            Link<T> temp = first;
            first = first.getNext();
            return temp;
        }

        public void display(){
            Link<T> current = first;
            while(current != null){
                System.out.print(current.getValue() + " ");
                current = current.getNext();
            }
        }

        public T find(T searchNode){
            Link<T> findNote = new Link<>(searchNode);
            Link<T> current = first;
            while (current != null){
                if(current.getValue().equals(findNote.getValue())){
                    return findNote.getValue();
                }
                current = current.getNext();
            }
            return null;
        }
    }
}
