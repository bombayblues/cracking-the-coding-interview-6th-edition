package com.github.bombayblues.ctci.ch4;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by @author bombayblues on 1/31/17.
 */

public class MyGraph {

    private List<Node> nodes;

    public MyGraph() {
        this.nodes = new LinkedList<Node>();
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public void setNodes(final List<Node> nodes) {
        this.nodes = nodes;
    }

    public void addNode(final Node node) {
        this.nodes.add(node);
    }
}
