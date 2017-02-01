package com.github.bombayblues.ctci.ch4;

import java.util.LinkedList;
import java.util.List;

/**
 * Node representation for easy graph solutions...
 */
public class Node {

    /**
     * Data
     */
    private String name;

    /**
     * List of all adjacent nodes
     */
    private List<Node> adjacent;


    public Node(final String name) {
        this.adjacent = new LinkedList<Node>();
        this.name = name;
    }

    public void addAdjacent(final Node node) {
        this.adjacent.add(node);
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public List<Node> getAdjacent() {
        return this.adjacent;
    }

    public void setAdjacent(final List<Node> adjacent) {
        this.adjacent = adjacent;
    }

}
