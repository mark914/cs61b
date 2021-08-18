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

    public int getHelper(int n, IntNode p) {
        if (n == 0){
            return p.item;
        }else {
            return getHelper(n-1, p.next);
        }
    }
    public int get(int n) {
        return getHelper( n, sentinel.next);
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

    /** get the last */

    /** Returns the size of the list. */
    public int size() {

        return size;
    }

    /** 令 p = sentinel.next
     * 如果对p赋予一个新的值，p = new IntNote(20,null),那么原来的链接就会被打断，对p进行改变不会影响
     * 原来的值（这里的等式都支持GRoE）
     * p = p.next，符合GRoE，相当于把next中的地址赋值给p
     * 如果令p.next = new IntNote(20, null)，那么相当于把后面new出来的地址赋值给p.next。
     * 这时候p也会随之发生改变。
     * 你的目的是让地址里面的东西发生改变，而不是让地址发生改变。所以一定要使用p.next = new来进行改变。
     */
    public void insert(int item, int position) {
        if (size == 0) {
            addFirst(item);
        }
        IntNode p = sentinel.next;
        while (position != 1) {
            position -= 1;
            p = p.next;
        }

        p.next = new IntNode(item, p.next);
        size += 1;
    }

    public void reverse() {
        sentinel.next = reverseRecursiveHelper(sentinel.next);
    }
    public IntNode reverseRecursiveHelper(IntNode front) {
        if (front == null || front.next == null) {
            return front;
        }else {
            IntNode reversed = reverseRecursiveHelper(front.next);
            front.next.next = front;
            front.next = null;
            return reversed;
        }
    }

    public void reverseIterative() {
        if (sentinel.next == null || sentinel.next.next == null) {
            return;
        }
        IntNode first =sentinel.next;
        IntNode ptr = first.next;
        sentinel.next.next = null;

        while (ptr != null) {
            IntNode temp = ptr.next;
            ptr.next = first;
            first = ptr;
            ptr = temp;
        }
    }


    public void reverse2() {
        if (sentinel.next == null || sentinel.next.next == null) {
            return;
        }
        IntNode first = sentinel.next;
        IntNode ptr = first.next;
        first.next = null;
        while (ptr != null) {
            IntNode temp = ptr.next;
            ptr.next = first;
            first = ptr;
            ptr = temp;
        }


    }

    public static void main(String[] args){
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList();
        L.addLast(20);
        L.addLast(10);
        L.addLast(5);
        L.addLast(0);
        System.out.println(L.size());
        System.out.println(L.get(1));
        L.reverseIterative();

    }






}
