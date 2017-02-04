package com.github.bombayblues.ctci.ch5;

import java.util.Stack;

/**
 * Ideally this should be named
 */
public class TowerOfHanoi {

    private final Tower[] towers = new Tower[3];

    public TowerOfHanoi(final int numberOfDisks) {
        for (int i = 0; i < 3; i++) {
            this.towers[i] = new Tower();
        }

        for (int i = numberOfDisks - 1; i >= 0; i--) {
            this.towers[0].add(i);
        }
    }

    public void solve(final int disks) {
        this.towers[0].moveDisks(disks, this.towers[2], this.towers[1]);
    }

    public Tower[] getTowers() {
        return this.towers;
    }

    public static class Tower {


        public Stack<Integer> getDisks() {
            return this.disks;
        }

        private final Stack<Integer> disks;

        public Tower() {
            this.disks = new Stack<Integer>();
        }

        public void add(final int disk) {
            if (!this.disks.isEmpty() && this.disks.peek() <= disk) {
                throw new IllegalStateException("We cannot place bigger disk on top of smaller disk");
            } else {
                this.disks.push(disk);
            }
        }

        public void moveTopTo(final Tower tower) {
            final int disk = this.disks.pop();
            tower.add(disk);
        }

        public void moveDisks(final int index, final Tower destination, final Tower buffer) {
            if (index > 0) {
                // Move top n-1 disks from origin to buffer, using destination as a buffer
                moveDisks(index - 1, buffer, destination);
                // Move disk to destination
                moveTopTo(destination);
                // Move top n-1 disks from buffer to destination, using origin as a buffer
                buffer.moveDisks(index - 1, destination, this);
            }
        }
    }
}
