package javaApplication1;



/**
 *
 */
public class Random_Edge_Graph {

    private static final class Edge implements Comparable<Edge> {
        private int v;
        private int w;

        private Edge(int v, int w) {
            if (v < w) {
                this.v = v;
                this.w = w;
            }
            else {
                this.v = w;
                this.w = v;
            }
        }

        @Override
        public int compareTo(Edge that) {
            if (this.v < that.v) return -1;
            if (this.v > that.v) return +1;
            if (this.w < that.w) return -1;
            if (this.w > that.w) return +1;
            return 0;
        }
    }

    Random_Edge_Graph() { }

     /**
     * Returns a random simple graph on {@code V} vertices, with an 
     * edge between any two vertices with probability {@code p}. This is sometimes
     * referred to as the Erdos-Renyi random graph model.
     * @param V the number of vertices
     * @param p the probability of choosing an edge
     * @return a random simple graph on {@code V} vertices, with an edge between
     *     any two vertices with probability {@code p}
     * @throws IllegalArgumentException if probability is not between 0 and 1
     */
    public static Graph simple(int V, double p) {
         if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException("Probability must be between 0 and 1");
        Graph G = new Graph(V);
        for (int v = 0; v < V; v++)
            for (int w = v+1; w < V; w++){
                //System.out.println("vertices pair v w: "+ v +" "+w);
                if (StdRandom.bernoulli(p)){
                    //System.out.println("add v: "+v);
                    //System.out.println("add w: "+w);
                    //System.out.println(" v w: "+w);
                    G.addEdge(v, w);
                //System.out.println("addedge v w: "+ v +" "+w);
                }
            }
        return G;
    }
 /**
     * Returns a random simple bipartite graph on {@code V1} and {@code V2} vertices,
     * containing each possible edge with probability {@code p}.
     * @param V1 the number of vertices in one partition
     * @param V2 the number of vertices in the other partition
     * @param p the probability that the graph contains an edge with one endpoint in either side
     * @return a random simple bipartite graph on {@code V1} and {@code V2} vertices,
     *    containing each possible edge with probability {@code p}
     * @throws IllegalArgumentException if probability is not between 0 and 1
     */
     public static Graph bipartite(int V1, int V2, double p) {
        if (p < 0.0 || p > 1.0)
            throw new IllegalArgumentException("Probability must be between 0 and 1");
        int[] vertices = new int[V1 + V2];
        for (int i = 0; i < V1 + V2; i++)
            vertices[i] = i;
        StdRandom.shuffle(vertices);
        Graph G = new Graph(V1 + V2);
        for (int i = 0; i < V1; i++){
            //System.out.println("vertices[i]: "+vertices[i]);
            for (int j = 0; j < V2; j++){
                //System.out.println("vertices pair v w: "+ vertices[i]+" "+vertices[V1+j]);
                if (StdRandom.bernoulli(p)){
                    G.addEdge(vertices[i], vertices[V1+j]);
                //System.out.println("addedge v w: "+ vertices[i] +" "+vertices[V1+j]);
                }
            }
     }
        return G;
    }
}
