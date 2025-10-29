public class Palindrome {

    public Deque<Character> wordToDeque(String word) {
        Deque<Character> str=new LinkedListDeque<>();
        for(int i=0;i<word.length();i++)
        {
            str.addLast(word.charAt(i));
        }
        return str;
    }
    public boolean isPalindrome(String c){
        if(c.length()<=1)
        {
            return true;
        }
        int a=c.length();
        for(int i=0;i<a/2;i++)
        {
            if(c.charAt(i)==c.charAt(a-1-i))
            {
                continue;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public boolean isPalindrome(String word,CharacterComparator<Character> cc)
    {
        if(word.length()<=1) {
            return true;
        }
        for(int i=0;i<word.length()/2;i++)
        {

            if(!cc.equalChars(word.charAt(i),word.charAt(word.length()-i-1)))
            {
                return false;
            }
        }
        return true;
    }
}
