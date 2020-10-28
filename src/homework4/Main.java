package homework4;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Задание 4.1: На основе данных объектного списка из задания 3.4 реализуйте простой стек и его базовые методы.
        // Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.print("Задание 4.1.\nЗаполнение Stack из LinkedList: ");
        Integer[] arr = new Integer[]{9,8,2,1,5,6,4,3,10,7};
        LinkedList<Integer> linkedList = new LinkedList<>(Arrays.asList(arr));
        Stack<Integer> stack = new Stack<>();
        long startTime_4_1 = System.nanoTime();
        stack.addAll(linkedList);
        System.out.println(stack + "\nВыводим последний элемент с помощью метода peek: " + stack.peek());
        stack.pop();
        long executionTime_4_1 = System.nanoTime() - startTime_4_1;
        System.out.println("Удаляем последний элемент с помощью метода pop. Выводим получившийся stack: " + stack + "\n" +
                "Время выполнения данных операций заняло: " + executionTime_4_1 + " наносекунд\n");

        // Задание 4.2: На основе данных объектного списка из задания 3.4 реализуйте простую очередь и его базовые
        // методы. Реализуйте вспомогательные методы. Оцените время выполнения операций с помощью базового метода
        // System.nanoTime().
        System.out.print("Задание 4.2.\nЗаполнение Queue из LinkedList: ");
        Queue<Integer> queue = new LinkedList<>();
        long startTime_4_2 = System.nanoTime();
        queue.addAll(linkedList);
        System.out.println(linkedList + "\nВыводим первый элемент с помощью метода element: " + queue.element());
        queue.remove();
        System.out.println("Удаляем первый элемент с помощью метода remove. Выводим получившуюся Queue: " + queue + "\n" +
                "Проверяем, пустая ли Queue с помощью метода isEmpty: " + queue.isEmpty() +"\nПроверяем размер Queue " +
                "с помощью метода size: " + queue.size());
        long executionTime_4_2 = System.nanoTime() - startTime_4_2;
        System.out.println("Время выполнения данных операций заняло: " + executionTime_4_2 + " наносекунд\n");

        // Задание 4.3: На основе данных объектного списка из задания 3.4 реализуйте простой дек и его базовые методы.
        // Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.print("Задание 4.3.\nЗаполнение Deque из LinkedList: ");
        long startTime_4_3 = System.nanoTime();
        Deque<Integer> deque = new ArrayDeque<>(linkedList);
        System.out.print(deque + "\nДобавляем элемент в начало Deque с помощью метода addFirst. ");
        deque.addFirst(100);
        System.out.print("Выводим получившийся Deque: " + deque + "\nДобавляем элемент в конец Deque с помощью метода" +
                " addLast. ");
        deque.addLast(200);
        System.out.println("Выводим получившийся Deque: " + deque + "\nВыводим первый и последний элементы Deque с" +
                " помощью методов peekFirst : " + deque.peekFirst() + " и peekLast: " + deque.peekLast());
        deque.pollFirst();
        deque.pollLast();
        long executionTime_4_3 = System.nanoTime() - startTime_4_3;
        System.out.println("Удаляем первый и последний элементы Deque c помощью методов pollFirst и pollLast. Выводим" +
                " получившийся Deque: " + deque + "\nВремя выполнения данных операций заняло: " + executionTime_4_3 +
                " наносекунд\n");

        // Задание 4.4: Реализуйте приоритетную очередь на основе ссылочных типов данных, например, integer. Оцените
        // время выполнения операций с помощью базового метода System.nanoTime().
        System.out.print("Задание 4.4.\nЗаполнение PriorityQueue из LinkedList: ");
        long startTime_4_4 = System.nanoTime();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(linkedList);
        System.out.println(priorityQueue + "\nВыводим приоритетный элемент с помощью метода peek: " + priorityQueue.peek());
        priorityQueue.poll();
        long executionTime_4_4 = System.nanoTime() - startTime_4_4;
        System.out.println("Удаляем приоритетный элемент с помощью метода poll. Выводим получившуюся PriorityQueue: "
                + priorityQueue + "\nВремя выполнения данных операций заняло: " + executionTime_4_4 + " наносекунд\n");

        // Задание 4.5: На основе данных из задания 4.1 и 4.2, реализуйте стек и очередь на базе связанного списка.
        // Оцените время выполнения операций с помощью базового метода System.nanoTime().
        System.out.print("Задание 4.5.\nЗаполнение Stack на базе связанного списка (myStack) из Stack(из задания 4.1): ");
        StackList myStack = new StackList();
        long startTime_4_5 = System.nanoTime();
        for(int i = 0; i < stack.size(); i++){
            myStack.push(stack.get(i));
        }
        myStack.display();
        System.out.println("\nПроверяем заполненность Stack на базе связанного списка и удаляем элементы по очереди, пока" +
                " Stack не станет пустым: ");
        while(!myStack.isEmpty()){
            System.out.println("Элемент " + myStack.pop() + " удален из Stack");
        }
        long executionTime_4_5 = System.nanoTime() - startTime_4_5;
        System.out.print("Время выполнения данных операций заняло: " + executionTime_4_5 + " наносекунд\n\nЗаполнение " +
                "Queue на базе связанного списка (myQueue) из Queue(из задания 4.2): ");

        MyQueue myQueue = new MyQueue();
        startTime_4_5 = System.nanoTime();  //Сделал данную реализацию цикла for с учетом особенностей базовых методов
        for(int i = 0; i < queue.size();){  //исходной queue. Чтобы корректно перенести содержимое исходной queue в
            myQueue.insert(queue.peek());   //myQueue пошагово переношу элемент, после чего удаляю его, чтобы перенести
            queue.poll();                   //следующий элемент с помощью базового метода peek. queue.size() на каждом
        }                                   //следующем шаге уменьшается на 1 за счет удаленного элемента, поэтому нет
        myQueue.display();                  //необходимости в стандартной операции i++).

        System.out.println("\nПроверяем заполненность myQueue и удаляем элементы по очереди, пока Queue не станет пустой: ");
        while(!myQueue.isEmpty()){
            System.out.println("Элемент " + myQueue.delete() + " удален из myQueue");
        }
        executionTime_4_5 = System.nanoTime() - startTime_4_5;
        System.out.println("Время выполнения данных операций заняло: " + executionTime_4_5 + " наносекунд");
    }

    // класс элемента списка для выполнения задания 4.5
    static class Link{
        public int value;

        public Link next;

        public Link(int value) {
            this.value = value;
        }

        public void display(){
            System.out.print(this.value + " ");
        }
    }

    // класс односвязного списка для выполнения задания 4.5
    static class MyLinkedList{
        public Link first;

        public MyLinkedList(){
            first = null;
        }

        public boolean isEmpty(){
            return (first == null);
        }

        public void insert(int value){
            Link newLink = new Link(value);
            newLink.next = first;
            first = newLink;
        }

        public Link delete(){
            Link temp = first;
            first = first.next;
            return temp;
        }

        public void display(){
            Link current = first;
            while(current != null){
                current.display();
                current = current.next;
            }
        }
    }

    // класс стека на базе односвязного списка для выполнения задания 4.5
    static class StackList{
        private MyLinkedList list;

        public StackList(){
            list = new MyLinkedList();
        }

        public void push(int value){
            list.insert(value);
        }

        public int pop(){
            return list.delete().value;
        }

        public boolean isEmpty(){
            return list.isEmpty();
        }

        public void display(){
            list.display();
        }
    }

    // класс очереди на базе односвязного списка для выполнения задания 4.5
    static class MyQueue{
        private MyLinkedList myQueue;

        public MyQueue(){
            myQueue = new MyLinkedList();
        }

        public void insert(int value){
            myQueue.insert(value);
        }

        public int delete(){
            return myQueue.delete().value;
        }

        public boolean isEmpty(){
            return myQueue.isEmpty();
        }

        public void display(){
            myQueue.display();
        }
    }
}
