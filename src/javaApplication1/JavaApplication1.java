/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaApplication1;
import javaApplication1.Graph.Node;
import static javaApplication1.Random_Edge_Graph.simple;
import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 *
 * @author jiali
 */
public class javaApplication1 {
  
    public static void main(String[] arg){
    
        // this is a test
        // test greedy for 20
        int vSize = 4;
        double p = 0.5;
        while(vSize <= 2048) {
        System.out.println("Greedy: " + vSize +" vertiecs");
        Graph G = simple(vSize,p);
        ArrayList<Integer> MIS = Greedy(G);
        //for(int i=0; i<MIS.size();i++){
        //System.out.println("set Element: " + MIS.get(i));
        //}
        System.out.println("Greedy: the size of an independent Set with a graph that has "
                + vSize + " vertices is: " + MIS.size()+ "");    
        
        vSize = vSize << 1;
        System.out.println("\n");
        /*
        // test reduceD for 10
        System.out.println();
        System.out.println("reduceD: 10 vertices");
        MIS = reduceD(G);
        for(int i=0; i<MIS.size();i++){
        System.out.println("set Element: " + MIS.get(i));
        }
        System.out.println("reduceD: the size of an independent Set with a graph that has "
                + vSize + " vertices is: " + MIS.size()+ "");
        */
        }
     }
    
    /*
    use greed method to find the maximized independent set by removing the 
    node of minimum degree and add it to the independet set. Then delete all
    its neighbors from the priority queue to avoid picking the wrong nodes
    */
 
    public static ArrayList<Integer> Greedy(Graph G){
    PriorityQueue<Node> npq = G.priorityNodeQ;
    ArrayList<Integer> independentSet = new ArrayList<>();
   
    //initilizae pq
    PriorityQueue<Node> pq = G.priorityNodeQ;
    for(int i=0;i< G.nodeList.size();i++){
     pq.add(G.nodeList.get(i));
    }
    //System.out.println("print PriorityQ:");
    //System.out.println("NPQ size: " + pq.size());
    //System.out.println("NPQ: "+npq.toString());
    //printNPQ(npq);
    //printDegree(G);
    while(!pq.isEmpty()){
    Node n = pq.poll();
    independentSet.add(n.nodeVal);
    //G.nodeList.remove(n);
    // remove all the neighbors
      //System.out.println("print removed nodes from the graph");
      //System.out.println("removed node: "+ n.nodeVal);
      //System.out.println("degree: " + n.degree);
      for(int i=0; i<n.neighbors.size();i++){
          Node neighbor = n.neighbors.get(i);
          npq.remove(neighbor);
          //G.nodeList.remove(neighbor);
          //print removed nodes
          //System.out.println( neighbor.nodeVal +" ");
      }
      //print degrees
      //printDegree(G);
      //add the vertex index to independentSet
    }
    return independentSet;
    }
    
    /*
    public static ArrayList<Integer> reduceD(Graph G){
    PriorityQueue<Node> npq = G.priorityNodeQ;
    ArrayList<Integer> independentSet = new ArrayList<>();
    
    //print npq
    System.out.println("print PriorityQ:");
    //printNPQ(npq);
    printDegree(G);
    while(!npq.isEmpty()){
    Node n = npq.poll();
    G.nodeList.remove(n);
    // remove all the neighbors
      System.out.println("removed nodes from the graph");
      System.out.println("removed node: "+ n.nodeVal);
      System.out.println("degree: " + n.degree);
      for(int i=0; i<n.neighbors.size();i++){
          Node neighbor = n.neighbors.get(i);
          npq.remove(neighbor);
          G.nodeList.remove(neighbor);
          neighbor.breakConnections(neighbor);
          //print removed nodes
          System.out.println("neighbor: "+ neighbor.nodeVal + " ");
      }
      // print degrees
      printDegree(G);
      //add the vertex index to independentSet
      independentSet.add(n.nodeVal);
    }
    return independentSet;
    }
    */
    //print vertices versus degrees
    private static void printDegree(Graph G){
      for(int i=0; i<G.nodeList.size(); i++){
        Node n = G.nodeList.get(i);
        System.out.println("node: " + n.nodeVal + " degree: "+ n.degree);
      }
    }
      
    }

