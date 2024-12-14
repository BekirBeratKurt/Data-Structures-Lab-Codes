public class Test {
    public static void main(String[] args) throws Exception {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 1);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.displayGraph();
        System.out.println(graph.vertexCount());
        for (int i = 0; i < graph.vertexCount(); i++) {
            for (int j = 0; j < graph.vertexCount(); j++) {
                System.out.print(graph.adjacencyMatrix()[i][j]+" ");
            }
            System.out.println();
        }

    }
}