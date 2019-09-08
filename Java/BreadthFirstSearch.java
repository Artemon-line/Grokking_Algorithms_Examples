package Java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import Java.assets.Algorithm;
import Java.assets.Helper;

/**
 * BreadthFirstSearch
 */
public class BreadthFirstSearch implements Algorithm {
    private int steps = 0;
    private Hashtable<String, List<String>> graph;
    private Deque<String> searchQueue;
    private List<String> searched;

    @Override
    public int[] getStats() {
        return new int[] { this.graph.size(), this.steps };
    }

    public BreadthFirstSearch(Hashtable<String, List<String>> graph) {
        this.graph = graph;
    }

    private boolean isSeller(String name) {
        return name.endsWith("m");
    }

    public String search(String name) {
        this.searchQueue = new LinkedList<String>();
        this.searchQueue.addAll(graph.get(name));
        this.searched = new ArrayList<>();
        while (!this.searchQueue.isEmpty()) {
            String person = this.searchQueue.pop();
            this.steps++;
            if (!this.searched.contains(person)) {
                if (this.isSeller(person)) {
                    return person;
                } else {
                    this.searchQueue.addAll(this.graph.get(person));
                    this.searched.add(person);
                }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        Hashtable<String, List<String>> graph = new Hashtable<>();
        graph.put("you", Arrays.asList("alice", "bob", "claire"));
        graph.put("bob", Arrays.asList("anuj", "peggy"));
        graph.put("alice", Arrays.asList("peggy"));
        graph.put("claire", Arrays.asList("thom", "jonny"));
        graph.put("anuj", Collections.emptyList());
        graph.put("peggy", Collections.emptyList());
        graph.put("thom", Collections.emptyList());
        graph.put("jonny", Collections.emptyList());
        
        BreadthFirstSearch algorithm = new BreadthFirstSearch(graph);
        String result = Optional.ofNullable(algorithm.search("you")).orElse("nobody");
        Helper.print(algorithm.getStats());
        System.out.println(result + " is a mango seller!");
    }

}