package com.github.bombayblues.ctci.ch4;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by @author bombayblues on 1/31/17.
 */
public class MyGraphUtil {

    private static final Logger logger = Logger.getLogger(MyGraphUtil.class.getSimpleName());

    /**
     * Problem:
     * Route between two nodes: Implement a solution to find out if theres a rout between given two nodes
     * <p>
     * Solution:
     * Use breadth-first search;
     *
     * @param g
     * @param start
     * @param end
     * @return
     */

    public static boolean hasRouteBetweenNodes(final MyGraph g, final Node start, final Node end) {
        logger.setLevel(Level.OFF);
        if (start == end) {
            return true; // Theres a route since its the same node;
        }
        // Contains nodes which are visited ...
        final Set<Node> visited = new HashSet<Node>();

        // Breadth-First Search works using queuing mechanism
        final LinkedList<Node> queue = new LinkedList<Node>();
        logger.info(String.format("start: %s, end: %s ", start.getName(), end.getName()));
        // Add to queue
        queue.add(start);
        visited.add(start);

        Node qNode;
        // While queue is not empty...
        while (!queue.isEmpty()) {
            qNode = queue.removeFirst();
            logger.info(String.format("Dequeue %s ", qNode.getName()));
            if (qNode != null) {
                for (final Node v : qNode.getAdjacent()) {
                    if (!visited.contains(v)) {
                        if (v == end) {
                            logger.info(String.format("Found %s", v.getName()));

                            return true;
                        } else {
                            logger.info(String.format("Queue %s ", v.getName()));
                            queue.add(v);
                            visited.add(v);
                        }
                    }
                }
            }
        }
        logger.info("Not found");

        return false;
    }
}
