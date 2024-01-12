import java.util.HashMap;
import java.util.LinkedHashMap;

public class RomanNumbs {
    public static void main(String[] args){
        System.out.println(fromRoman(toRoman(3999)));

    }

    public static String toRoman(int n){
        LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        
        String result = "";
        int temp = 0;
        for(int i : map.keySet()){
            temp = n / i;
            n %= i;
            while(temp > 0){
                result += map.get(i);
                temp--;
            }
        }
        return result;
    }

    public static int fromRoman(String romanNumeral) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        for(int i = 0; i < romanNumeral.length(); i++){
            if(i + 1 < romanNumeral.length() && map.get(String.valueOf(romanNumeral.charAt(i))) < map.get(String.valueOf(romanNumeral.charAt(i + 1)))){
                if(i + 2 < romanNumeral.length()){
                    result += map.get(romanNumeral.substring(i, i + 2));
                }
                else{
                    result += map.get(romanNumeral.substring(i));
                }
                i++;
            }
            else{
                result += map.get(String.valueOf(romanNumeral.charAt(i)));
            }
        }
        return result;
    }
}
