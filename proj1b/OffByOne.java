public class OffByOne implements CharacterComparator {

    //Create a class called OffByOne that implements CharacterComparator.
    // OffByone is a sub class.//

    @Override
    public boolean equalChars(char x, char y) {
        int diff = x - y;

        if (Math.abs(diff) == 1) {
            return true;
        }
        return false;
    }
}
