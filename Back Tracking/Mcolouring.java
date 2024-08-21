import java.util.*;
/*
 * Problem Statement: graphiven an undirected graph and a number m, 
 * determine if the graph can be colored with at most m colors such that no 
 * two adjacent vertices of the graph are colored with the same color.

Examples:

Example 1:
Input: 
N = 4
M = 3
E = 5
Edges[] = {
  (0, 1),
  (1, 2),
  (2, 3),
  (3, 0),
  (0, 2)
}

Output: 1

Explanation: It is possible to colour the given graph using 3 colours.

Example 2:

Input: 
N = 3
M = 2
E = 3
Edges[] = {
  (0, 1),
  (1, 2),
  (0, 2)
}

Output: 0


Explanation: It is not possible to color.
 */
public class Mcolouring {

  public static boolean isSafe(int node, List <Integer> [] graph, int [] color, int n, int col) {
    for(int item: graph[node]) {
      if(color[item] == col) return false;
    }
    return true;
  }

  public static boolean solve(int node, List <Integer> [] graph, int [] color, int n, int m) {
    if(node == m) return true;

    for(int i = 1; i <= n; i ++) {
      if(isSafe(node, graph, color, n, i)) {
        color[node] = i;
        if(solve(node + 1, graph, color, n, m)) return true;
        color[node] = 0;
      }
    }
    return false;
  }

  public static boolean graphColoring(List <Integer> [] graph, int [] color, int i, int m) {
    return solve(i, graph, color, graph.length,m);
  }

    public static void main(String [] args) {
        int n = 4, m = 3;
        List <Integer> [] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList < > ();
        }
        graph[0].add(1);
        graph[1].add(0);
        graph[1].add(2);
        graph[2].add(1);
        graph[2].add(3);
        graph[3].add(2);
        graph[3].add(0);
        graph[0].add(3);
        graph[0].add(2);
        graph[2].add(0);
        int[] color = new int[n];
        boolean ans = graphColoring(graph, color, 0, m);
        if (ans == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}