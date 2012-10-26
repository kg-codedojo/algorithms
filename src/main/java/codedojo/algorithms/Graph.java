import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Graph {
    private  Map<Integer,List<Integer>> vertices = new HashMap<Integer, List<Integer>>();
    private int [][]  edges;
    public Graph(int[][] edges) {
        this.edges = edges;
        for(int idx = 0; idx < edges.length;idx++){


            if(!vertices.containsKey(edges[idx][0])){
                vertices.put(edges[idx][0],new ArrayList<Integer>());
            }
            vertices.get(edges[idx][0]).add(idx);
            if(!vertices.containsKey(edges[idx][1])){
                vertices.put(edges[idx][1],new ArrayList<Integer>());
            }
            vertices.get(edges[idx][1]).add(idx);
            idx++;
        }
    }


    public Map<Integer,List<Integer>> getVertices() {
        return this.vertices;
    }


    public int [][] getEdges() {
        return this.edges;
    }


    public void cut() {
        //To change body of created methods use File | Settings | File Templates.
    }
}

