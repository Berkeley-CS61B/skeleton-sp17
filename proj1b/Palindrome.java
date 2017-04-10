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

    public  static boolean isPalindrome(String word) {
        Deque<Character> dq = new ArrayDequeSolution<>();
        dq = wordToDeque(word);
        return isPalindrome(dq);
    }

    private static boolean isPalindrome(Deque<Character> dq) {
        if (dq.size() <= 1) {
            return true;
        }
        boolean is_last_first_eq = dq.removeFirst() == dq.removeLast();
        return (is_last_first_eq && isPalindrome(dq));
    }
}
