package MorseCode;

import java.util.*;

public class firstMorseCode {

    public static void main(String[] args) {
        decode(".   .");
    }
    
    private static HashMap<String, Character> MorseCode = new HashMap<String, Character>(){{
        put(".--", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
    }};

    public static String decode(String message){
        message = message.trim().replaceAll("   ", "/");
        StringBuilder result = new StringBuilder();
        int init = 0;
        for(int i = 0; i < message.length(); i++){
            if(message.charAt(i) == '/'){
                result.append(MorseCode.get(message.substring(init, i)) + " ");
                init = i + 1;
            }
            else if(message.charAt(i) == ' '){
                result.append(MorseCode.get(message.substring(init, i)));
                init = i + 1;
            }
            else if(i == (message.length() - 1)){
                result.append(MorseCode.get(message.substring(init, i+1)));
            }
        }
        return result.toString();
    }
}
