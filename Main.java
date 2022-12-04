import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static int size = 6;

    public static void main(String[] args) {

        Graph graph = new Graph(createArrList(size));

        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);

        virusizeMeme(graph, 0);
    }

    public static ArrayList<List<Integer>> createArrList(int size) {
        ArrayList<List<Integer>> arrList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            arrList.add(new LinkedList<>());
        }
        return arrList;
    }

    public static void virusizeMeme(Graph graph, int startUser) {
        int[] visited = new int[size];
        Queue<Integer> sent = new LinkedList<>();
        visited[startUser] = 1;
        sent.add(startUser);
        while (!sent.isEmpty()) {
            int lastViewer = sent.remove();
            for (int i = 0; i < graph.next(lastViewer).size(); i++) {
                int next = graph.next(lastViewer).get(i);
                if (visited[next] != 1) {
                    visited[next] = 1;
                    sent.add(next);
                }
            }
            System.out.println("Последним увидел " + lastViewer);
        }
    }
}
