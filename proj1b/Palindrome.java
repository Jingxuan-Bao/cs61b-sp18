public class Palindrome {


    //Your goal is to now pass this test by correctly implementing wordToDeque.
    // Once you’ve passed the test, move on to the next part of this assignment.
    //Tip: Search the web to see how to get the i-th character in a String.
    //Tip: Inserting chars into a Deque<Character> is just like inserting ints into a LinkedListDeque<Integer>.

    public Deque<Character> wordToDeque(String word) {

        Deque<Character> deque = new LinkedListDeque();

        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    //a method to check whether the string word is palindrome or not.//

    public boolean help(Deque<Character> d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }

        if(d.removeFirst() != d.removeLast()) {
            return false;
        }

        // recursion.//
        return help(d);
    }


    public boolean isPalindrome(String word) {

        Deque<Character> deque = (Deque<Character>) wordToDeque(word);
        return help(deque);
    }

    //In this task, your ultimate goal is to add //
    // a third public method to your Palindrome class with the following signature://


    public boolean isPalindromeHelper(Deque<Character> d, CharacterComparator cc) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        Character first = d.removeFirst();
        Character last = d.removeLast();
        if(cc.equalChars(first,last)) {
            return isPalindromeHelper(d, cc);
        }
        else {
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> d = wordToDeque(word);
        return isPalindromeHelper(d, cc);
    }
}
