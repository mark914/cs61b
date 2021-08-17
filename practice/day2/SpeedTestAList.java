public class SpeedTestAList {
    public static void main(String[] args) {
        AList<Integer> L = new AList<Integer>();
        int i = 0;
        while(i < 100000) {
            L.addLast(i);
            i += 1;
        }
    }
}
