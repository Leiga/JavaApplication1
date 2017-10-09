package javaApplication1;

import java.util.ArrayList;
import java.util.LinkedList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jiali
 */
public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");

    private final int V;
    int E;
    LinkedList<Integer>[] adj;
    int [][] matrix;
    ArrayList<Integer> iList;
    ArrayList<Integer> jList;
   
    /**
     * Initializes an empty graph with {@code V} vertices and 0 edges.
     * param V the number of vertices
     *
     * @param  V number of vertices
     * @throws IllegalArgumentException if {@code V < 0}
     */
    public Graph(int V) {
        if (V < 0) throw new IllegalArgumentException("Number of vertices must be nonnegative");
        this.V = V;
        this.E = 0;
        iList = new ArrayList<>();
        jList = new ArrayList<>();
        matrix = new int[V][V];
        for (int i=0; i< V;i++)
          for(int j= i+1; j<V;j++)
              matrix[i][j] = 0;
        //System.out.println(V);
    }
    


    /**
     * Initializes a new graph that is a deep copy of {@code G}.
     *
     * @param  G the graph to copy
     */
    

    /**
     * Returns the number of vertices in this graph.
     *
     * @return the number of vertices in this graph
     */
    public int V() {
        return V;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int E() {
        return E;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= V)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V-1));
    }

    /**
     * Adds the undirected edge v-w to this graph.
     *
     * @param  v one vertex in the edge
     * @param  w the other vertex in the edge
     * @throws IllegalArgumentException unless both {@code 0 <= v < V} and {@code 0 <= w < V}
     */
    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        E++;
        if (matrix[w][v]==0 && matrix[v][w]==0){
          matrix[v][w] = 1;
          matrix[w][v] = 1;
          //adj[v].add(w);
          //System.out.println("v: "+v);
          //System.out.println("addlList: "+v+" "+w);
          
          //add edge vertex pair v and w respectively  to iList and jList
          iList.add(v);
          jList.add(w);
        }
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    //public int degree(int v) {
    //    validateVertex(v);
    //    return adj[v].size();
    //}


    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    
    }
    
