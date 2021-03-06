package com.github.bombayblues.ctci.ch2;

import java.util.Stack;

/**
 * Utility class for chapter 2 exercise
 */

public class MyLinkedListUtil {

    /**
     * Problem:
     * <p>
     * Return the node which is kth from last.
     * Example when k = 1, we would return the last element, when k = 2, we return the second last, and so on.
     * <p>
     * Solution:
     * <p>
     * <ul>
     * <li>Use two pointers p1 and p2 both starting at head</i>
     * <li>Move p1 to k nodes into the list</i>
     * <li>Now move both pointers simultaneously.</i>
     * <li>Now when p1 hits the end of the list p2 will be at kth from last</i>
     * </ul>
     * <p>
     * <p>
     * Complexity:
     * <p>
     * Time - O(n)
     * Space - O(1)
     *
     * @param k
     * @return
     */
    public static Node kTHToLast(final Node head, final int k) {
        Node p1 = head;
        Node p2 = head;

        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }

    /**
     * Problem:
     * <p>
     * Delete a node in linkedlist given access to only that node.
     * <p>
     * Solution:
     * <p>
     * Given its not the last node, copy the values of next node to this one and eliminate the next node, thus removing current one logically.
     *
     * @param node
     * @return
     */
    public static boolean deleteGivenNode(final Node node) {
        if (node == null || node.next == null) {
            return false;
        }

        node.data = node.next.data;
        node.next = node.next.next;

        return true;
    }

    /**
     * Problem:
     * <p>
     * Check if linked list is a palindrome
     * <p>
     * Example:
     * <p>
     * 0 -> 1 -> 2 -> 1 -> 0
     * <p>
     * Soultion:
     * <p>
     * Reverse the linked list and compare the reversed list with original list.
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(final Node head) {
        final Node reversed = reversedAndClone(head);
        return isEqual(reversed, head);
    }

    private static boolean isEqual(Node one, Node two) {
        while (one != null || two != null) {
            if (one.data != two.data) {
                return false;
            }
            one = one.next;
            two = two.next;
        }
        return one == null && two == null;
    }

    private static Node reversedAndClone(Node head) {
        Node rHead = null;
        while (head != null) {
            final Node node = new Node(head.data);
            node.next = rHead;
            rHead = node;
            head = head.next;
        }
        return rHead;
    }

    /**
     * Problem:
     * <p>
     * Check if linked list is a palindrome
     * <p>
     * Example:
     * <p>
     * 0 -> 1 -> 2 -> 1 -> 0
     * <p>
     * Soultion:
     * <p>
     * <li>Use a fast and a slow runner.</i>
     * <li>Fast runner is moving 2x the slow</i>
     * <li>We push the data from slow runner onto a stack</i>
     * <li>If runner is not null at the end of the loop, linked list odd number of items so we skip an item from slow runner</i>
     * <li>Finally, we start poping the items from the stack and comparing it against rest of the slow runner</i>
     *
     * @param head
     * @return
     */
    public static boolean isPalindromeWithRunner(final Node head) {
        Node slow = head;
        Node fast = head;

        final Stack<Integer> stack = new Stack<Integer>();

        while (fast != null && fast.next != null) {
            stack.push(slow.data);

            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.data) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    /**
     * Problem:
     * <p>
     * Given two linked lists, find the intersection point (reference)
     * <p>
     * Example:
     * <p>
     * 1 -> 3 -> 5 -> 6 -> 3 -> 7 -> 5 -> 2 -> 1 -> 0
     * # -> # -> # -> # -> # -> 0 -> 1 -> 2 -> 1 -> 0
     * <p>
     * Intersection 2
     * <p>
     * Solution:
     * <p>
     * <ul>
     * <li>If the lists have intersection, they both will have same tail</i>
     * <li>Find the tail and the length of each linked list</i>
     * <li>Start at the start of both linked list</i>
     * <li>Advance the pointer in longer linked list by the difference in length</i>
     * <li> Traverse both list until they have same reference</i>
     * </ul>
     * <p>
     * Complexity:
     * Time - O(A + B) where A and B are lengths or the two linked list
     * Space - O(1) additional space
     *
     * @param aList
     * @param pList
     * @return
     */
    public static Node getIntersectionPoint(final Node aList, final Node pList) {
        int aLength = 0, pLength = 0;
        Node aTail = aList, pTail = pList;


        while (aTail.next != null) {
            aLength++;
            aTail = aTail.next;
        }

        while (pTail.next != null) {
            pLength++;
            pTail = pTail.next;
        }

        if (aTail != pTail) {
            return null;
        }

        Node shorter = (aLength > pLength) ? pList : aList;
        Node longer = (aLength > pLength) ? aList : pList;

        int count = Math.abs(aLength - pLength);

        while (count > 0 && longer != null) {
            longer = longer.next;
            count--;
        }


        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        return longer;
    }

    /**
     * Problem:
     * <p>
     * Loop Detection. Implement an algorithm that returns the node at the begining of the loop
     * <p>
     * Solution:
     * <ul>
     * <li>Create two pointers fast and slow such that fast is 2x ahead of slow</li>
     * <li>When they collide, move slow pointer to the head, leave fast as is</li>
     * <li>Move slow and fast at 1x and return where they collide</li>
     * </ul>
     *
     * @param head
     * @return
     */
    public static Node findBeginingOfLoop(final Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            // Check for collision
            if (fast == slow) {
                break;
            }
        }

        slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast;
    }
}
