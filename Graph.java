import java.util.ArrayList;
import java.util.List;

public class Graph {

    ArrayList<List<Integer>> verticesInfo;

    public Graph(ArrayList<List<Integer>> verticesInfo) {
        this.verticesInfo = verticesInfo;
    }

    void addEdge(int a, int b) {
        verticesInfo.get(a).add(b);
        verticesInfo.get(b).add(a);
    }

    List<Integer> next(int a) {
        return verticesInfo.get(a);
    }

    int size() {
        return verticesInfo.size();
    }
}
