package algoritm_lesson_7;

import java.util.*;

public class GraphImpl implements Graph {

    private final List<Vertex> vertexList;
    private final Integer[][] adjMatrix;

    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new Integer[maxVertexCount][maxVertexCount];
    }

    @Override
    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
    }

    @Override
    public boolean addEdge(String startLabel, String secondLabel, int way) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = way; // Длина пути
        return true;
    }

    private int indexOf(String label) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (vertexList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }


    @Override  // Метод добавления связей между вершинами
    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        for (int i = 0; i < getSize(); i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j] != null) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    @Override
    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        int wayKm=0;
        int totalWay=0;
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        Vertex startVertex = vertex;                                //сохраняем стартовый узел
        Vertex endVertex = null;                                    //сохраняем конечный узел
        Vertex tmpVertex;
        List<LinkedList> setWays = new LinkedList<>();              //Создаем список сетов путей
        LinkedList<Vertex> wayList = new LinkedList<>();            //Переменная для сохранения сета путей
        List<Integer> totalWayList = new LinkedList<>();            //Создаем список содержащий набор расстояний

        visitedVertex(stack, vertex);                               //посещаем первый узел - Москву
//        wayList.add(vertex);
        while (!stack.isEmpty()) {
            tmpVertex = vertex;
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                if(tmpVertex!=null) {                                 // если есть следующий не посещенный узел
                    wayKm = adjMatrix[indexOf(tmpVertex.getLabel())][indexOf(getNearUnvisitedVertex(tmpVertex).getLabel())];
                    wayList.add(tmpVertex);
                }
                totalWay += wayKm;                                    // сохраняем полный путь
                System.out.print(" "+wayKm+" ");                      // вычисление пути по матирце ребер
                visitedVertex(stack, vertex);
                if(vertex.getLabel().equals("Воронеж")){              // Добавим условие для поиска
                    wayList.add(vertex);
                    setWays.add(wayList);                             // если мы дошли до конечной точке сохраняем набор в сете наборов
                    wayList = new LinkedList<>();                                  // и очищаем список узлов
                    endVertex = vertex;                               // дойдя до конца сохраним вершину конца
                    System.out.println("totalWay "+totalWay);
                    totalWayList.add(totalWay);                       // сохраняем в списке расстояние для маршрута
                    totalWay=0;
                    if(getNearUnvisitedVertex(startVertex)!=null)     // если не осталось не посещенных узлов
                        wayKm=adjMatrix[indexOf(startVertex.getLabel())][indexOf(getNearUnvisitedVertex(startVertex).getLabel())];
                }

            } else {
                stack.pop();
                if(!stack.isEmpty() && stack.peek().getLabel().equals("Москва")){     //если в стеке 1 элемент Москва
                    endVertex.setVisited(false);
                    System.out.println("");
                    stack.pop();
                    wayList.add(startVertex);                           // если начинаем новый сет то добавляем в него стартовый город
                    if(getNearUnvisitedVertex(startVertex)==null){      // если после Москвы нет непосещенных узлов то выходим из цикла
                        System.out.println("Все пути расчитанны");
                        break;
                    }
                    visitedVertex(stack,startVertex);
                }
            }

        }
        System.out.println();
        analizeShortWay(setWays, totalWayList);
    }

    //метод анализа кратчайшего маршрута
    private void analizeShortWay(List<LinkedList> setWays,List<Integer> totalWayList) {
        int indexSet=0;
        int totalWay=totalWayList.get(0);                               // возьмем длину пути первого сета за основу
        Object ver;
        for(int i=0; i<totalWayList.size(); i++){
            if(totalWayList.get(i)<=totalWay){
                totalWay=totalWayList.get(i);
                indexSet=i;
            }
        }
        System.out.print("Наилучший маршрут: ");
        for (int i=0; i<setWays.get(indexSet).size();i++){
           ver = setWays.get(indexSet).get(i);
           System.out.print(((Vertex) ver).getLabel()+" ");
        }
        System.out.println("\nРасстояние - "+totalWay+" км.");
    }


    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        int currentIndex = vertexList.indexOf(vertex);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] !=null && !vertexList.get(i).isVisited()) {  // если есть связь с узлом и он не посещен то возвращаем Узел
                return vertexList.get(i);
            }
        }
        return null;
    }

    private void visitedVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        stack.add(vertex);
        vertex.setVisited(true);
        }

    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.print(vertex.getLabel() + " ");
        queue.add(vertex);
        vertex.setVisited(true);
    }

    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Vertex> queue = new LinkedList<>();
        Vertex vertex = vertexList.get(startIndex);

        visitedVertex(queue, vertex);
        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitedVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }
}
