package SwordToOffer.NK52.match;

public class Main {
    public static void main(String[] args) {
        //char[] chars = new char[]{'a','a','a'};
        char[] chars = new char[]{'a'};
        //char[] pattern = new char[]{'a','b','*','a','c','*','a'};
        char[] pattern = new char[]{'a','.'};
        Solution s = new Solution();
        System.out.println(s.match(chars,pattern));

    }
}
