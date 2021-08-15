import java.awt.desktop.ScreenSleepEvent;

/** An SLList is a list of integers, which hides the terrible truth
 * of th nakedness within.
 */
public class SLList {
    /* recursive structure. */
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    /* the first item  (if it exits) is at sentinel.next.*/
    private IntNode sentinel;
    private int size;

    /** Create an empty SLList. */
    public SLList() {
        sentinel = new IntNode(55, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(55, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the list. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size = size + 1;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Adds x to the end of the list. */

    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        while(p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /** Returns the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args){
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        System.out.println(L.size());
    }













}
