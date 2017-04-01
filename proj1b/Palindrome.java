/**
 * Created by Joshua on 2017/3/12.
 */
public class Palindrome {

    /** build a Deque where the characters in the
     *  deque appear in the same order as in the word.
     */
    public static Deque<Character> wordToDeque(String word) {
        // The return deque
        Deque<Character> wordDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            wordDeque.addLast(word.charAt(i));
        }
        return wordDeque;
    }

    /**
     * return true if the given word is a palindrome, and false otherwise.
     */
    public static boolean isPalindrome(String word) {
        // Use recursion to finish this task
        if (word.length() <= 1) {
            return true;
        } else {
            return word.charAt(0) == word.charAt(word.length() - 1) &&
                    isPalindrome(word.substring(1, word.length() - 1));
        }
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        // Use recursion to finish this task
        if (word.length() <= 1) {
            return true;
        } else {
            return cc.equalChars(word.charAt(0), word.charAt(word.length() - 1)) &&
                    isPalindrome(word.substring(1, word.length() - 1), cc);
        }
    }

    public static void main(String[] args) {
//        Deque<Character> wordDeque = wordToDeque("ASDF");
//
//        for (int i = 0; i < wordDeque.size(); i += 1) {
//            System.out.print(wordDeque.get(i) + " ");
//        }
//
        System.out.print(isPalindrome("racecar") + " " + isPalindrome("sadsdf"));
    }
}
