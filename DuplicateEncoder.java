import java.util.*;
public class DuplicateEncoder {
	public static String encode(String word){
    String duplicate = "";
    HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
    for(int i = 0; i < word.length(); i++){
      char letter = Character.toLowerCase(word.charAt(i));
      if(!counts.containsKey(letter)){
        counts.put(letter, 1);
      }
      else{
        int num = counts.get(letter) + 1;
        counts.put(letter, num);
      }
    }
    for(int j = 0; j < word.length(); j++){
      char letter = Character.toLowerCase(word.charAt(j));
      if(counts.get(letter) > 1){
        duplicate = duplicate + ")";
      }
      else{
        duplicate = duplicate + ")";
      }
    }
    return duplicate;
  }

  public void tester(){
    System.out.println(encode("din"));
    System.out.println(encode("recede"));
    System.out.println(encode("Success"));
    System.out.println(encode("(( @"));
  }
}