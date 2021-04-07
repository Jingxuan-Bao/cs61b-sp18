import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.

    static CharacterComparator offByOne = new OffByOne();

    // try to make a test first.//
    // have passed the tesr. -- work well.//
    @Test
    public void testEqualsCharLower() {
        assertTrue(offByOne.equalChars('a','b'));
    }

}
