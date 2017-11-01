package javaApplication1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

 
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

    private final int V;
    //private  Map<Integer, List<Integer>> Adjacency_List;
    int E;
    //PriorityQueue<node> nodelist;
    //private Bag<Node>[] adj;
    //int [][] matrix;
    PriorityQueue<Node> priorityNodeQ;
    ArrayList<Node> nodeList;
    //ArrayList<Integer> iList;
    //ArrayList<Integer> jList;
    Comparator<Node> pqs;
    
   
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
        //iList = new ArrayList<>();
        //jList = new ArrayList<>();
        pqs = new degreeComparator();
        nodeList = new ArrayList<>();
        priorityNodeQ = new PriorityQueue<>(V,pqs);
        //priorityNodeQ = new PriorityQueue<>(V, pqs);
        //initilise adjacent list
        //adj = (Bag<Node>[]) new Bag[V];
        //for (int v = 0; v < V; v++) {
        //    adj[v] = new Bag<Node>();
        //}
        //initialise adjacent matrix
        //add all vertices to the priorityQ
        for (int v = 0; v < V; v++) {
            Node n = new Node(v);
            nodeList.add(n);
           // priorityNodeQ.add(n);
            //System.out.println("growing npq: ");
            //printNPQ(priorityNodeQ);
            //System.out.println("NPQ size: " + priorityNodeQ.size());
        }
            //throw new UnsupportedOperationException("Not supported yet.");//To change body of generated methods, choose Tools | Templates.
       }  

    private static class degreeComparator implements Comparator<Node>{
        @Override
        public int compare(Node a, Node b) {
            if (a.degree < b.degree){
              return -1;
            }
            if (a.degree < b.degree){
              return 1;
            }
            return 0;
   }  
       
   }  
   
    

//Node subclass    
class Node{
int nodeVal;
int degree;
ArrayList<Node> neighbors;

  public Node(int V){
  nodeVal = V;
  neighbors = new ArrayList<>();
  //degree and neghbors
  }

        public Node() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
  
  //get the number of degree 
  public int getDegree() {
        return degree;
    }
  //delete all neighbors and its connections to other nodes
  public void breakConnections(Node neighbor){
      ArrayList<Node> nList = neighbor.neighbors;
      for (int i=0; i <nList.size();i++){
        Node n = nList.get(i);
        n.degree--;
        n.neighbors.remove(neighbor);
      }
  }
  /*
  @Override
  public boolean equals(Object o){
    if (o instanceof Node){
    Node c = (Node)o;
    return nodeVal== c.nodeVal;
    }
  return false;
  } */
    }     
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
        Node vNode = nodeList.get(v);
        //System.out.println("v index: "+ v + " nodeVal: " + vNode.nodeVal);
        Node wNode = nodeList.get(w);
        //System.out.println("w index: "+ w + " nodeVal: " + wNode.nodeVal);
        vNode.neighbors.add(wNode);
        wNode.neighbors.add(vNode);
        vNode.degree++;
        wNode.degree++;
        // print edges pairs
        //System.out.println("( "+ v + " , "+ w + " )");
        /*
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
        */
    }
}

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    
    
    /**
     * Returns the vertices adjacent to vertex {@code v}.
     *
     * @param  v the vertex
     * @return the vertices adjacent to vertex {@code v}, as an iterable
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    /*
    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return adj[v];
    }
    */
    
    
    
  
    
