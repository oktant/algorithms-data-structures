package com.azerfon;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by oalizada on 12/20/2016.
 */

class Neighbour {
    public int vertexNum;
    public Neighbour next;

    public Neighbour(int vertexNum, Neighbour next) {
        this.vertexNum = vertexNum;
        this.next = next;

    }
}

class Vertex {
    String name;
    Neighbour adjlist;

    public Vertex(String name, Neighbour adjlist) {
        this.name = name;
        this.adjlist = adjlist;
    }
}

public class Graph {
    Vertex[] adjlist;

    public Graph(String file, String type) {
        try {
            Scanner sc = new Scanner(new File(file));
            adjlist = new Vertex[sc.nextInt()];
            for (int v = 0; v < adjlist.length; v++) {
                adjlist[v] = new Vertex(sc.next(), null);

            }


            if (type.equals("directed")) {

                directedGraph(sc);
            } else {
                inDirectedGraph(sc);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void inDirectedGraph(Scanner sc1) {
        while (sc1.hasNext()) {
            String firstName = sc1.next();
            int v1 = returnIndex(firstName);

            String secondName = sc1.next();

            int v2 = returnIndex(secondName);

            adjlist[v1].adjlist = new Neighbour(v2, adjlist[v1].adjlist);

            adjlist[v2].adjlist = new Neighbour(v1, adjlist[v2].adjlist);
        }
    }

    public void directedGraph(Scanner sc) {
        while (sc.hasNext()) {
            String firstName = sc.next();
            int v1 = returnIndex(firstName);

            String secondName = sc.next();

            int v2 = returnIndex(secondName);

            adjlist[v1].adjlist = new Neighbour(v2, adjlist[v1].adjlist);

        }

    }

    public void print() {
        System.out.println();
        for (int v = 0; v < adjlist.length; v++) {
            System.out.print(adjlist[v].name);
            for (Neighbour a = adjlist[v].adjlist; a != null; a = a.next) {
                System.out.print("------> " + adjlist[a.vertexNum].name);

            }
            System.out.println("\n");
        }
    }

    public int returnIndex(String name) {
        for (int v = 0; v < adjlist.length; v++) {
            if (name.equals(adjlist[v].name)) {
                return v;
            }
        }
        return -1;

    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.println("visiting " + adjlist[v].name);
        for (Neighbour s = adjlist[v].adjlist; s != null; s = s.next) {

            if (!visited[s.vertexNum]) {
                System.out.println("\n" + adjlist[v].name + "----" + adjlist[s.vertexNum].name);
                dfs(s.vertexNum, visited);

            }

        }
    }

    public void dfs() {
        boolean[] visited = new boolean[adjlist.length];

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                System.out.println("Starting at " + adjlist[i].name);
                dfs(i, visited);
            }
        }
    }
    public void bfs(){
        boolean[] visited=new boolean[adjlist.length];
        InterfaceQueue<Integer> a=new Queue<Integer>();
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                System.out.println("Starting at " + adjlist[i].name);
                    bfs(i, visited,a);
            }
        }

    }

    private void  bfs(int start, boolean[] visited, InterfaceQueue<Integer> queue){
        visited[start]=true;
        System.out.println("visited "+adjlist[start].name);
        queue.enqueue(start);
        while(!queue.isEmpty()){
            int v=queue.dequeue();
            for(Neighbour nbr=adjlist[v].adjlist; nbr!=null; nbr=nbr.next){
                int vnum=nbr.vertexNum;
                if(!visited[vnum]){
                    System.out.println("visited "+adjlist[vnum].name);
                    visited[vnum]=true;
                    queue.enqueue(vnum);
                }
            }
        }


    }
    public static void main(String[] args) {
        //  Graph a = new Graph("D:\\test.txt", "indirected");
        Graph b = new Graph("D:\\directed.txt", "directed");
        //b.print();
        b.bfs();
        //a.print();
    }
}
