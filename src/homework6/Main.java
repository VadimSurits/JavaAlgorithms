package homework6;

import java.util.Arrays;

// Задание 6.1: Приведите пример использования древовидной структуры.
// Ответ: файловая структура компьютера

// Задание 6.2: Реализуйте класс узла дерева и базовый шаблон дерева с базовыми методами.
// Задание 6.3: Реализуйте методы поиска и вставки узла в дерево.
// Задание 6.4: Реализуйте базовые методы обхода дерева и метода дисплей. Реализуйте поиск максимума и минимума.

//Классы Person, Node и Tree - для заданий 6.2, 6.3, 6.4 и 6.5
class Person{
    public int id;
    public String name;
    public int age;

    public Person(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

class Node{
    public Person person;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.println("ID:" + person.id + " Имя:" + person.name + " Возраст:" + person.age);
    }
}

class Tree{
    private Node root;

    public void insert(Person person){
        Node node = new Node();
        node.person = person;
        if(root == null){
            root = node;
        } else{
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if(person.id < current.person.id){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = node;
                        return;
                    }
                } else{
                    current = current.rightChild;
                    if(current == null){
                        parent.rightChild = node;
                        return;
                    }
                }
            }
        }
    }

    public Node find(int key){
        Node current = root;
        while(current.person.id != key){
            if(key < current.person.id){
                current = current.leftChild;
            } else{
                current = current.rightChild;
            }
            if(current == null){
                return null;
            }
        }
        return current;
    }

    private void pryamoyObhod(Node rootNode){
        if (rootNode != null) {
            rootNode.display();
            pryamoyObhod(rootNode.leftChild);
            pryamoyObhod(rootNode.rightChild);
        }
    }

    private void obratnyObhod(Node rootNode){
        if (rootNode != null) {
            obratnyObhod(rootNode.leftChild);
            obratnyObhod(rootNode.rightChild);
            rootNode.display();
        }
    }

    private void simmetrObhod(Node rootNode){
        if (rootNode != null) {
            simmetrObhod(rootNode.leftChild);
            rootNode.display();
            simmetrObhod(rootNode.rightChild);
        }
    }

    Node min(){
        Node current, last = null;
        current = root;
        while(current !=null){
            last = current;
            current = current.leftChild;
        }
        return last;
    }

     Node max(){
        Node current, last = null;
        current = root;
        while(current !=null){
            last = current;
            current = current.rightChild;
        }
        return last;
    }

    public boolean delete(int id){
        Node current = root;
        Node parent = root;

        boolean isLeftChild = true;

        while(current.person.id != id){
            parent = current;
            if(id < current.person.id){
                isLeftChild = true;
                current = current.leftChild;
            } else{
                isLeftChild = false;
                current = current.rightChild;
            }
            if(current == null){
                return false;
            }
        }
        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            } else if (isLeftChild){
                parent.leftChild = null;
            } else{
                parent.rightChild = null;
            }
        } else if (current.rightChild == null) {
            if(current == null){
                root = current.leftChild;
            } else if(isLeftChild){
                parent.leftChild = current.leftChild;
            } else{
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if(current == null){
                root = current.rightChild;
            } else if(isLeftChild){
                parent.leftChild = current.rightChild;
            } else{
                parent.rightChild = current.rightChild;
            }
        } else{
            Node successor = getSuccessor(current);
            if(current == root){
                root = successor;
            } else if(isLeftChild){
                parent.leftChild = successor;
            } else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node){
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if(successor != node.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }


    public void displayTree(){
        Node current = root;
//        System.out.println("Cимметричный");
        simmetrObhod(root);
//        System.out.println("Прямой");
//        pryamoyObhod(root);
//        System.out.println("Обратный");
//        obratnyObhod(current);
    }
}

//Класс для задания 6.6
class HeapSort{
    private static int heapSize;

    public static void sort(int[] a){
        buildHeap(a);
        while(heapSize > 1){
            swap(a,0,heapSize-1);
            heapSize--;
            heapify(a,0);
        }
    }

    public static void buildHeap(int[] a){
        heapSize = a.length;
        for(int i = a.length/2; i>=0; i--){
            heapify(a,i);
        }
    }

    public static void heapify(int[] a, int i){
        int l = left(i);
        int r = right(i);
        int largest = i;
        if(l < heapSize && a[i] < a[l]){
            largest = l;
        }
        if(r < heapSize && a[largest] < a[r]){
            largest = r;
        }
        if(i != largest){
            swap(a,i,largest);
            heapify(a,largest);
        }
    }

    private static int right(int i){
        return 2*i+2;
    }

    private static int left(int i){
        return 2*i+1;
    }

    private static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

public class Main {
    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.insert(new Person(1,"Vanya",20));
        tree.insert(new Person(2,"Vasya",25));
        tree.insert(new Person(3,"Dima",30));
        tree.insert(new Person(4,"Petya",35));
        tree.insert(new Person(5,"Kolya",40));

        //Задание 6.5: Реализуйте метод удаления узла и выполните оценку времени базовых методов дерева с помощью
        // System.nanoTime().
        System.out.println("Задание 6.5. Выполняем оценку времени базовых методов дерева.");
        long startTime_6_5 = System.nanoTime();
        System.out.println("Метод displayTree");
        tree.displayTree();
        System.out.println("Методы max и min");
        tree.max().display();
        tree.min().display();
        System.out.println("Метод find(3)");
        tree.find(3).display();
        System.out.println("Метод delete(4)");
        tree.delete(4);
        System.out.println("Метод displayTree после метода delete(4)");
        tree.displayTree();
        long executionTime_6_5 = System.nanoTime() - startTime_6_5;
        System.out.println("Время выполнения методов max, min, display, find, delete и displayTree заняло: " +
                " " + executionTime_6_5 + " наносекунд\n");

        // Задание 6.6: Реализуйте на основе массива из задания 2.1 алгоритм пирамидальной сортировки с реализацией
        // бинарной пирамиды. Выполните оценку алгоритма пирамидальной сортировки с помощью System.nanoTime() и сравните
        // с предыдущими алгоритмами сортировки.
        System.out.println("Задание 6.6. Выполняем оценку времени алгоритма пирамидальной сортировки. ");
        int[] arr = new int[]{9,8,2,1,5,6,4,3,10,7};
        System.out.println("Изначальный массив arr:" + Arrays.toString(arr));
        HeapSort heapSort = new HeapSort();
        long startTime_6_6 = System.nanoTime();
        heapSort.sort(arr);
        long executionTime_6_6 = System.nanoTime() - startTime_6_6;
        System.out.println("Отсортированный массив arr:" + Arrays.toString(arr) + "\nВремя выполнения пирамидальной" +
                " сортировки заняло: " + executionTime_6_6 + " наносекунд");

        // Задание 6.7: Приведите пример сбалансированного дерева и его применения.
        // Ответ: Красно-черное дерево. Применение: ассоциативные массивы в большинстве библиотек реализованы именно
        // через красно-черные деревья
    }
}
