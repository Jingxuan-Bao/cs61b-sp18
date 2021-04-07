public class OffByN implements CharacterComparator {

    // OffByN is a sub class.//
    private int n;

    public OffByN (int N) {
        n = N;
    }

    @Override
    public boolean equalChars (char x, char y) {
        int diff = x - y;
        if (Math.abs(diff) == this.n) {
            return true;
        }
        return false;
    }
}
