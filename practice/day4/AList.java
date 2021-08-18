/** Array based list.
 * @autor zju
 */

/* Invariants:
    addLast: The next item we want to add, will be equal to position size.
    getLast: The item we want to return is in position size-1.
    size: The number of items in the list should be size.
 */



public class AList<Item> implements List61B<Item>{
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
    @Override
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size + 1);
        }
        items[size] = x;
        size += 1;
    }


    @Override
    public Item getLast() {
        return items[size-1];
    }

    @Override
    public Item get(int i) {
        return items[i];
    }

    @Override
    public int size() {
        return size;
    }

    /** Delect item from the back of the list and
     * returns delected item.
     */

    @Override
    public Item removeLast() {
        Item last = items[size-1];
        items[size-1] = null;
        size -= 1;
        return last;
    }

    @Override
    public void insert(Item x, int position){
        Item[] newItems = (Item[]) new Object[items.length+1];

        System.arraycopy(items, 0, newItems, 0, position);
        newItems[position] = x;

        System.arraycopy(items, position, newItems, position+1, items.length - position);
        items = newItems;
    }

    /**
     * Inserts an item at the front.
     */
    @Override
    public void addFirst(Item x) {
        insert(x, 0);
    }

    /**
     * Gets an item from the front.
     */
    @Override
    public Item getFirst() {
        return get(0);
    }




    public static void main(String[] args) {
        AList A = new AList();
        A.addLast(1);
        System.out.println(A.size());
        A.removeLast();
        System.out.println(A.size());

    }

}