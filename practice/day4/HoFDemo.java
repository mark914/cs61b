public class HoFDemo {
    public static int do_twice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }
    public static void main(String[] args) {
        IntUnaryFunction tenX = new TenX();
        System.out.print(do_twice(tenX, 2));

    }
}
