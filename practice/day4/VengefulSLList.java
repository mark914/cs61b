/** SLList with additional operation printLostItems() which print
 * all items that have ever been deleted. */

public class VengefulSLList<Item> extends SLList<Item>{
    SLList<Item> deletdItems;

    public VengefulSLList() {
        super();
        deletdItems = new SLList<Item>();
    }
    public VengefulSLList(Item x) {
        super(x);
        deletdItems = new SLList<Item>();

    }

    @Override
    public Item removeLast() {
        Item x = super.removeLast();
        deletdItems.addLast(x);
        return x;
    }

    public void printLostItems() {
        deletdItems.print();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<Integer>(0);
        vs1.addLast(1);
        vs1.addLast(4);
        vs1.addLast(6);
        vs1.addLast(13);
        //vs1 is now [0, 1, 4, 6, 13]

        vs1.removeLast();
        vs1.removeLast();
        //After deletion, vs1 is: [0, 1, 4]

        //Should print out the number of the fallen
        vs1.printLostItems();
    }
}
