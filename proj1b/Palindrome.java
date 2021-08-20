public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> charDeque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i += 1) {
            char ithChar = word.charAt(i);
            charDeque.addLast(ithChar);
        }
        return charDeque;
    }



    public boolean isPalindrome(String word) {
        Deque<Character> charDeque = wordToDeque(word);
        return isPalindromeHelper(charDeque);
    }

    public boolean isPalindromeHelper(Deque<Character> charDeque) {
        if (charDeque.size() == 0 || charDeque.size() == 1) {
            return true;
        } else {
            Character first = charDeque.removeFirst();
            Character last = charDeque.removeLast();
            if (first != last) {
                return false;
            }
            return isPalindromeHelper(charDeque);
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> charDeque = wordToDeque(word);
        return isPalindromeHelper2(charDeque, cc);
    }

    public boolean isPalindromeHelper2(Deque<Character> charDeque, CharacterComparator cc) {
        if (charDeque.size() == 0 || charDeque.size() == 1) {
            return true;
        } else {
            Character first = charDeque.removeFirst();
            Character last = charDeque.removeLast();
            if (!cc.equalChars(first, last)) {
                return false;
            }
            return isPalindromeHelper2(charDeque, cc);
        }
    }

}
