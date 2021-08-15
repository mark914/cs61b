import java.sql.Struct;

public class LinkedListDeque<T> {
    private class StuffNode {
        /** invariants:
         * The sentinel reference always points to a sentinel node.
         * The first item is always at sentinel.next.item.
         * The size variable is always the total number of items that have been added.
         */
        public T item;
        public StuffNode next;
        public StuffNode prev;
        public StuffNode(){

        }
        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private StuffNode sentinel;
    private StuffNode last;
    private int size;

    /**Create the empty list.
     * 要使用空白创建方法，因为你很难说怎么去自己引用自己
     * 空白列表没办法给item赋值，因为这个一个genetic的类别
     * 创建的时候size都是直接赋值的。
     * */

    public LinkedListDeque() {
        sentinel = new StuffNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        last = sentinel;
        size = 0;

    }

//    public LinkedListDeque(T item) {
//        sentinel = new StuffNode();
//        sentinel.prev = sentinel;
//        sentinel.item = item;
//        sentinel.next = sentinel;
//        last = sentinel;
//        size = 1;
//    }

    /** Return the size of the list */
    public int size() {
        return size;
    }
    /** add item in the front of sentinel.
     * prev也要是StuffNote
     * 添加元素的时候要重新建立链接*/
    public void addFirst(T item) {
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        if (size == 0) {
            last = sentinel.next;
        }
        sentinel.next.next.prev = sentinel.next;
        size += 1;

    }

    /** Adds an item of type T to the back of the deque.*/
    public void addLast(T item) {
        last.next = new StuffNode(last, item, sentinel);
        last = last.next;
        sentinel.prev = last;
        size += 1;
    }


    /** Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     * 1.last是否发生改变主要看原来的last是否被改变
     * 2.看哪里的链接被切断了，尽量把它连起来*/
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        T pop = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        if (size == 1){
            last = sentinel;
        }
        sentinel.next.prev = sentinel;
        size -= 1;
        return pop;
    }

    /**  Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.*/
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T pop = last.item;
        last = last.prev;
        last.next = sentinel;
        sentinel.prev = last;
        size -= 1;
        return pop;
    }

    /**Gets the item at the given index,
    *  where 0 is the front, 1 is the next item, and so forth.
    *  If no such item exists, returns null. Must not alter the deque*/
    public T get(int index) {
        /* index < size and index逐渐减小,当index == 0时停止 */
        if (index >= size) {
            return null;
        }
        StuffNode L = sentinel.next;
        while (index!=0) {
            L = L.next;
            index -= 1;
        }
        return L.item;

    }


    /**Same as get, but uses recursion.
     * 使用recursion的时候要用原来的naked type，这样用起来比较舒服，
     * 如果是用循环的话就是比较正常的方式*/
    public T getRecursiveHelper(int index, StuffNode p) {
        if (index == 0) {
            return p.item;
        }
        return getRecursiveHelper(index-1, p.next);
    }


    public T getRecursive(int index) {
      if (index >= size) {
          return null;
      }
      return getRecursiveHelper(index, sentinel.next);
    }
    /** Returns true if deque is empty, false otherwise.*/
    public boolean isEmpty() {
        return size == 0;
    }


    /**Prints the items in the deque from first to last, separated by a space*/
    public void printDeque() {
        if (size == 0) {
            return;
        }
        StuffNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }

    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<Integer>();
        L.addFirst(10);
        System.out.println(L.size());
    }
}
