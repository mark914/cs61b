public class IntList{
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using ... recursion! */

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalsize = 0;
        while (p != null) {
            totalsize += 1;
            p = p.rest;
        }
        return totalsize;
    }
    /** Return the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i-1);
    }
    /** skippify method */
    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {
            IntList next = p.rest;
            for (int i = 0; i < n; i ++) {
                if (next == null) {
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            p = p.rest;
            n ++;
        }

    }

    /** Remove Duplicates */
    public static void removeDuplicates(IntList p) {
        while (p != null) {
            IntList next = p.rest;
            int temp = p.first;
            while (next != null) {
                if (temp != next.first){
                    break;
                }
                next = next.rest;
            }
            p.rest = next;
            p = p.rest;
        }
    }



    /** main method */
    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        L = new IntList(5, L);
        L = new IntList(5, L);

        removeDuplicates(L);

        System.out.println(L.get(2));

    }




}