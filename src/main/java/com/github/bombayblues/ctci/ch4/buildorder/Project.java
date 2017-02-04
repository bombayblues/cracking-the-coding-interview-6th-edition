package com.github.bombayblues.ctci.ch4.buildorder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Encapsulates project
 */

public class Project {

    private final List<Project> children = new ArrayList<Project>();
    private final Map<String, Project> map = new HashMap<String, Project>();

    private final String name;

    private int dependencies = 0;

    public Project(final String name) {
        this.name = name;
    }

    public void incrementDependencies() {
        this.dependencies++;
    }

    public void decrementDependencies() {
        this.dependencies--;
    }

    public void addNeighbor(final Project node) {
        if (!this.map.containsKey(node.getName())) {
            this.children.add(node);
            this.map.put(node.getName(), node);
            node.incrementDependencies();
        }
    }

    public String getName() {
        return this.name;
    }

    public List<Project> getChildren() {
        return this.children;
    }

    public int getDependencies() {
        return this.dependencies;
    }
}
