/**
 * Created by Xiao Shi on 2017/4/10.
 */


public class Palindrome {
    public static Deque<Character> wordToDeque(String word) {
        Deque<Character> dq = new ArrayDequeSolution<>();
        for (int i = 0; i < word.length(); i++) {
            dq.addLast(word.charAt(i));
        }
        return dq;
    }

    private static boolean isPalindrome(Deque<Character> dq, CharacterComparator cc) {
        if (dq.size() <= 1) {
            return true;
        }
        boolean is_last_first_eq = cc.equalChars(dq.removeFirst(), dq.removeLast());
        return (is_last_first_eq && isPalindrome(dq, cc));
    }

    public static boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> dq = wordToDeque(word);
        return isPalindrome(dq, cc);

    }

}
