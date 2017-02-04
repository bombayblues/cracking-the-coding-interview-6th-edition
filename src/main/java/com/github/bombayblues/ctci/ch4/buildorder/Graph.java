package com.github.bombayblues.ctci.ch4.buildorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Custom graph class to solve build order problem
 */
public class Graph {

    /**
     * list of projects
     */
    private final List<Project> nodes = new ArrayList<Project>();

    /**
     * Maintains mapping for project name and project
     */
    private final Map<String, Project> map = new HashMap<String, Project>();

    public Project getOrCreateProject(final String name) {
        if (this.map.containsKey(name)) {
            final Project p = new Project(name);
            this.nodes.add(p);
            this.map.put(name, p);
        }

        return this.map.get(name);
    }

    public void addEdge(final String startName, final String endName) {
        final Project start = getOrCreateProject(startName);
        final Project end = getOrCreateProject(endName);

        start.addNeighbor(end);
    }
}
