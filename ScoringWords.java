import java.util.*;

public class ScoringWords{

    private static ArrayList<Character> alphabet = new ArrayList<Character>(List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
     'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
     'w', 'x', 'y', 'z'));

    public static void main(String[] args){
        System.out.println(high("ab bc"));
    }

    public static String high(String s){
        String highWord = null;
        int highScore = 0;
        String[] words = s.split("\\s");
        for(String word : words){
            int sum = 0;
            for(int i = 0; i < word.length(); i++){
                sum += (alphabet.indexOf(word.charAt(i)) + 1);
            }
            if(sum > highScore){
                highScore = sum;
                highWord = word;
            }
        }
        return highWord;
    }

}