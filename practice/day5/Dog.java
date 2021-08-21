import java.util.Comparator;
public class Dog implements Comparable<Dog> {
    public String name;
    public int size;

    private static class NameComparator implements Comparator<Dog> {
        public int compare(Dog a, Dog b) {
            return  a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator() {
        return new NameComparator();
    }


    public Dog(String n, int s) {
        name = n;
        size = s;
    }




    @Override
    public int compareTo(Dog o) {
        return size - o.size;
    }

    public void bark() {
        System.out.println(name + " sasy:bark");
    }



}
