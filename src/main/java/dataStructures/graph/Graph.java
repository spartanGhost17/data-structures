package dataStructures.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();
    public boolean addVertex(String vertex) {
        if(this.adjList.get(vertex) == null) {
            this.adjList.put(vertex, new ArrayList<>());
            return true;
        }
        return false;
    }

    public boolean addEdge(String vertex1, String vertex2) {
        if(this.adjList.get(vertex1) != null && this.adjList.get(vertex2) != null) {
            this.adjList.get(vertex1).add(vertex2);
            this.adjList.get(vertex2).add(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeEdge(String vertex1, String vertex2) {
        if(this.adjList.get(vertex1) != null && this.adjList.get(vertex2) != null) {
            this.adjList.get(vertex1).remove(vertex2);
            this.adjList.get(vertex2).remove(vertex1);
            return true;
        }
        return false;
    }

    public boolean removeVertex(String vertex) {
        if(this.adjList.get(vertex) != null) {
            for(String s : this.adjList.get(vertex)) {
                this.adjList.get(s).remove(vertex);
            }
            this.adjList.remove(vertex);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.adjList.toString();
    }
}
