package algoritm_lesson_7;

/**
 *   Домашнее задание Шевеленко Андрея Александровича к 7 лекции по алгоритмам
 */
public class Main {
    public static void main(String[] args) {
//        testGraph();
        testDfs();
//        testBfs();
    }

//    private static void testGraph() {
//        Graph graph = new GraphImpl(4);
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//
//        graph.addEdge("A", "B", "C");
//        graph.addEdge("B", "C", "D");
//        graph.addEdge("C", "A", "B", "D");
//        graph.addEdge("D", "B", "C");
//
//        System.out.println("Size of graph is " + graph.getSize());
//        graph.display();
//    }


//Обход в глубину
    private static void testDfs() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        // Опеределяем ребра графа (связи между городами) на реальных расстояниях в км по карте
        graph.addEdge("Москва", "Тула", 180);
//        graph.addEdge("Москва", "Тула", 1800);
        graph.addEdge("Москва", "Рязань", 210);
        graph.addEdge("Москва", "Калуга", 180);
        graph.addEdge("Тула", "Липецк", 300);
        graph.addEdge("Липецк", "Воронеж", 130);
        graph.addEdge("Рязань", "Тамбов", 280);
        graph.addEdge("Тамбов", "Саратов", 220);
        graph.addEdge("Саратов", "Воронеж", 510);
        graph.addEdge("Калуга", "Орел", 210);
        graph.addEdge("Орел", "Курск", 160);
        graph.addEdge("Курск", "Воронеж", 230);

        graph.dfs("Москва");
//        graph.display();

    }

    // Обход в Ширину
//    private static void testBfs() {
//        Graph graph = new GraphImpl(10);
//        graph.addVertex("Москва");
//        graph.addVertex("Тула");
//        graph.addVertex("Рязань");
//        graph.addVertex("Калуга");
//        graph.addVertex("Липецк");
//        graph.addVertex("Тамбов");
//        graph.addVertex("Орел");
//        graph.addVertex("Саратов");
//        graph.addVertex("Курск");
//        graph.addVertex("Воронеж");

//        graph.addEdge("Москва", "Тула", "Рязань", "Калуга");
//        graph.addEdge("Москва", "Тула");
//        graph.addEdge("Москва", "Рязань");
//        graph.addEdge("Москва", "Калуга");
//        graph.addEdge("Тула", "Липецк");
//        graph.addEdge("Липецк", "Воронеж");
//        graph.addEdge("Рязань", "Тамбов");
//        graph.addEdge("Тамбов", "Саратов");
//        graph.addEdge("Саратов", "Воронеж");
//        graph.addEdge("Калуга", "Орел");
//        graph.addEdge("Орел", "Курск");
//        graph.addEdge("Курск", "Воронеж");
//
//        graph.bfs("Москва");
//    }
}
