import org.junit.Test;


import java.util.HashMap;
import java.util.Map;


import static org.fest.assertions.Assertions.assertThat;


/**
 * 4 getVertices, 5 getEdges
 */
public class GraphTest {
    @Test public void testInit(){
        int [][] edges = new int[][]{
            {1,2},
            {1,3},
            {2,3},
            {2,4},
            {3,4}
        };
        assertThat(edges.length).isEqualTo(5);
        assertThat(edges[0].length).isEqualTo(2);


        Graph graph = new Graph(edges);
        assertThat(graph.getVertices().size()).isEqualTo(4);
        assertThat(graph.getEdges().length).isEqualTo(5);
    }


    @Test public void testMinCut(){
        Graph graph = new Graph(null);
        graph.cut();
        assertThat(graph.getVertices().size()).isEqualTo(2);
        assertThat(graph.getEdges()[0].length ).isEqualTo(2);
    }
}

