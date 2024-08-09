package practice.graphs;

import practice.SortColor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Stream;

public class Graph {
    List<Edge> graph[];
    ArrayList<WeightedEdge> weightedGraph[];
    boolean visited[];
    int vertices = 4;

    public Graph(){

    }
    public Graph(int vertices){
        this.vertices = vertices;
        graph = new List[vertices];
        weightedGraph = new ArrayList[vertices];
        visited = new boolean[vertices];
    }

    public void createGraph(ArrayList<Edge> ... edges){
        for (int i =0; i <edges.length; i++) {
            graph[i] = edges[i];
        }
    }

    public void createWeightedGraph(ArrayList<WeightedEdge> ... edges){
        for (int i =0; i <edges.length; i++) {
            weightedGraph[i] = edges[i];
        }
    }

    public void bfs(int startingPoint){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startingPoint);
        while(!queue.isEmpty()){
            int curr = queue.remove();
            if(!visited[curr]){
                System.out.print(curr + " ");
                visited[curr] = true;
                /*for(int i =0; i< graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    queue.add(e.dest);
                }*/

                graph[curr].stream().forEach((e) -> {
                    queue.add(e.dest);});
            }
        }
    }

    public void dfs(int start) {
        System.out.print(start + " ");
        visited[start] = true;
        for (int i = 0; i < graph[start].size(); i++) {
            Edge e = graph[start].get(i);
            if (!visited[start]) {
                dfs(e.dest);
            }
        }
    }

    public void printAllPaths(int curr, String path, int target){
        if(curr == target){
            System.out.println(path);
            return;
        }
        for(int i = 0; i < graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                visited[curr] = true;
                printAllPaths(e.dest, path+e.dest, target);
                visited[curr] = false;
            }
        }
    }

    boolean existsCycle(int curr, int parent){
        visited[curr] = true;
        for(int i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(visited[e.dest] && e.dest != parent){
                return true;
            }else if(!visited[e.dest]){
                if(existsCycle(e.dest, curr)){
                    return true;
                }
            }
        }
        return false;
    }

    int rottenOranges(int[][] matrix){
        int[][] neighbours = {{0,1},{1,0}, {0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<matrix.length; i++){
            for(int j =0; j< matrix[0].length; j++){
                int time = -1;
                if(matrix[i][j] == 2){
                    q.add(new int[]{i,j});
                    time = 2;
                }
                while(!q.isEmpty()){
                    int[] N = q.remove();
                    int curri = N[0];
                    int currj = N[1];
                    if(matrix[curri][currj] >= 2){
                        //push all adj
                        int initialTime = time;
                        for(int k = 0; k< neighbours.length; k++){
                            int ni = curri + neighbours[k][0];
                            int nj = currj + neighbours[k][1];
                            if(ni < matrix.length && nj < matrix[0].length && ni >=0 && nj >=0){
                                if(matrix[ni][nj] == 1){
                                    time = time == initialTime? time + 1 : time;
                                    matrix[ni][nj] = time;
                                    q.add(new int[]{ni,nj});
                                }
                            }
                        }
                        //time += 1;
                    }
                }
            }
        }
        int maxTime = Integer.MIN_VALUE;
        for(int i = 0; i<matrix.length; i++){
            for(int j =0; j< matrix[0].length; j++){
                if(matrix[i][j] == 1){
                    return -1;
                }
                maxTime = Math.max(maxTime, matrix[i][j]);
            }
        }
        return maxTime - 2;
    }

    void topSortHelper(int curr, Stack<Integer> stack){
        int i;
        visited[curr] = true;
        for(i = 0; i< graph[curr].size(); i++){
            Edge e = graph[curr].get(i);
            if(!visited[e.dest]){
                topSortHelper(e.dest, stack);
            }
        }
        stack.push(curr);
    }

    //1-->2-->3

    String topSort(){
        int i;
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        String sort = "";
        for(i = 0; i< graph.length; i++){
            if(!visited[i]){
                topSortHelper(i, stack);
            }
        }
        while (!stack.isEmpty()){
            sort = stack.pop().toString().concat(sort);
            //stringBuilder.append(stack.pop());
        }
        //return stringBuilder.toString();
        return sort;
    }

    boolean existCycleInDAG(boolean[] recStack, boolean[] visited, int curr){
        if(recStack[curr]){
            return true;
        }
        if(!visited[curr]){
            visited[curr] = true;
            recStack[curr] = true;
            for(int i = 0; i < graph[curr].size(); i++){
                Edge e = graph[curr].get(i);
                if(existCycleInDAG(recStack, visited, e.dest))
                    return true;
            }
            recStack[curr] = false;
        }
        return false;
    }
    public static class Pair{
        int node;
        int dist;

        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    void dijkstraAlgo(boolean visited[], int dist[], PriorityQueue<Pair> pq, int src){
        int v = weightedGraph.length;
        //int[] dist = new int[v];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;
        pq.add(new Pair(src, 0));
        while (!pq.isEmpty()){
            int curr = pq.remove().node;
            if(!visited[curr]){
                visited[curr] = true;
                for(int j = 0; j < weightedGraph[curr].size(); j++){
                    WeightedEdge edge = weightedGraph[curr].get(j);
                    if(dist[edge.dest] > dist[edge.src] + edge.wt){
                        dist[edge.dest] = dist[edge.src] + edge.wt;
                    }
                    if(!visited[edge.dest])
                        pq.add(new Pair(edge.dest, dist[edge.dest]));
                }
            }
        }
        //return dist;
    }

    void bellmonFord(int[] dist, int src){
        int n = weightedGraph.length;
        for(int i = 0; i < n-1; i++){
            for(int j = 0; j< n; j++){
                for(int k=0; k< weightedGraph[j].size(); k++){
                    WeightedEdge e = weightedGraph[j].get(k);
                    if(dist[e.dest] > dist[e.src] + e.wt){
                        dist[e.dest] = dist[e.src] + e.wt;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        /*
                 1----3
                /     |  \
               0      |   5-----6
                \     |  /
                  2----4
         */
        Graph g = new Graph(7);
        ArrayList<Edge> zero = new ArrayList<>();
        zero.add(new Edge(0,1));
        zero.add(new Edge(0,2));

        ArrayList<Edge> one = new ArrayList<>();
        one.add(new Edge(1,0));
        one.add(new Edge(1,3));

        ArrayList<Edge> two = new ArrayList<>();
        two.add(new Edge(2,0));
        two.add(new Edge(2,4));

        ArrayList<Edge> three = new ArrayList<>();
        three.add(new Edge(3,1));
        three.add(new Edge(3,4));
        three.add(new Edge(3,5));

        ArrayList<Edge> four = new ArrayList<>();
        four.add(new Edge(4,3));
        four.add(new Edge(4,2));
        four.add(new Edge(4,5));

        ArrayList<Edge> five = new ArrayList<>();
        five.add(new Edge(5,3));
        five.add(new Edge(3,4));
        five.add(new Edge(3,6));

        ArrayList<Edge> six = new ArrayList<>();
        six.add(new Edge(6,5));

        g.createGraph(zero, one, two, three, four, five, six);

        System.out.println("BFS traversal:");
        for(int i=0; i<g.visited.length; i++){
            if(!g.visited[i]){
                g.bfs(i);
            }
        }

        Graph g1 = new Graph(7);
        g1.createGraph(zero, one, two, three, four, five, six);

        System.out.println();
        System.out.println("DFS traversal:");
        for(int i=0; i<g1.visited.length; i++){
            if(!g1.visited[i]){
                g1.dfs(i);
            }
        }

        Graph g2 = new Graph(7);
        g2.createGraph(zero, one, two, three, four, five, six);

        System.out.println();
        System.out.println("Print all possible path from 0 to 5:");
        g2.printAllPaths(0, "0", 5);


        //Does cycle exists
        Graph g3 = new Graph(7);
        three = new ArrayList<>();
        three.add(new Edge(3,1));

        four = new ArrayList<>();
        four.add(new Edge(4,2));
        four.add(new Edge(4,5));
        g3.createGraph(zero, one, two, three, four, five, six);

        System.out.println();
        System.out.print("Cycle exists in undirected graph:" + g3.existsCycle(0, -1));

        //Rotten oranges
        Graph rottenOranges = new Graph(0);
        int[][] matrix = {{2,1,1},{1,1,0},{0,1,1}};
        int[][] matrix1 = {{0,2}};
        int[][] matrix2 = {{2,1,1},{0,1,1},{1,0,1}};

        System.out.println();
        System.out.print("Time taken to rotten all oranges:");
        System.out.println(rottenOranges.rottenOranges(matrix));
        System.out.print("Time taken to rotten all oranges:");
        System.out.println(rottenOranges.rottenOranges(matrix1));
        System.out.print("Time taken to rotten all oranges:");
        System.out.println(rottenOranges.rottenOranges(matrix2));

        System.out.println();

        //Topological sort

        //0-->1--->2
        //     \
        //      V
        //       3
        Graph dag = new Graph(4);
        zero = new ArrayList<>();
        zero.add(new Edge(0,1));

        one = new ArrayList<>();
        one.add(new Edge(1,2));
        one.add(new Edge(1,3));

        two = new ArrayList<>();
        three = new ArrayList<>();
        dag.createGraph(zero, one, two, three);
        System.out.println("Topological sort: " + dag.topSort());

        //Exist cycle in DAG
        Graph dag1 = new Graph(5);
        zero = new ArrayList<>();
        zero.add(new Edge(0,1));
        zero.add(new Edge(0,4));

        one = new ArrayList<>();
        one.add(new Edge(1,2));

        two = new ArrayList<>();
        two.add(new Edge(2,3));

        three = new ArrayList<>();
        //three.add(new Edge(3, 1));

        four = new ArrayList<>();
        dag1.createGraph(zero, one, two, three, four);
        System.out.println("Exist cycle in DAG: " + dag1.existCycleInDAG(new boolean[5], new boolean[5], 0));

        //Dijkstra's Algo, shortest path from src - dest
        Graph graph2 = new Graph(6);
        WeightedEdge e1 = new WeightedEdge(0,1, 1);
        WeightedEdge e2 = new WeightedEdge(0,3, 2);
        ArrayList<WeightedEdge> n0 = new ArrayList<>();
        n0.add(e1);
        n0.add(e2);

        WeightedEdge e3 = new WeightedEdge(1,2, 3);
        ArrayList<WeightedEdge> n1 = new ArrayList<>();
        n1.add(e3);

        WeightedEdge e4 = new WeightedEdge(3,2, 1);
        WeightedEdge e5 = new WeightedEdge(3,4, 4);
        ArrayList<WeightedEdge> n3 = new ArrayList<>();
        n3.add(e4);
        n3.add(e5);

        WeightedEdge e6 = new WeightedEdge(2,4, 5);
        WeightedEdge e7 = new WeightedEdge(2,5, 1);
        ArrayList<WeightedEdge> n2 = new ArrayList<>();
        n2.add(e6);
        n2.add(e7);

        WeightedEdge e8 = new WeightedEdge(4,5, 4);
        ArrayList<WeightedEdge> n4 = new ArrayList<>();
        n4.add(e8);

        ArrayList<WeightedEdge> n5 = new ArrayList<>();

        graph2.createWeightedGraph(n0, n1, n2, n3, n4, n5);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.dist - b.dist);
        System.out.print("Shortest distance : ");
        int dist[] = new int[6];
        graph2.dijkstraAlgo(new boolean[6], dist, pq, 0);
        System.out.println("Dijkstra's algo: " + Arrays.toString(dist));

        int distbell[] = {0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,};
        graph2.bellmonFord(distbell, 0);
        System.out.println("Bellmon's algo: " + Arrays.toString(dist));
    }
}


