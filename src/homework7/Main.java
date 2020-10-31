package homework7;

import java.util.LinkedList;
import java.util.Queue;

//Классы Vertex и Graph - для заданий 7.2, 7.3 и 7.4
class Vertex{
    public char label;
    public boolean wasVisited;

    public Vertex (char label){
        this.label = label;
        this.wasVisited = false;
    }
}

class Graph{
    private final int MAX_VERTICES = 32;
    private Vertex[] vertexList;
    private int[][] adjMat;
    private int size;

    public Graph(){
        vertexList = new Vertex[MAX_VERTICES];
        adjMat = new int[MAX_VERTICES][MAX_VERTICES];
        size = 0;
        for (int i = 0; i < MAX_VERTICES; i++){
            for (int j = 0; j < MAX_VERTICES; j++) {
                adjMat[i][j] = 0;
            }
        }
    }

    public void addVertex(char label){
        vertexList[size++] = new Vertex(label);
    }

    public void addEdge(int start, int end){
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    public void displayVertex(int vertex){
        System.out.println(vertexList[vertex].label);
    }

    public int getAdjUnvisitedVertex(int ver){
        for (int i = 0; i < size; i++) {
            if(adjMat[ver][i] == 1 && vertexList[i].wasVisited == false){
                return i;
            }
        }
        return -1;
    }

    public void dfs(int f){
        vertexList[f].wasVisited = true;

        for (int i = 0; i < size; i++) {
            int v = getAdjUnvisitedVertex(f);
            if(!vertexList[i].wasVisited && v != -1){
                fullDisplayVertex(f,v);
                dfs(i);
            }
        }
    }

    public void fullDisplayVertex(int vertex1, int vertex2){
        System.out.println("Вершины " + vertexList[vertex1].label + "-" + vertexList[vertex2].label);
    }

    public void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        vertexList[0].wasVisited = true;
//        displayVertex(0);
        queue.add(0);
        int v2;
        while(!queue.isEmpty()){
            int v1 = queue.remove();
            while((v2 = getAdjUnvisitedVertex(v1)) != -1){
                vertexList[v2].wasVisited = true;
                displayVertex(v2);
                queue.add(v2);
            }
        }
        for (int i = 0; i < size; i++) {
            vertexList[i].wasVisited = false;
        }
    }
}

public class Main {
    public static void main(String[] args) {

        // Задание 7.1: Приведите пример графа.
        // Ответ: карта метро

        // Задание 7.2: Реализуйте базовые методы графа.
        System.out.println("Задание 7.2. Реализация базовых методов графа. ");
        Graph graph = new Graph();
        graph.addVertex('A');
        graph.addVertex('B');
        graph.addVertex('C');
        graph.addVertex('D');
        graph.addVertex('E');

        graph.addEdge(0,1); //AB
        graph.addEdge(1,2); //BC
        graph.addEdge(0,3); //AD
        graph.addEdge(3,4); //DE

        System.out.print("Вывод вершины под индексом 2: ");
        graph.displayVertex(2);

        // Задание 7.3: В программный код из задания 7.2 добавьте реализацию метода обхода в глубину. Выполните оценку
        // времени с помощью System.nanoTime().
        System.out.println("\nЗадание 7.3. Реализация метода обхода в глубину: ");
        long startTime_7_3 = System.nanoTime();
        graph.dfs(0);
        long executionTime_7_3 = System.nanoTime() - startTime_7_3;
        System.out.println("Время выполнения метода обхода в глубину заняло: " + executionTime_7_3 + " наносекунд");

        // Задание 7.4: В базовом графе из задания 7.2 реализуйте метод обхода в ширину. Выполните оценку времени с
        // помощью System.nanoTime().
        System.out.println("\nЗадание 7.4. Реализация метода обхода в ширину.");
        long startTime_7_4 = System.nanoTime();
        graph.bfs();
        long executionTime_7_4 = System.nanoTime() - startTime_7_4;
        System.out.println("Время выполнения метода обхода в ширину заняло: " + executionTime_7_4 + " наносекунд");
    }
}
