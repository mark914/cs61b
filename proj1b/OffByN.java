public class OffByN implements CharacterComparator {

    public int num;

    public OffByN(int n) {
        num = n;
    }

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;
        if (Math.abs(diff) == num) {
            return true;
        }
        return false;
    }
}
