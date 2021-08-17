/** Array based list.
 * @autor zju
 */

/* Invariants:
    addLast: The next item we want to add, will be equal to position size.
    getLast: The item we want to return is in position size-1.
    size: The number of items in the list should be size.
 */



public class AList<Item> {
    public Item[] items;
    public int size;

    /** Create an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    public void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Insert X into the back of list. */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }



    public Item getLast() {
        return items[size-1];
    }

    public Item get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    /** Delect item from the back of the list and
     * returns delected item.
     */

    public Item removeLast() {
        Item last = items[size-1];
        items[size-1] = null;
        size -= 1;
        return last;
    }

    public static void main(String[] args) {
        AList A = new AList();
        A.addLast(1);
        System.out.println(A.size());
        A.removeLast();
        System.out.println(A.size());

    }





}