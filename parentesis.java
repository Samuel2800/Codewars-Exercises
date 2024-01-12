import java.util.*;

public class parentesis {
    private static ArrayList<Character> open;
    private static ArrayList<Character> close;

    public static void main(String[] args) {
        System.out.println(validParentheses(")(()))"));
    }

    public static boolean validParentheses(String parens) {
        open = new ArrayList<Character>();
        close = new ArrayList<Character>();
        for (int i = 0; i < parens.length(); i++) {
            char par = parens.charAt(i);
            if (par == '(') {
                open.add(par);
            } else if (par == ')' && close.size() >= open.size()) {
                return false;
            } else if (par == ')') {
                close.add(par);
            }
        }
        return open.size() == close.size();
    }

}
