/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaApplication1;

import static javaApplication1.Random_Edge_Graph.bipartite;
import static javaApplication1.Random_Edge_Graph.simple;


/**
 *
 * @author jiali
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // TODO code application logic here
    //the initial value is 4
    int i=4;
    double p = 0.5;
    //repeate the finding algorithm for 10 times
    //i is increased by multiplying with 2 at the end of each loop
    //it won't end until it reaches 2^11
    System.out.println("Time used to find triangle \n");
    while(i <= 2048){
    int n = i;
    //System.out.println("Graph v: " + v);
    //System.out.println("p: " + p);
    Graph randomG = simple(n,p);
    int ra_size = n;
    Graph bipartiteG = bipartite(n,n,p);
    int bi_size = 2*n;
    System.out.println("Random graph: ");
    //start timing for random graph
    long start = System.nanoTime();
    boolean result = find_triangle(ra_size,randomG);
    long time = System.nanoTime() - start;
    // print result
    System.out.printf("when n = "+ n +", the algorithm took  %dns \n", time);
    if(result){
      System.out.println("There exists at least one triangle");
      System.out.println("\n");
    }else{
      System.out.println("There is no triangle in the graph ");
      System.out.println("\n");
    }
    System.out.println();
    System.out.println("Random bipartite graph: ");
    //start timing for bipartite graph
    long start1 = System.nanoTime();
    boolean result1 = find_triangle(bi_size,bipartiteG);
    long time1 = System.nanoTime() - start1;
    
    System.out.printf("when n1 = "+ n +", "+"n2 = " + n
            + " the algorithm took  %dns \n", time1);
    if(result1){
      System.out.println("There exists at least one triangle");
      System.out.println("\n");
    }else{
      System.out.println("There is no triangle in the graph ");
      System.out.println("\n");
    }
    
    i = i << 1;
    
    //test code for simple random graph
    /*int i = 4;
    double p = 0.5;
    Graph G = simple(i,p);
    boolean result = find_triangle(i,G);
    if(result){
    System.out.println("There exists at least one triangle");
    }else{
    System.out.println("There is no triangle in the graph");
    }*/
    
    //test code for bipartite random graph
    /*int i = 4;
    double p = 0.5;
    Graph G = bipartite(i,i,p);
    int size = i*2;
    boolean result = find_triangle(size,G);
    if(result){
    System.out.println("There exists at least one triangle");
    }else{
    System.out.println("There is no triangle in the graph");
    }
    */
    }
    }
    
    
    
    public static boolean find_triangle(int v,Graph G){
    //int num_of_triangle = 0;
    int i;
    int j;
        //for (int i = 0;i < v;i++)
        // for (int j = i+1;j < v;j++)
        //  if (G.matrix[i][j] == 1)
        //if (G.iList.size()!=G.jList.size()){
        //System.out.println("error");
        //return false;
        //}
        int listSize = G.iList.size();
        //System.out.println("actual edge size: " + G.E);
        //System.out.println("ijList size: " + listSize);
        for (int a=0; a < listSize;a++) {   
            //System.out.println("size of iList : " + G.iList.size());
            //System.out.println("vertex i: " + i);
                i = G.iList.get(a);
                j = G.jList.get(a);  
                //System.out.println("edge: ("+i+","+j+")");
                for (int k = 0;k < v;k++){
                    //System.out.println("edge: ("+i+","+j+")");
                    if (G.matrix[i][k] == 1 && G.matrix[j][k] == 1){
                        //num_of_triangle++;
                        //System.out.println("There exists at least one triangle");
                        //System.out.println("edge: ("+i+","+j+")");
                        //System.out.println("vertices of triangle: "+i+ " "+j+" "+k);
                        return true;
                    }
                }
            } 
    //System.out.println("edge: ("+i+","+j+")");    
    //System.out.println("There is no triangle in the graph");
    //System.out.println("number of triangles: " + num_of_triangle);
    return false;
    }
 
    }
    //System.out.println("Number of triangle found: " + num_of_triangle);
    
    //public static void checkdup (int)




