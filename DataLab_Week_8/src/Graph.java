public class Graph<T extends Comparable> {
    private Vertex<T> graphHead;

    public void addVertex(T id) {
        Vertex<T> newVertex = new Vertex<>(id);
        if (graphHead == null) {
            graphHead = newVertex;
        }
        else {
            Vertex<T> iterator = graphHead;
            while (iterator.nextVertex != null) {
                iterator = iterator.nextVertex;
            }
            iterator.nextVertex = newVertex;
        }
    }

    public Vertex<T> findVertex(T id) {
        Vertex<T> iterator = graphHead;
        while (iterator != null) {
            if(iterator.vertexID.compareTo(id) == 0)
                return iterator;
            iterator = iterator.nextVertex;
        }
        return iterator;
    }

    public void addEdge(T startingVertexID, T endingVertexID) throws Exception {
        Vertex<T> startVertex = findVertex(startingVertexID);
        if(startVertex == null)
            throw new Exception("vertex bulunamadı");
        Edge<T> newEdge=new Edge(endingVertexID);
        if(startVertex.edgeLink == null)
            startVertex.edgeLink = newEdge;
        else{
            Edge<T> iterator = startVertex.edgeLink;
            while(iterator.nextEdge != null) {
                iterator = iterator.nextEdge;
            }
            iterator.nextEdge = newEdge;
        }
    }

    public void displayGraph() {
        Vertex<T> iterator = graphHead;
        while (iterator != null) {
            System.out.print(iterator.vertexID);
            Edge<T> iteratorEdge = iterator.edgeLink;
            while (iteratorEdge != null) {
                System.out.print(" -> "+iteratorEdge.vertexID);
                iteratorEdge = iteratorEdge.nextEdge;
            }
            System.out.println();
            iterator = iterator.nextVertex;
        }

    }

    public int vertexCount() {
        Vertex<T> iterator = graphHead;
        int count = 0;
        while (iterator != null) {
            count++;
            iterator = iterator.nextVertex;
        }
        return count;
    }

    public int inDegree(T vertexID) {
        Vertex<T> iterator = graphHead;
        int count = 0;
        if(iterator == null){
            throw new RuntimeException("Graph is Empty");
        }
        while (iterator!= null) {
            Edge<T> iteratorEdge = iterator.edgeLink;
            while(iteratorEdge != null) {
                if(iteratorEdge.vertexID.compareTo(vertexID)==0){
                    count++;
                }
                iteratorEdge = iteratorEdge.nextEdge;
            }
            iterator = iterator.nextVertex;
        }
        return count;
    }

    public int outDegree(T vertexID) throws Exception {
        Vertex<T> iterator = graphHead;
        int count = 0;
        if(iterator == null){
            throw new RuntimeException("Graph is Empty");
        }
        while (iterator != null) {
            if(iterator.vertexID.compareTo(vertexID)==0) {
                Edge<T> iteratorEdge = iterator.edgeLink;
                while (iteratorEdge != null) {
                    count++;
                    iteratorEdge = iteratorEdge.nextEdge;
                }
            }
            iterator=iterator.nextVertex;
        }
        return count;
    }

    public int[][] adjacencyMatrix() {
        int[][] matrix = new int[vertexCount()][vertexCount()];
        Vertex<T> iterator = graphHead;
        int i=0;
        while (iterator != null) {
            Edge<T> iteratorEdge = iterator.edgeLink;
            while (iteratorEdge != null) {
                matrix[i][Integer.parseInt(iteratorEdge.vertexID.toString())]=1;
                iteratorEdge = iteratorEdge.nextEdge;
            }
            i++;
            iterator = iterator.nextVertex;
        }
        return matrix;
    }


}
