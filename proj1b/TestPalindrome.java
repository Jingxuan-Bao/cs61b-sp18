import org.junit.Test;
import static org.junit.Assert.*;

// use junit library to debug!.//

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    //The isPalindrome method should return true if the given word is a palindrome, and false otherwise.
    //A palindrome is defined as a word that is the same whether it is read forwards or backwards.
    //For example “a”, “racecar”, and “noon” are all palindromes. “horse”, “rancor”,
    // and “aaaaab” are not palindromes. Any word of length 1 or 0 is a palindrome.


    //Tip: As an example, assertFalse(palindrome.isPalindrome("cat"));
    // tests to ensure that “cat” is not considered a palindrome.
    @Test
    public void isPalindrome() {
        String a = " ";
        String a2 = "racecar";
        assertTrue(palindrome.isPalindrome(a));
        assertTrue(palindrome.isPalindrome(a2));
    }
}
